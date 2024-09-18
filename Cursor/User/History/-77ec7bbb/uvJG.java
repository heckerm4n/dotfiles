import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Student extends User {
    private List<Course> registeredCourses;
    private List<Course> completedCourses;
    private List<Complaint> complaints;
    private int totalCredits;
    private int currentSemester;
    private String branch;
    private double cgpa;
    private Map<Integer, List<Course>> completedCoursesBySemester;

    public Student(String name, String email, String id, String branch) {
        super(name, email, id);
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.totalCredits = 0;
        this.branch = branch;
        this.currentSemester = 3;
        this.completedCoursesBySemester = new HashMap<>();

    }



    public void viewAvailableCourses(Scanner scanner, CourseCatalog courseCatalog) {
        System.out.println("#=---- View Available Courses ----=#");
        System.out.print("Enter the semester to view courses for: ");
        int semester = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Course> availableCourses = courseCatalog.getCoursesForSemester(semester);
        System.out.println("#=---- Available Courses for Semester " + semester + " ----=#");
        CourseTable.printCourseTable(availableCourses);
    }

    public void registerForCourse(Scanner scanner, CourseCatalog courseCatalog) {
        System.out.println("#=---- Register for Course ----=#");
        viewAvailableCourses(scanner, courseCatalog);
        System.out.print("Enter the course code to register: ");
        String courseCode = scanner.nextLine();
        Course course = courseCatalog.getCourse(courseCode);
        
        if (course == null) {
            System.out.println("Invalid course code.");
            return;
        }

        if (course.getSemester() != currentSemester) {
            System.out.println("This course is not available for your current semester.");
            return;
        }
        if (!meetsPrerequisites(course)) {
            System.out.println("You don't meet the prerequisites for this course.");
            return;
        }
        int totalCredits = 0;
        for (Course registeredCourse : registeredCourses) {
            totalCredits += registeredCourse.getCredits();
        }
        if (totalCredits + course.getCredits() > 20) {
            System.out.println("Registering for this course would exceed the credit limit.");
            return;
        }

        registeredCourses.add(course);
        totalCredits += course.getCredits();
        System.out.println("Successfully registered for " + course.getTitle());
    }

    public void viewRegisteredCourses() {
        System.out.println("#=---- View Registered Courses ----=#");
        System.out.println("#=---- Registered Courses ----=#");
        CourseTable.printCourseTable(registeredCourses);
    }

    public void viewCompletedCourses() {
        System.out.println("#=---- View Completed Courses ----=#");
        
        for (int semester : completedCoursesBySemester.keySet()) {
            System.out.println("\nSemester " + semester + " Courses:");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-50s | %-10s | %-5s%n", "Code", "Course Name", "Credits", "Grade");
            System.out.println("-------------------------------------------------------------------------------------");
            
            List<Course> semesterCourses = completedCoursesBySemester.get(semester);
            for (Course course : semesterCourses) {
                System.out.printf("%-10s | %-50s | %-10d | %-5s%n", 
                    course.getCode(), course.getTitle(), course.getCredits(), course.getGrade());
            }
            
            double sgpa = calculateSGPA(semesterCourses);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.printf("Semester GPA: %.2f%n", sgpa);
        }
        
        double cgpa = calculateCGPA();
        System.out.println("\nCumulative GPA: " + String.format("%.2f", cgpa));
    }

    private double calculateSGPA(List<Course> courses) {
        double totalGradePoints = 0;
        int totalCredits = 0;
        for (Course course : courses) {
            totalGradePoints += course.getGradePoints() * course.getCredits();
            totalCredits += course.getCredits();
        }
        return totalCredits > 0 ? totalGradePoints / totalCredits : 0;
    }

    private double calculateCGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;
        for (Course course : completedCourses) {
            totalGradePoints += course.getGradePoints() * course.getCredits();
            totalCredits += course.getCredits();
        }
        return totalCredits > 0 ? totalGradePoints / totalCredits : 0;
    }

    public String getAcademicStanding() {
        double gpa = calculateGPA();
        if (gpa >= 8) return "Excellent";
        if (gpa >= 7) return "Good";
        if (gpa >= 6) return "Satisfactory";
        if (gpa >= 5) return "Fair";
        return "Poor";
    }

    private double calculateGPA() {
        if (completedCourses.isEmpty()) return 0.0;
        double totalGradePoints = 0;
        int totalCredits = 0;
        for (Course course : completedCourses) {
            totalGradePoints += course.getGradePoints() * course.getCredits();
            totalCredits += course.getCredits();
        }
        return totalGradePoints / totalCredits;
    }

    public void dropCourse(Scanner scanner) {
        System.out.println("#=---- Drop Course ----=#");
        viewRegisteredCourses();
        System.out.print("Enter the course code to drop: ");
        String courseCode = scanner.nextLine();
        
        for (Course course : registeredCourses) {
            if (course.getCode().equals(courseCode)) {
                registeredCourses.remove(course);
                totalCredits -= course.getCredits();
                System.out.println("Successfully dropped " + course.getTitle());
                return;
            }
        }
        System.out.println("Course not found in your registered courses.");
    }

    public void trackProgress() {
        System.out.println("#=---- Track Progress ----=#");
        double totalGradePoints = 0;
        int totalCredits = 0;
        for (Course course : completedCourses) {
            totalGradePoints += course.getGradePoints() * course.getCredits();
            totalCredits += course.getCredits();
        }
        cgpa = totalCredits > 0 ? totalGradePoints / totalCredits : 0;
        System.out.println("CGPA: " + String.format("%.2f", cgpa));
        System.out.println("Completed Courses:");
        viewCompletedCourses();
    }
    public void updateGrade(Course course, String grade) {
        if (registeredCourses.contains(course)) {
            course.setGrade(grade);
            registeredCourses.remove(course);
            completedCourses.add(course);
        } else {
            System.out.println("Student is not registered for this course.");
        }
    }
    public void submitComplaint(Scanner scanner) {
        System.out.println("#=---- Submit Complaint ----=#");
        System.out.print("Enter the description of your complaint: ");
        String description = scanner.nextLine();
        Complaint complaint = new Complaint(description);
        complaints.add(complaint);
        System.out.println("Complaint submitted. Status: " + complaint.getStatus());
    }

    public void viewSchedule() {
        System.out.println("#=---- View Schedule ----=#");
        System.out.println("Weekly Schedule:");
        for (Course course : registeredCourses) {
            System.out.println(course.getCode() + " - " + course.getTitle());
            System.out.println("  Professor: " + course.getAssignedProfessor().getName());
            System.out.println("  Schedule: " + course.getSchedule());
            System.out.println("  Location: " + course.getLocation());
            System.out.println();
        }
    }

    private boolean hasCompletedCourse(String courseCode) {
        for (Course course : completedCourses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    private boolean meetsPrerequisites(Course course) {
        for (String prereqCode : course.getPrerequisites()) {
            boolean hasCompleted = false;
            for (Course completedCourse : completedCourses) {
                if (completedCourse.getCode().equals(prereqCode)) {
                    hasCompleted = true;
                    break;
                }
            }
            if (!hasCompleted) {
                return false;
            }
        }
        return true;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    @Override
    public boolean logout() {
        System.out.println("#=---- Logging Out ----=#");

        return true;
    }

    public boolean canRegisterForCourse(Course course) {
        // Check if the course is for the current semester
        if (course.getSemester() != currentSemester) {
            System.out.println("This course is not available for your current semester.");
            return false;
        }

        // Check prerequisites
        if (!meetsPrerequisites(course)) {
            System.out.println("You don't meet the prerequisites for this course.");
            return false;
        }

        // Check if registering for this course would exceed the credit limit
        int totalCredits = 0;
        for (Course registeredCourse : registeredCourses) {
            totalCredits += registeredCourse.getCredits();
        }
        if (totalCredits + course.getCredits() > 20) {
            System.out.println("Registering for this course would exceed the credit limit.");
            return false;
        }

        // Check if the student is already registered for this course
        for (Course registeredCourse : registeredCourses) {
            if (registeredCourse.getCode().equals(course.getCode())) {
                System.out.println("You are already registered for this course.");
                return false;
            }
        }

        return true;
    }

    public void registerForCourse(Course course) {
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }

    public void setEmail(String email) {
        this.email = email;
    }
}