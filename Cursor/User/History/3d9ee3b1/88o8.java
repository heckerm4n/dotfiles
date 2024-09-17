import java.util.Scanner;
import java.util.List;

public class Admin extends User {
    public Admin(String name, String email, String id) {
        super(name, email, id);
    }

    public void manageCourses(Scanner scanner, CourseCatalog courseCatalog) {
        while (true) {
            System.out.println("1. View Course Catalog");
            System.out.println("2. Add Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    courseCatalog.viewCourses();
                    break;
                case 2:
                    addCourse(scanner, courseCatalog);
                    break;
                case 3:
                    deleteCourse(scanner, courseCatalog);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void addCourse(Scanner scanner, CourseCatalog courseCatalog) {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        System.out.print("Enter credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course newCourse = new Course(code, title, credits, semester, "", null, 0, "");
        courseCatalog.addCourse(newCourse);
        System.out.println("Course added successfully.");
    }

    private void deleteCourse(Scanner scanner, CourseCatalog courseCatalog) {
        System.out.print("Enter course code to delete: ");
        String code = scanner.nextLine();
        if (courseCatalog.removeCourse(code)) {
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void manageStudentRecords(Scanner scanner, CourseCatalog courseCatalog) {
        while (true) {
            System.out.println("1. View Student Records");
            System.out.println("2. Update Student Grades");
            System.out.println("3. Update Student Personal Information");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewStudentRecords(courseCatalog);
                    break;
                case 2:
                    updateStudentGrades(scanner, courseCatalog);
                    break;
                case 3:
                    updateStudentPersonalInfo(scanner, courseCatalog);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void viewStudentRecords(CourseCatalog courseCatalog) {
        List<Student> students = courseCatalog.getAllStudents();
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Completed Courses:");
            student.viewCompletedCourses();
            System.out.println("--------------------");
        }
    }

    private void updateStudentGrades(Scanner scanner, CourseCatalog courseCatalog) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = courseCatalog.getStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = courseCatalog.getCourse(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter grade (A/B/C/D/F): ");
        String grade = scanner.nextLine().toUpperCase();

        if (!grade.matches("[A-DF]")) {
            System.out.println("Invalid grade.");
            return;
        }

        student.updateGrade(course, grade);
        System.out.println("Grade updated successfully.");
    }

    private void updateStudentPersonalInfo(Scanner scanner, CourseCatalog courseCatalog) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = courseCatalog.getStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new email (or press enter to skip): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            student.setEmail(newEmail);
        }

        // Add more fields as needed

        System.out.println("Student information updated successfully.");
    }

    public void assignProfessorsToCourses(Scanner scanner, CourseCatalog courseCatalog) {
        courseCatalog.viewCourses();
        System.out.print("Enter course code to assign professor: ");
        String courseCode = scanner.nextLine();
        Course course = courseCatalog.getCourse(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        List<Professor> professors = courseCatalog.getAllProfessors();
        System.out.println("Available Professors:");
        for (int i = 0; i < professors.size(); i++) {
            System.out.println((i + 1) + ". " + professors.get(i).getName());
        }

        System.out.print("Enter the number of the professor to assign: ");
        int professorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (professorIndex < 0 || professorIndex >= professors.size()) {
            System.out.println("Invalid professor selection.");
            return;
        }

        Professor selectedProfessor = professors.get(professorIndex);
        course.assignProfessor(selectedProfessor);
        System.out.println("Professor " + selectedProfessor.getName() + " assigned to " + course.getTitle());
    }

    public void handleComplaints(Scanner scanner, CourseCatalog courseCatalog) {
        List<Complaint> complaints = courseCatalog.getAllComplaints();

        while (true) {
            System.out.println("1. View All Complaints");
            System.out.println("2. Update Complaint Status");
            System.out.println("3. Filter Complaints");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllComplaints(complaints);
                    break;
                case 2:
                    updateComplaintStatus(scanner, complaints);
                    break;
                case 3:
                    filterComplaints(scanner, complaints);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void viewAllComplaints(List<Complaint> complaints) {
        for (int i = 0; i < complaints.size(); i++) {
            System.out.println((i + 1) + ". " + complaints.get(i));
        }
    }
    public void updateCourseDetails(Scanner scanner, CourseCatalog courseCatalog) {
        System.out.print("Enter course code to update: ");
        String courseCode = scanner.nextLine();
        Course course = courseCatalog.getCourse(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Current course details:");
        System.out.println(course);

        System.out.print("Enter new title (or press enter to skip): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            course.setTitle(newTitle);
        }

        System.out.print("Enter new credits (or press enter to skip): ");
        String newCreditsStr = scanner.nextLine();
        if (!newCreditsStr.isEmpty()) {
            try {
                int newCredits = Integer.parseInt(newCreditsStr);
                course.setCredits(newCredits);
            } catch (NumberFormatException e) {
                System.out.println("Invalid credits value. Skipping credits update.");
            }
        }

        System.out.print("Enter new semester (or press enter to skip): ");
        String newSemesterStr = scanner.nextLine();
        if (!newSemesterStr.isEmpty()) {
            try {
                int newSemester = Integer.parseInt(newSemesterStr);
                course.setSemester(newSemester);
            } catch (NumberFormatException e) {
                System.out.println("Invalid semester value. Skipping semester update.");
            }
        }

        // Add more fields to update as needed

        courseCatalog.updateCourse(course);
        System.out.println("Course details updated successfully.");
    }

    private void updateComplaintStatus(Scanner scanner, List<Complaint> complaints) {
        viewAllComplaints(complaints);
        System.out.print("Enter the number of the complaint to update: ");
        int complaintIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (complaintIndex < 0 || complaintIndex >= complaints.size()) {
            System.out.println("Invalid complaint selection.");
            return;
        }

        Complaint complaint = complaints.get(complaintIndex);
        System.out.print("Enter new status (Pending/Resolved): ");
        String newStatus = scanner.nextLine().toUpperCase();

        if (!newStatus.equals("PENDING") && !newStatus.equals("RESOLVED")) {
            System.out.println("Invalid status.");
            return;
        }

        complaint.setStatus(newStatus);
        System.out.println("Complaint status updated successfully.");
    }

    private void filterComplaints(Scanner scanner, List<Complaint> complaints) {
        System.out.println("1. Filter by Status");
        System.out.println("2. Filter by Date");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                filterComplaintsByStatus(scanner, complaints);
                break;
            case 2:
                filterComplaintsByDate(scanner, complaints);
                break;
            default:
                System.out.println("Invalid selection.");
        }
    }

    private void filterComplaintsByStatus(Scanner scanner, List<Complaint> complaints) {
        System.out.print("Enter status to filter (Pending/Resolved): ");
        String status = scanner.nextLine().toUpperCase();

        for (Complaint complaint : complaints) {
            if (complaint.getStatus().equals(status)) {
                System.out.println(complaint);
            }
        }
    }

    private void filterComplaintsByDate(Scanner scanner, List<Complaint> complaints) {
        System.out.print("Enter date to filter (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        for (Complaint complaint : complaints) {
            if (complaint.getDate().equals(date)) {
                System.out.println(complaint);
            }
        }
    }

    @Override
    public boolean logout() {
        System.out.println("#=---- Logging Out ----=#");
        return true;
    }

    public void viewCourses(CourseCatalog courseCatalog) {
        System.out.println("#=---- Course Catalog ----=#");
        CourseTable.printCourseTable(new ArrayList<>(courseCatalog.getAllCourses()));
    }
}