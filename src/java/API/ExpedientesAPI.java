package API;

import Models.ExpedientesDTO;
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
   
    
     public List listarExpediente(String numExpediente) {
         List<ExpedientesDTO> listExp= new ArrayList<>();
        String sql="select* from expedientes where NoExpediente = "+numExpediente;
       
       try{
           
           
           con=cn.getConnection();
           ps=con.prepareStatement(sql); 
           //ps.setString(1, numExpediente);
           rs=ps.executeQuery();
           
           while(rs.next()){
               ExpedientesDTO exp= new ExpedientesDTO();
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
     
     
      public ExpedientesDTO lisExpedientestById(String id) {
        ExpedientesDTO exp= new ExpedientesDTO();
        String sql="select* from expedientes where NoExpediente='"+id+"'";
       
       try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           //ps.setString(1, id);
           rs=ps.executeQuery();
           
           while(rs.next()){
               exp.setIdexpediente(rs.getInt("idexpediente"));
               exp.setNoExpediente(rs.getString("NoExpediente"));
               exp.setNit(rs.getString("Nit"));
               exp.setPrimerNombre(rs.getString("PrimerNombre"));
               exp.setPrimerApellido(rs.getString("PrimerApellido"));
           }
           
       }catch(SQLException e){
           
       }
       return exp;
      }      
     
     
    
}
