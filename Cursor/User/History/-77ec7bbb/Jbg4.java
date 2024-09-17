import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Student extends User {
    private List<Course> registeredCourses;
    private List<Course> completedCourses;
    private List<Complaint> complaints;
    private int totalCredits;
    private int currentSemester;

    public Student(String name, String email, String id, String branch) {
        super(name, email, id);
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.totalCredits = 0;
        this.branch = branch;
        this.currentSemester = 1;
    }

    public void viewAvailableCourses(CourseCatalog courseCatalog) {
        List<Course> availableCourses = courseCatalog.getCoursesForSemester(currentSemester);
        System.out.println("#=---- Available Courses ----=#");
        for (Course course : availableCourses) {
            System.out.println(course);
        }
    }

    public void registerForCourse(Scanner scanner, CourseCatalog courseCatalog) {
        viewAvailableCourses(courseCatalog);
        System.out.print("Enter the course code to register: ");
        String courseCode = scanner.nextLine();
        Course course = courseCatalog.getCourse(courseCode);
        
        if (course == null) {
            System.out.println("Invalid course code.");
            return;
        }

        if (!course.getPrerequisites().isEmpty()) {
            for (String prereq : course.getPrerequisites()) {
                if (!hasCompletedCourse(prereq)) {
                    System.out.println("You haven't completed the prerequisite: " + prereq);
                    return;
                }
            }
        }

        if (totalCredits + course.getCredits() > 20) {
            System.out.println("You cannot register for this course. Exceeding credit limit.");
            return;
        }

        registeredCourses.add(course);
        totalCredits += course.getCredits();
        System.out.println("Successfully registered for " + course.getTitle());
    }

    public void viewRegisteredCourses() {
        System.out.println("#=---- Registered Courses ----=#");
        for (Course course : registeredCourses) {
            System.out.println(course);
        }
    }

    public void viewCompletedCourses() {
        System.out.println("#=---- Completed Courses ----=#");
        for (Course course : completedCourses) {
            System.out.println(course + " - Grade: " + course.getGrade());
        }
    }
    public String getAcademicStanding() {
        double gpa = calculateGPA();
        if (gpa >= 3.5) return "Excellent";
        if (gpa >= 3.0) return "Good";
        if (gpa >= 2.5) return "Satisfactory";
        if (gpa >= 2.0) return "Fair";
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
        System.out.println("#=---- Academic Progress ----=#");
        if (completedCourses.isEmpty()) {
            System.out.println("No completed courses yet.");
            return;
        }

        double totalGradePoints = 0;
        int totalCreditsEarned = 0;

        for (Course course : completedCourses) {
            totalGradePoints += course.getGradePoints() * course.getCredits();
            totalCreditsEarned += course.getCredits();
        }

        double gpa = totalGradePoints / totalCreditsEarned;
        System.out.printf("Your GPA: %.2f\n", gpa);
        System.out.println("Total Credits Earned: " + totalCreditsEarned);
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
        System.out.println("#=---- Weekly Schedule ----=#");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle() + ": " + course.getSchedule());
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

    @Override
    public boolean logout() {
        System.out.println("#=---- Logging Out ----=#");
        return true;
    }
}