import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CourseCatalog {
    private Map<String, Course> courses;
    private Map<String, Student> students;
    private Map<String, Professor> professors;
    private List<Complaint> complaints;

    public CourseCatalog() {
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
        this.professors = new HashMap<>();
        this.complaints = new ArrayList<>();
        initializeCourses();
    }

    private void initializeCourses() {
        // Semester 1 courses (no prerequisites)
        addCourse(new Course("MTH100", "Maths I", 4, 1, "Samaresh Chatterjee (V)", null, 600, "09:00-11:00"));
        addCourse(new Course("CSE101", "Introduction to Programming", 4, 1, "B N Jain (V)", null, 600, "11:00-13:00"));
        addCourse(new Course("DES102", "Introduction to HCI", 4, 1, "Rajiv Ratn Shah", null, 600, "14:00-16:00"));
        addCourse(new Course("ECE111", "Digital Circuits", 4, 1, "Pravesh Biyani", null, 600, "16:00-18:00"));
        addCourse(new Course("COM101", "Communication Skills", 2, 1, "Payel C Mukherjee (V)", null, 600, "09:00-11:00"));

        // Semester 2 courses (no prerequisites)
        addCourse(new Course("BIO101", "Foundations of Biology", 4, 2, "Sriram K.", null, 300, "09:00-11:00"));
        addCourse(new Course("CSE102", "Data Structures and Algorithms", 4, 2, "Ojaswa Sharma", null, 300, "11:00-13:00"));
        addCourse(new Course("CSE112", "Computer Organisation", 4, 2, "Sujay Deb", null, 300, "14:00-16:00"));
        addCourse(new Course("CSE140", "Introduction to Intelligent Systems", 4, 2, "Jainendra Shukla", null, 300, "16:00-18:00"));
        addCourse(new Course("DES101", "Design Drawing and Visualization", 4, 2, "Anoop Ratn (V)", null, 300, "09:00-12:00"));
        addCourse(new Course("DES202", "Visual Design & Communication", 4, 2, "Anoop Ratn (V)", null, 300, "13:00-15:00"));
        addCourse(new Course("ECE113", "Basic Electronics", 4, 2, "Tammam Tillo", null, 300, "15:00-17:00"));
        addCourse(new Course("MTH201", "Probability and Statistics", 4, 2, "Subhajit Ghosechowdhury", null, 300, "09:00-11:00"));
        addCourse(new Course("SOC101", "Introduction to Sociology and Anthropology", 4, 2, "Deepak Prince", null, 300, "11:00-13:00"));
        addCourse(new Course("SSH101", "Critical Thinking and Readings in Social Sciences", 4, 2, "Aasim Khan", null, 300, "14:00-16:00"));
        addCourse(new Course("SSH101 (Priyadarshi)", "Critical Thinking and Readings in Social Sciences", 4, 2, "Priyadarshi", null, 300, "16:00-18:00"));
        addCourse(new Course("ECO223", "Money and Banking", 4, 2, "Kiriti Kanjilal", null, 300, "09:00-11:00"));

        // Semester 3 courses (some with prerequisites)
        addCourse(new Course("BIO211", "Cell Biology and Biochemistry", 4, 3, "Jaspreet Kaur", "BIO101", 70, "09:00-11:00"));
        addCourse(new Course("BIO214", "Genetics and Molecular Biology", 4, 3, "Gaurav Ahuja", "BIO101", 70, "11:00-13:00"));
        addCourse(new Course("CSE121", "Discrete Mathematics", 4, 3, "Bapi Chatterjee", "MTH100", 70, "14:00-16:00"));
        addCourse(new Course("CSE201", "Advanced Programming", 4, 3, "Arun Balaji Buduru", "CSE101", 70, "16:00-18:00"));
        addCourse(new Course("CSE231", "Operating Systems", 4, 3, "Vivek Kumar", "CSE102", 70, "09:00-12:00"));
        addCourse(new Course("DES201", "Design Processes and Perspectives", 4, 3, "Anmol Srivastava", null, 70, "13:00-15:00"));
        addCourse(new Course("MTH203", "Math III", 4, 3, "Satish Pandey", "MTH100", 70, "15:00-17:00"));
        addCourse(new Course("MTH210", "Discrete Structures", 4, 3, "Ashish Kumar Pandey", "MTH100", 70, "09:00-11:00"));
        addCourse(new Course("MTH211", "Number Theory", 4, 3, "Debika Banerjee", "MTH100", 70, "11:00-13:00"));
        addCourse(new Course("MTH240", "Real Analysis I", 4, 3, "Nabaneita Ray", "MTH100", 70, "14:00-16:00"));
        addCourse(new Course("ECE215", "Circuit Theory and Devices", 4, 3, "Pragya Kosta", "ECE111", 70, "16:00-18:00"));
        addCourse(new Course("ECE250", "Signals & Systems", 4, 3, "Anubha Gupta", "MTH100", 70, "09:00-11:00"));
        addCourse(new Course("ECE270", "Embedded Logic Design", 4, 3, "Sumit Darak", "ECE111", 70, "11:00-13:00"));
        addCourse(new Course("SSH201", "Research Methods in Social Sciences and Design", 4, 3, "Mrinmoy Chakrabarty", null, 70, "14:00-16:00"));
        addCourse(new Course("ENT201", "Foundations of Entrepreneurship", 4, 3, "Anupam Saronwala", null, 70, "16:00-18:00"));
        addCourse(new Course("ENT202", "Social Entrepreneurship", 4, 3, "Jyoti Sharma (V)", null, 70, "09:00-12:00"));
        addCourse(new Course("SSH240", "Politics in Digital Era", 4, 3, "Asim Khan", null, 70, "13:00-15:00"));
        addCourse(new Course("SOC216", "Political Anthropology: State, Subject, Power", 4, 3, "Deepak Prince", "SOC101", 70, "15:00-17:00"));
        addCourse(new Course("SSH221", "Social & Political Philosophy", 4, 3, "Manohar Kumar", null, 70, "09:00-11:00"));

        // Semester 4 courses (some with prerequisites)
        addCourse(new Course("BIO213", "Introduction to Quantitative Biology", 4, 4, "Jaspreet Kaur", "BIO101,MTH201", 70, "09:00-11:00"));
        addCourse(new Course("BIO221", "Practical Bioinformatics", 4, 4, "Tavpritesh Sethi", "BIO101,CSE101", 70, "11:00-13:00"));
        addCourse(new Course("ECE113", "Basic Electronics", 4, 4, "Tammam Tillo", "ECE111", 70, "14:00-16:00"));
        addCourse(new Course("CSE202", "Fundamentals of Database Systems", 4, 4, "Mukesh Mohania, Madiha (TF)", "CSE102", 70, "16:00-18:00"));
        addCourse(new Course("CSE222", "Analysis and Design of Algorithms", 4, 4, "Diptapriyo Majumdar, Meera (TF)", "CSE102,MTH100", 70, "09:00-12:00"));
        addCourse(new Course("CSE322", "Theory of Computation", 4, 4, "Syamantak Das", "CSE121", 70, "13:00-15:00"));
        addCourse(new Course("CSE342/ECE356", "Statistical Machine Learning", 4, 4, "A V Subramanyam", "MTH201,CSE101", 70, "15:00-17:00"));
        addCourse(new Course("DES205", "Design of Interactive Systems", 4, 4, "Kalpana Shankhawar", "DES102", 70, "09:00-11:00"));
        addCourse(new Course("DES206", "Prototyping Interactive Systems", 4, 4, "Richa Gupta", "DES102", 70, "11:00-13:00"));
        addCourse(new Course("ECE214", "Integrated Electronics", 4, 4, "Abhijit Mitra", "ECE113", 70, "14:00-16:00"));
        addCourse(new Course("ECE230", "Fields and Waves", 4, 4, "Sayak Bhattacharya", "MTH100,ECE111", 70, "16:00-18:00"));
        addCourse(new Course("ECE240", "Principles of Communication Systems", 4, 4, "Ranjitha P", "ECE250", 70, "09:00-11:00"));
        addCourse(new Course("ECE210", "Physics of Semiconductor Devices (New)", 4, 4, "Ram Krishna Ghosh", "ECE113", 70, "11:00-13:00"));
        addCourse(new Course("ECE211", "Electronic System Design (New)", 4, 4, "Alok Mittal (G)", "ECE113", 70, "14:00-16:00"));
        addCourse(new Course("MTH204", "Maths IV - ODE/PDE", 4, 4, "Ashish Kumar Pandey", "MTH203", 70, "16:00-18:00"));
        addCourse(new Course("MTH212", "Abstract Algebra I", 4, 4, "Sneha Chaubey", "MTH210", 70, "09:00-12:00"));
        addCourse(new Course("MTH300", "Introduction to Mathematical Logic", 4, 4, "Sankha Basu", "MTH210", 70, "13:00-15:00"));
        addCourse(new Course("MTH310", "Graph Theory", 4, 4, "Samaresh Chatterji (V)", "MTH210", 70, "15:00-17:00"));
        addCourse(new Course("MTH372", "Statistical Inference", 4, 4, "Anisha Aggarwal (G)", "MTH201", 70, "09:00-11:00"));
        addCourse(new Course("MTH374", "Linear Optimization", 4, 4, "Pravesh Biyani", "MTH100", 70, "11:00-13:00"));
        addCourse(new Course("MTH377", "Convex Optimization", 4, 4, "Ruhi Sonal", "MTH100", 70, "14:00-16:00"));
        addCourse(new Course("ECO221", "Econometrics 1", 4, 4, "JV Meenakshi", "MTH201,ECO223", 70, "16:00-18:00"));
        addCourse(new Course("SOC213", "Introduction to Digital Ethnography", 4, 4, "Soibam Haripriya", "SOC101", 70, "09:00-11:00"));
        addCourse(new Course("SSH215", "Nation and Her Narratives", 4, 4, "Payel C Mukherjee (V)", null, 70, "11:00-13:00"));
        addCourse(new Course("SSH325", "Ethics in AI", 4, 4, "Manohar Kumar", "CSE140", 70, "14:00-16:00"));
        addCourse(new Course("ENT301", "Foundations of Marketing", 4, 4, "Jyoti Sharma (V)", null, 70, "16:00-18:00"));
        addCourse(new Course("ESC207", "Ecology, Evolution, and Environment", 2, 4, "D. K. Sharma (V)", "BIO101", 70, "09:00-11:00"));
    }

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public boolean removeCourse(String courseCode) {
        Course removed = courses.remove(courseCode);
        if (removed != null) {
            // Remove course from all professors' assigned courses
            for (Professor professor : professors.values()) {
                professor.removeAssignedCourse(removed);
            }
            // Remove course from all students' registered courses
            for (Student student : students.values()) {
                student.dropCourse(removed);
            }
            return true;
        }
        return false;
    }

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public List<Course> getCoursesForSemester(int semester) {
        return courses.values().stream()
                .filter(course -> course.getSemester() == semester)
                .toList();
    }

    public void viewCourses() {
        System.out.println("#=---- Course Catalog ----=#");
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public void addProfessor(Professor professor) {
        professors.put(professor.getId(), professor);
    }

    public Professor getProfessor(String professorId) {
        return professors.get(professorId);
    }

    public List<Professor> getAllProfessors() {
        return new ArrayList<>(professors.values());
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return new ArrayList<>(complaints);
    }

    public void updateCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public void updateStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void updateProfessor(Professor professor) {
        professors.put(professor.getId(), professor);
    }

    public void assignProfessorToCourse(String professorId, String courseCode) {
        Professor professor = professors.get(professorId);
        Course course = courses.get(courseCode);
        if (professor != null && course != null) {
            course.assignProfessor(professor);
            professor.addAssignedCourse(course);
        }
    }

    public void registerStudentForCourse(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);
        if (student != null && course != null) {
            if (student.canRegisterForCourse(course)) {
                student.registerForCourse(course);
                course.enrollStudent(student);
            }
        }
    }

    public void dropStudentFromCourse(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);
        if (student != null && course != null) {
            student.dropCourse(course);
            course.removeStudent(student);
        }
    }

    public void updateComplaintStatus(Complaint complaint, String newStatus) {
        complaint.setStatus(newStatus);
    }

    public List<Complaint> getFilteredComplaints(String status, String date) {
        return complaints.stream()
                .filter(c -> (status == null || c.getStatus().equals(status)) &&
                             (date == null || c.getDate().equals(date)))
                .toList();
    }
}