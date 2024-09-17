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

    private void viewAssignedCourses() {
        System.out.println("#=---- Assigned Courses ----=#");
        for (Course course : assignedCourses) {
            System.out.println(course);
        }
    }

    private void updateCourseDetails(Scanner scanner, CourseCatalog courseCatalog) {
        viewAssignedCourses();
        System.out.print("Enter the course code to update: ");
        String courseCode = scanner.nextLine();
        Course course = courseCatalog.getCourse(courseCode);

        if (course == null || !assignedCourses.contains(course)) {
            System.out.println("Invalid course code or you are not assigned to this course.");
            return;
        }

        System.out.println("1. Update Syllabus");
        System.out.println("2. Update Class Timings");
        System.out.println("3. Update Prerequisites");
        System.out.println("4. Update Enrollment Limit");
        System.out.println("5. Update Office Hours");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter new syllabus: ");
                String syllabus = scanner.nextLine();
                course.setSyllabus(syllabus);
                break;
            case 2:
                System.out.print("Enter new class timings: ");
                String timings = scanner.nextLine();
                course.setSchedule(timings);
                break;
            case 3:
                System.out.print("Enter new prerequisites (comma-separated): ");
                String[] prerequisites = scanner.nextLine().split(",");
                course.setPrerequisites(List.of(prerequisites));
                break;
            case 4:
                System.out.print("Enter new enrollment limit: ");
                int limit = scanner.nextInt();
                course.setEnrollmentLimit(limit);
                break;
            case 5:
                System.out.print("Enter new office hours: ");
                String officeHours = scanner.nextLine();
                course.setOfficeHours(officeHours);
                break;
            default:
                System.out.println("Invalid selection.");
        }
        System.out.println("Course details updated successfully.");
    }

    public void viewEnrolledStudents(Scanner scanner, CourseCatalog courseCatalog) {
        viewAssignedCourses();
        System.out.print("Enter the course code to view enrolled students: ");
        String courseCode = scanner.nextLine();
        Course course = courseCatalog.getCourse(courseCode);

        if (course == null || !assignedCourses.contains(course)) {
            System.out.println("Invalid course code or you are not assigned to this course.");
            return;
        }

        System.out.println("#=---- Enrolled Students for " + course.getTitle() + " ----=#");
        for (Student student : course.getEnrolledStudents()) {
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("ID: " + student.getId());
            System.out.println("Academic Standing: " + student.getAcademicStanding());
            System.out.println("--------------------");
        }
    }

    @Override
    public boolean logout() {
        System.out.println("#=---- Logging Out ----=#");
        return true;
    }
}