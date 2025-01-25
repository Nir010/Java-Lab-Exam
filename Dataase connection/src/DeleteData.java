import java.sql.*;
import java.util.Scanner;

public class DeleteData {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
    private static final String userName = "root";
    private static final String password = "aditya@1234@";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "DELETE FROM student WHERE std_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student Id to delete: ");
            int std_id = scanner.nextInt();

            ps.setInt(1, std_id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully.");
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

