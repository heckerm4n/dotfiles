import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private int credits;
    private int semester;
    private String syllabus;
    private String grade;
    private String schedule;
    private List<String> prerequisites;
    private int enrollmentLimit;
    //private String officeHours;
    private Professor assignedProfessor;
    private List<Student> enrolledStudents;

    public Course(String code, String title, int credits, int semester, Professor assignedProfessor,
     List<Student> enrolledStudents, List<String> prerequisites, int enrollmentLimit, String schedule) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.semester = semester;
        this.prerequisites = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters and setters

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public int getSemester() {
        return semester;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
   public double getGradePoints() {
        switch (grade) {
            case "A+": return 10.0;
            case "A": return 9.0;
            case "B": return 8.0;
            case "B-": return 7.0;
            case "C": return 6.0;
            case "C-": return 5.0;
            case "D": return 4.0;
            case "F": return 3.0;
            default: return 0.0;
        }
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public Professor getAssignedProfessor() {
        return assignedProfessor;
    }

    public void assignProfessor(Professor professor) {
        this.assignedProfessor = professor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        return "Course: " + code + " - " + title + " (" + credits + " credits, Semester " + semester + ")";
    }
}