import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static void print_prbr() throws InterruptedException {
        int total = 100;
        for (int i = 0; i <= total; i++) {
            progressbar.printProgressBar(i, total);
            Thread.sleep(3);
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        CourseCatalog courseCatalog = new CourseCatalog();
        Credentials credentials = new Credentials();

        while (true) {
            System.out.println("Welcome to the University Course Registration System");
            System.out.println("1. Enter the Application");
            System.out.println("2. Exit the Application");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 2) {
                System.out.println("Exiting the application...");
                break;
            } else if (choice != 1) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("Login as:");
            System.out.println("1. Student");
            System.out.println("2. Professor");
            System.out.println("3. Administrator");
            System.out.print("Enter your choice: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<String> creds = login_manager.login(scanner);
            boolean isAuthenticated = credentials.verify(creds.get(0), creds.get(1));

            if (!isAuthenticated) {
                System.out.println("Wrong credentials! Returning to login menu...");
                continue;
            }
            // System.out.println(creds.get(0));

            System.out.println("\u001B[32m" + "Correct Credentials! Logging in..." + "\u001B[0m");
            print_prbr();

            switch (roleChoice) {
                case 1:
                    handleStudentMenu(credentials, creds.get(0), courseCatalog);
                    break;
                case 2:
                    handleProfessorMenu(credentials, creds.get(0), courseCatalog);
                    break;
                case 3:
                    handleAdminMenu(credentials, creds.get(0), courseCatalog);
                    break;
                default:
                    System.out.println("Invalid role selection. Returning to login menu...");
            }
        }
        scanner.close();
    }

    private static void handleStudentMenu(Credentials credentials, String id, CourseCatalog courseCatalog) {
        List<String> stucreds = credentials.getstucreds(id);
        System.out.println(stucreds.get(0));
        if (stucreds.size() < 4) {
        System.out.println("Error: Insufficient student information.");
            return;
        }
        Student student = new Student(stucreds.get(2), stucreds.get(3), stucreds.get(0), stucreds.get(4));
        System.out.println("Hello " + "\u001B[32m" + stucreds.get(0) + "\u001B[0m");

        while (true) {
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. View Completed Courses");
            System.out.println("5. Drop a Course");
            System.out.println("6. Track Progress");
            System.out.println("7. Submit Complaint");
            System.out.println("8. View Schedule");
            System.out.println("9. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    student.viewAvailableCourses(courseCatalog);
                    break;
                case 2:
                    student.registerForCourse(scanner, courseCatalog);
                    break;
                case 3:
                    student.viewRegisteredCourses();
                    break;
                case 4:
                    student.viewCompletedCourses();
                    break;
                case 5:
                    student.dropCourse(scanner);
                    break;
                case 6:
                    student.trackProgress();
                    break;
                case 7:
                    student.submitComplaint(scanner);
                    break;
                case 8:
                    student.viewSchedule();
                    break;
                case 9:
                    student.logout();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void handleProfessorMenu(Credentials credentials, String id, CourseCatalog courseCatalog) {
        List<String> profcreds = credentials.getprofcreds(id);
        Professor professor = new Professor(profcreds.get(0), profcreds.get(1), profcreds.get(3));
        System.out.println("Hello " + "\u001B[32m" + profcreds.get(0) + "\u001B[0m");

        while (true) {
            System.out.println("1. Manage Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    professor.manageCourses(scanner, courseCatalog);
                    break;
                case 2:
                    professor.viewEnrolledStudents(scanner, courseCatalog);
                    break;
                case 3:
                    professor.logout();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void handleAdminMenu(Credentials credentials, String id, CourseCatalog courseCatalog) {
        List<String> admincreds = credentials.getadmincreds(id);
        Admin admin = new Admin(admincreds.get(0), admincreds.get(1), admincreds.get(3));
        System.out.println("Hello " + "\u001B[32m" + admincreds.get(0) + "\u001B[0m");

        while (true) {
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Student Records");
            System.out.println("3. Assign Professors to Courses");
            System.out.println("4. Handle Complaints");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    admin.manageCourses(scanner, courseCatalog);
                    break;
                case 2:
                    admin.manageStudentRecords(scanner, courseCatalog);
                    break;
                case 3:
                    admin.assignProfessorsToCourses(scanner, courseCatalog);
                    break;
                case 4:
                    admin.handleComplaints(scanner, courseCatalog);
                    break;
                case 5:
                    admin.logout();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
