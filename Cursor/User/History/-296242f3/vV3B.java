import java.util.List;

public class CourseTable {
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";

    public static void printCourseTable(List<Course> courses) {
        System.out.println("Printing table for " + courses.size() + " courses.");
        System.out.printf("%-10s | %-40s | %-30s | %-10s | %-15s | %-15s | %-20s\n",
                "Code", "Course Name", "Professor", "Credits", "Schedule", "Office Hours", "Enrollment Limit");
        System.out.println("-".repeat(150));

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            String color = (i % 2 == 0) ? BLUE : RESET;

            System.out.printf("%s%-10s | %-40s | %-30s | %-10d | %-15s | %-15s | %-20d%s\n",
                    color,
                    course.getCode(),
                    course.getTitle(),
                    course.getAssignedProfessor().getName(),
                    course.getCredits(),
                    course.getSchedule(),
                    course.getOfficeHours(),
                    course.getEnrollmentLimit(),
                    RESET);
        }
    }
}