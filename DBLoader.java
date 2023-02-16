import java.sql.*;
public class DBLoader
{
    static ResultSet exexuteSQL(String SQL) throws Exception
    {
            // ##Code
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("Driver Loading Done");
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/point_of_sale", "root", "gautam123");
            System.out.println("connection done");
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Done");
            ResultSet rs= stmt.executeQuery(SQL);
            System.out.println("Statement Created");
            return rs;
             // ## Code ends Here
    }
}
