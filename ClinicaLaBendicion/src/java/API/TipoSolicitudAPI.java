
package API;

import Models.TipoSolicitudDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Elias
 */
public class TipoSolicitudAPI {
    
     Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    public List listarTsolicitud(){
        List<TipoSolicitudDTO>TSolicitud = new ArrayList();
        String sql="select* from tipos_solicitudes";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoSolicitudDTO TSd = new TipoSolicitudDTO();
                TSd.setIdTipoSolicitud(rs.getInt(1));
                TSd.setNombreTipoSolicitud(rs.getString(2));
               
                
                TSolicitud.add(TSd);
            }
        } catch(Exception e){
            
        }
        
        return TSolicitud;
        
    }
    
}
