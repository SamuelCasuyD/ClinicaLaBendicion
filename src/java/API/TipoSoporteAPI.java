package API;

import Models.TipoSoporteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Elias
 */
public class TipoSoporteAPI {
    
     
    Conection cn= new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    public List listarSoporteInterno(){
        List<TipoSoporteDTO>SoporteInterno = new ArrayList();
        String sql="select * from soporte WHERE idTipoSoporte = 1";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoSoporteDTO Tspt = new TipoSoporteDTO();
                Tspt.setIdSoprte(rs.getInt(1));
                Tspt.setNombreSoporte(rs.getString(2));
                Tspt.setIdTipoSoporte(rs.getInt(3));
               
                
                SoporteInterno.add(Tspt);
            }
        } catch(Exception e){
            
        }
        
        return SoporteInterno;
        
    }
    
    public List listarSoporteExterno(){
        List<TipoSoporteDTO>SoporteExterno = new ArrayList();
        String sql="select * from soporte WHERE idTipoSoporte = 2";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoSoporteDTO Tspt = new TipoSoporteDTO();
                Tspt.setIdSoprte(rs.getInt(1));
                Tspt.setNombreSoporte(rs.getString(2));
                Tspt.setIdTipoSoporte(rs.getInt(3));
               
                
                SoporteExterno.add(Tspt);
            }
        } catch(Exception e){
            
        }
        
        return SoporteExterno;
        
    }
    
    
}
