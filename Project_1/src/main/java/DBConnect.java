import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    private static String url = "";
    private static String username = "";
    private static String password = "";
    private Connection connect;
    private Statement stmt;

    public Statement createStatement(){
        try {
            Class.forName("");
            this.connect = DriverManager.getConnection(url, username, password);
            this.stmt = connect.createStatement();
            return this.stmt;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeStatement() throws SQLException {
        this.connect.close();
        this.stmt.close();
    }

}

