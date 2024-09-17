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
        // Initialize courses for different semesters
        // Semester 1 courses
        addCourse(new Course("CSE101", "Introduction to Programming", 4, 1, null, null, 600, null));
        addCourse(new Course("MTH100", "Linear Algebra", 4, 1, null, null, 600, null));
        addCourse(new Course("ECE111", "Digital Circuits", 4, 1, null, null, 600, null));
        addCourse(new Course("DES102", "Human-Computer Interaction", 4, 1, null, null, 600, null));
        addCourse(new Course("COM101", "Communication Skills", 2, 1, null, null, 600, null));

        // Semester 2 courses
        addCourse(new Course("BIO101", "Foundations of Biology", 4, 2, "Sriram K.", null, 300, "FOB"));
        addCourse(new Course("CSE102", "Data Structures and Algorithms", 4, 2, "Ojaswa Sharma", null, 300, "DSA"));
        addCourse(new Course("CSE112", "Computer Organisation", 4, 2, "Sujay Deb", null, 300, "CO"));
        addCourse(new Course("CSE140", "Introduction to Intelligent Systems", 4, 2, "Jainendra Shukla", null, 300, "IIS"));
        addCourse(new Course("DES101", "Design Drawing and Visualization", 4, 2, "Anoop Ratn (V)", null, 300, "DDV"));
        addCourse(new Course("DES202", "Visual Design & Communication", 4, 2, "Anoop Ratn (V)", null, 300, "VDC"));
        addCourse(new Course("ECE113", "Basic Electronics", 4, 2, "Tammam Tillo", null, 300, "BE"));
        addCourse(new Course("MTH201", "Probability and Statistics", 4, 2, "Subhajit Ghosechowdhury", null, 300, "P&S"));
        addCourse(new Course("SOC101", "Introduction to Sociology and Anthropology", 4, 2, "Deepak Prince", null, 300, "ISA"));
        addCourse(new Course("SSH101", "Critical Thinking and Readings in Social Sciences", 4, 2, "Aasim Khan", null, 300, "CTRSS"));
        addCourse(new Course("SSH101 (Priyadarshi)", "Critical Thinking and Readings in Social Sciences", 4, 2, "Priyadarshi", null, 300, "CTRSS"));
        addCourse(new Course("ECO223", "Money and Banking", 4, 2, "Kiriti Kanjilal", null, 300, "MB"));

        // Semester 3 courses
        addCourse(new Course("BIO211", "Cell Biology and Biochemistry", 4, 3, "Jaspreet Kaur", null, 70, "CBB"));
        addCourse(new Course("BIO214", "Genetics and Molecular Biology", 4, 3, "Gaurav Ahuja", null, 70, "GMB"));
        addCourse(new Course("CSE121", "Discrete Mathematics", 4, 3, "Bapi Chatterjee", null, 70, "DM"));
        addCourse(new Course("CSE201", "Advanced Programming", 4, 3, "Arun Balaji Buduru", null, 70, "AP"));
        addCourse(new Course("CSE231", "Operating Systems", 4, 3, "Vivek Kumar", null, 70, "OS"));
        addCourse(new Course("DES201", "Design Processes and Perspectives", 4, 3, "Anmol Srivastava", null, 70, "DPP"));
        addCourse(new Course("MTH203", "Math III", 4, 3, "Satish Pandey", null, 70, "M-III"));
        addCourse(new Course("MTH210", "Discrete Structures", 4, 3, "Ashish Kumar Pandey", null, 70, "DS"));
        addCourse(new Course("MTH211", "Number Theory", 4, 3, "Debika Banerjee", null, 70, "NT"));
        addCourse(new Course("MTH240", "Real Analysis I", 4, 3, "Nabaneita Ray", null, 70, "RA-I"));
        addCourse(new Course("ECE215", "Circuit Theory and Devices", 4, 3, "Pragya Kosta", null, 70, "CTD"));
        addCourse(new Course("ECE250", "Signals & Systems", 4, 3, "Anubha Gupta", null, 70, "S&S"));
        addCourse(new Course("ECE270", "Embedded Logic Design", 4, 3, "Sumit Darak", null, 70, "ELD"));
        addCourse(new Course("SSH201", "Research Methods in Social Sciences and Design", 4, 3, "Mrinmoy Chakrabarty, Gayatri Nair, Venkat Ratnadeep Suri, Souvik Dutta", null, 70, "RMSSD"));
        addCourse(new Course("ENT201", "Foundations of Entrepreneurship", 4, 3, "Anupam Saronwala", null, 70, "FOE"));
        addCourse(new Course("ENT202", "Social Entrepreneurship", 4, 3, "Jyoti Sharma (V)", null, 70, "SoE"));
        addCourse(new Course("SSH240", "Politics in Digital Era", 4, 3, "Asim Khan", null, 70, "PDE"));
        addCourse(new Course("SOC216", "Political Anthropology: State, Subject, Power", 4, 3, "Deepak Prince", null, 70, "PASS"));
        addCourse(new Course("SSH221", "Social & Political Philosophy", 4, 3, "Manohar Kumar", null, 70, "SPP"));

        // Semester 4 courses
        addCourse(new Course("BIO213", "Introduction to Quantitative Biology", 4, 4, "Jaspreet Kaur", null, 70, "IQB"));
        addCourse(new Course("BIO221", "Practical Bioinformatics", 4, 4, "Tavpritesh Sethi", null, 70, "PB"));
        addCourse(new Course("ECE113", "Basic Electronics", 4, 4, "Tammam Tillo", null, 70, "BE"));
        addCourse(new Course("CSE202", "Fundamentals of Database Systems", 4, 4, "Mukesh Mohania, Madiha (TF)", null, 70, "DBMS"));
        addCourse(new Course("CSE222", "Analysis and Design of Algorithms", 4, 4, "Diptapriyo Majumdar, Meera (TF)", null, 70, "ADA"));
        addCourse(new Course("CSE322", "Theory of Computation", 4, 4, "Syamantak Das", null, 70, "ToC"));
        addCourse(new Course("CSE342/ECE356", "Statistical Machine Learning", 4, 4, "A V Subramanyam", null, 70, "SML"));
        addCourse(new Course("DES205", "Design of Interactive Systems", 4, 4, "Kalpana Shankhawar", null, 70, "DIS"));
        addCourse(new Course("DES206", "Prototyping Interactive Systems", 4, 4, "Richa Gupta", null, 70, "PIS"));
        addCourse(new Course("ECE214", "Integrated Electronics", 4, 4, "Abhijit Mitra", null, 70, "IE"));
        addCourse(new Course("ECE230", "Fields and Waves", 4, 4, "Sayak Bhattacharya", null, 70, "F&W"));
        addCourse(new Course("ECE240", "Principles of Communication Systems", 4, 4, "Ranjitha P", null, 70, "PCS"));
        addCourse(new Course("ECE210", "Physics of Semiconductor Devices (New)", 4, 4, "Ram Krishna Ghosh", null, 70, "PSD"));
        addCourse(new Course("ECE211", "Electronic System Design (New)", 4, 4, "Alok Mittal (G)", null, 70, "ESD"));
        addCourse(new Course("MTH204", "Maths IV - ODE/PDE", 4, 4, "Ashish Kumar Pandey", null, 70, "M-IV"));
        addCourse(new Course("MTH212", "Abstract Algebra I", 4, 4, "Sneha Chaubey", null, 70, "AA-I"));
        addCourse(new Course("MTH300", "Introduction to Mathematical Logic", 4, 4, "Sankha Basu", null, 70, "IML"));
        addCourse(new Course("MTH310", "Graph Theory", 4, 4, "Samaresh Chatterji (V)", null, 70, "GT"));
        addCourse(new Course("MTH372", "Statistical Inference", 4, 4, "Anisha Aggarwal (G)", null, 70, "SI"));
        addCourse(new Course("MTH374", "Linear Optimization", 4, 4, "Pravesh Biyani", null, 70, "LO"));
        addCourse(new Course("MTH377", "Convex Optimization", 4, 4, "Ruhi Sonal", null, 70, "COO"));
        addCourse(new Course("ECO221", "Econometrics 1", 4, 4, "JV Meenakshi", null, 70, "ECO"));
        addCourse(new Course("SOC213", "Introduction to Digital Ethnography", 4, 4, "Soibam Haripriya", null, 70, "IDE"));
        addCourse(new Course("SSH215", "Nation and Her Narratives", 4, 4, "Payel C Mukherjee (V)", null, 70, "NHN"));
        addCourse(new Course("SSH325", "Ethics in AI", 4, 4, "Manohar Kumar", null, 70, "EI"));
        addCourse(new Course("ENT301", "Foundations of Marketing", 4, 4, "Jyoti Sharma (V)", null, 70, "FOM"));
        addCourse(new Course("ESC207", "Ecology, Evolution, and Environment", 2, 4, "D. K. Sharma (V)", null, 70, "EEE"));
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