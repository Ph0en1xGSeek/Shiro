import java.awt.datatransfer.StringSelection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBDemo
{
    // The JDBC Connector Class.
    private static final String dbClassName = "com.mysql.jdbc.Driver";

    // Connection string. emotherearth is the database the program
    // is connecting to. You can include user and password after this
    // by adding (say) ?user=paulr&password=paulr. Not recommended!

    private static final String CONNECTION =
            "jdbc:mysql://127.0.0.1/test";

    public static void main(String[] args) throws
            ClassNotFoundException,SQLException
    {
        System.out.println(dbClassName);
        // Class.forName(xxx) loads the jdbc classes and
        // creates a drivermanager class factory
        Class.forName(dbClassName);

        // Properties for user and password. Here the user and password are both 'paulr'
        Properties p = new Properties();
        p.put("user","root");
        p.put("password","1234");

        // Now try to connect
        Connection c = DriverManager.getConnection(CONNECTION,p);
        Statement statement = c.createStatement();

        String sql = "select * from data_deployed";
        ResultSet rs = statement.executeQuery(sql);
        Map<String, String> lan_data = new HashMap<String, String>();
        while(rs.next()){
            String lan = rs.getString("language");
            String data = rs.getString("dataname");
            lan_data.put(lan, data);
            System.out.println(lan + " " + data);
        }
        if(lan_data.get("Java") == null){
            System.out.println("Java not deployed");
        }


        System.out.println("It works !");
        c.close();
    }
}