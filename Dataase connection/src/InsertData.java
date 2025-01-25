import java.sql.*;
import java.util.Scanner;

public class InsertData {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String userName = "root";
    private static final String password = "aditya@1234@";
    Connection connection = null;

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO student (std_id, std_name, std_age) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student Id: ");
            int std_id = scanner.nextInt();
            System.out.print("Enter Name: ");
            String std_name = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Enter Age: ");
            int std_age = scanner.nextInt();
            ps.setInt(1, std_id);
            ps.setString(2, std_name);
            ps.setInt(3, std_age);
            ps.executeUpdate();

            System.out.println("Data inserted successfully.");
            connection.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}