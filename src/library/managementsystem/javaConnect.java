
package library.managementsystem;
import java.sql.*;
public class javaConnect {
    Connection con;
    public static Connection DbConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","");
            
            return con;
            
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

}
