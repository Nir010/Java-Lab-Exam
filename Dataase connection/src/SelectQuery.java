    import java.sql.*;

    public class SelectQuery {
        private static final String url = "jdbc:mysql://127.0.0.1:3306/student";
        private static final String userName = "root";
        private static final String password = "aditya@1234@";
        Connection connection = null;

        public static void main(String[] args) {
            System.out.println("Hello, World!");

            try {
                // JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded");
            } catch (Exception e) {
                System.out.println("System errors " + e.getMessage());
            }
            try {
                Connection connection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connected to database");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
                while (resultSet.next()) {
                    int std_id = resultSet.getInt("std_id");
                    String std_name = resultSet.getString("std_name");
                    int std_age = resultSet.getInt("std_age");
                    System.out.println("Roll No.: " + std_id);
                    System.out.println("name: " + std_name);
                    System.out.println("age: " + std_age);
                }
                connection.close();
            } catch (SQLException e) {
                System.out.println("System error " + e.getMessage());
            }
        }
    }
