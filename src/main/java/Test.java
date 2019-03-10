import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        System.out.println(test1());
    }
    public static Connection test1() throws SQLException {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rentbook?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true",
                    "root",
                    "root");

            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
