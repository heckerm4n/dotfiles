import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor extends User {
    private List<Course> assignedCourses;

    public Professor(String name, String email, String id) {
        super(name, email, id);
        this.assignedCourses = new ArrayList<>();
    }

    public void manageCourses(Scanner scanner, CourseCatalog courseCatalog) {
        while (true) {
            System.out.println("1. View Assigned Courses");
            System.out.println("2. Update Course Details");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAssignedCourses();
                    break;
                case 2:
                    updateCourseDetails(scanner, courseCatalog);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public void loadAssignedCourses(CourseCatalog courseCatalog) {
        this.assignedCourses = courseCatalog.getCoursesForProfessor(this.getName());
    }

    private void viewAssignedCourses() {
        System.out.println("Assigned Courses:");
        if (assignedCourses.isEmpty()) {
            System.out.println("No courses assigned.");
        } else {
            CourseTable.printCourseTable(assignedCourses);
        }
    }

    private void updateCourseDetails(Scanner scanner, CourseCatalog courseCatalog) {
        viewAssignedCourses(); // Remove the courseCatalog argument here
        System.out.print("Enter the course code to update: ");
        String courseCode = scanner.nextLine();
        
        Course course = assignedCourses.stream()
                .filter(c -> c.getCode().equals(courseCode))
                .findFirst()
                .orElse(null);

        if (course == null) {
            System.out.println("Invalid course code or you are not assigned to this course.");
            return;
        }

        while (true) {
            System.out.println("1. Update Syllabus");
            System.out.println("2. Update Class Timings");
            System.out.println("3. Update Prerequisites");
            System.out.println("4. Update Enrollment Limit");
            System.out.println("5. Update Office Hours");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 6) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter new syllabus: ");
                    course.setSyllabus(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new class timings: ");
                    course.setSchedule(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new prerequisites (comma-separated): ");
                    course.setPrerequisites(List.of(scanner.nextLine().split(",")));
                    break;
                case 4:
                    System.out.print("Enter new enrollment limit: ");
                    course.setEnrollmentLimit(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    break;
                case 5:
                    System.out.print("Enter new office hours: ");
                    course.setOfficeHours(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
        courseCatalog.updateCourse(course);
        System.out.println("Course details updated successfully.");
    }

    public void viewEnrolledStudents(Scanner scanner, CourseCatalog courseCatalog) {
        viewAssignedCourses();
        System.out.print("Enter the course code to view enrolled students: ");
        String courseCode = scanner.nextLine();
        List<Student> enrolledStudents = courseCatalog.getEnrolledStudents(courseCode);
        
        System.out.println("Enrolled Students for " + courseCode + ":");
        for (Student student : enrolledStudents) {
            System.out.println(student);
        }
    }

    @Override
    public boolean logout() {
        System.out.println("#=---- Logging Out ----=#");
        return true;
    }

    public void addAssignedCourse(Course course) {
        assignedCourses.add(course);
    }

    public void removeAssignedCourse(Course course) {
        assignedCourses.remove(course);
    }
}