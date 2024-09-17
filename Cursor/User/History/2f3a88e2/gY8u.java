import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
    private List<Course> courses;
    private List<Student> students;
    private List<Professor> professors;
    private List<Complaint> complaints;

    public CourseCatalog() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.complaints = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean removeCourse(String courseCode) {
        return courses.removeIf(course -> course.getCode().equals(courseCode));
    }

    public Course getCourse(String courseCode) {
        return courses.stream()
                .filter(course -> course.getCode().equals(courseCode))
                .findFirst()
                .orElse(null);
    }

    public List<Course> getCoursesForSemester(int semester) {
        return courses.stream()
                .filter(course -> course.getSemester() == semester)
                .toList();
    }

    public void viewCourses() {
        System.out.println("#=---- Course Catalog ----=#");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(String studentId) {
        return students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public List<Professor> getAllProfessors() {
        return new ArrayList<>(professors);
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return new ArrayList<>(complaints);
    }
} 