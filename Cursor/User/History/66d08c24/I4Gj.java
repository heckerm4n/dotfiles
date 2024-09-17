import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Credentials {
    private Map<String, String> userCredentials;
    private Map<String, List<String>> studentInfo;
    private Map<String, List<String>> professorInfo;
    private Map<String, List<String>> adminInfo;

    public Credentials() {
        userCredentials = new HashMap<>();
        studentInfo = new HashMap<>();
        professorInfo = new HashMap<>();
        adminInfo = new HashMap<>();

        // Initialize with some sample data
        addStudent("2023082", "123", "Anant Gyan Singhal", "anant@iiitd.ac.in", "CSE");
        addStudent("2022091", "123", "Ayush Kumar", "ayush@iiitd.ac.in", "CSE");
        addProfessor("1968", "123", "Sambuddho Chakravarty", "sambuddho@iiitd.ac.in");
        addProfessor("1992", "123", "Satish Pandey", "satish@iiitd.ac.in");
        addAdmin("1927", "admin123", "Neha Aggarwal", "neha@iiitd.ac.in");
    }

    public void addStudent(String id, String password, String name, String email, String branch) {
        userCredentials.put(id, password);
        List<String> info = new ArrayList<>();
        info.add(name);
        info.add(email);
        info.add(id);
        info.add(branch);
        studentInfo.put(id, info);
    }

    public void addProfessor(String id, String password, String name, String email) {
        userCredentials.put(id, password);
        List<String> info = new ArrayList<>();
        info.add(name);
        info.add(email);
        info.add(id);
        professorInfo.put(id, info);
    }

    public void addAdmin(String id, String password, String name, String email) {
        userCredentials.put(id, password);
        List<String> info = new ArrayList<>();
        info.add(name);
        info.add(email);
        info.add(id);
        adminInfo.put(id, info);
    }

    public boolean verify(String id, String password) {
        return userCredentials.containsKey(id) && userCredentials.get(id).equals(password);
    }

    public List<String> getstucreds(String id) {
        return studentInfo.get(id);
    }

    public List<String> getprofcreds(String id) {
        return professorInfo.get(id);
    }

    public List<String> getadmincreds(String id) {
        return adminInfo.get(id);
    }
}