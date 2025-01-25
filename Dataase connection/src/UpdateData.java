import java.sql.*;
import java.util.Scanner;

public class UpdateData {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String userName = "root";
    private static final String password = "aditya@1234@";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE student SET std_name = ?, std_age = ? WHERE std_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student Id to update: ");
            int std_id = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline
            System.out.print("Enter New Name: ");
            String std_name = scanner.nextLine();
            System.out.print("Enter New Age: ");
            int std_age = scanner.nextInt();
            
            ps.setString(1, std_name);
            ps.setInt(2, std_age);
            ps.setInt(3, std_id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("No record found with the given Student Id.");
            }

            connection.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
