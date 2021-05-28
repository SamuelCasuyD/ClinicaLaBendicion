package API;

import Models.TipoSolicitanteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Elias
 */
public class TipoSolicitanteAPI {
    
     Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    public List listar(){
        List<TipoSolicitanteDTO>TSolicitante = new ArrayList();
        String sql="select* from tipos_solicitantes";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoSolicitanteDTO TSt = new TipoSolicitanteDTO();
                TSt.setIdTipoSolicitnate(rs.getInt(1));
                TSt.setNombreTipoSolicitante(rs.getString(2));
               
                
                TSolicitante.add(TSt);
            }
        } catch(Exception e){
            
        }
        
        return TSolicitante;
        
    }
    
}
