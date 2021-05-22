package API;

import Models.ExpedientesDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Elias
 */
public class ExpedientesAPI {
    
    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
    
     public List listarExpediente() {
         List<ExpedientesDto> listExp= new ArrayList<>();
        String sql="select* from expedientes";
       
       try{
           
           
           con=cn.getConnection();
           ps=con.prepareStatement(sql);           
           rs=ps.executeQuery();
           
           while(rs.next()){
               ExpedientesDto exp= new ExpedientesDto();
               exp.setIdexpediente(rs.getInt("idexpediente"));
               exp.setNoExpediente(rs.getString("NoExpediente"));
               exp.setObservaciones(rs.getString("observaciones"));
               exp.setOrigen(rs.getString("origen")); 
               
               listExp.add(exp);
           }
           
       }catch(SQLException e){
           
       }
       return listExp;
      }      
     
    
}
