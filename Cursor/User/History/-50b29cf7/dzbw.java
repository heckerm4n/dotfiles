import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class login_manager {

    public static List<String> login(Scanner scanner) {

       
        System.out.print("Enter your id: ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine().trim();
        List<String> credentials = new ArrayList<>();
        credentials.add(id);
        credentials.add(password);

        return credentials; 
    }
}

