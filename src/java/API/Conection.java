package API;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author SammyKazzu
 */
public class Conection {
    
    Connection con;
    String drive = "com.mysql.cj.jdbc.Driver";    
    String url = "jdbc:mysql://localhost:3308/sbo_laboratoriolb_2021?serverTimezone=UTC";
    String user = "root";
    String pass="";
    
    public Connection getConnection(){        
        try{
            Class.forName(drive);
            con = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){            
        }
        return con;
    }    
}
