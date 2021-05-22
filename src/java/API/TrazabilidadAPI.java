package API;

import Models.TipoSolicitudDTO;
import Models.TrazabilidadDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Elias
 */
public class TrazabilidadAPI {
    
    Conection cn = new Conection();    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;  
    
    public List listarTrazabildad(){
        List<TrazabilidadDTO> listaTrazabilidad = new ArrayList<>();
        String sql = "Select idTrazabilidad, \n"
                + " 		codigoSolicitud, \n"
                + " 		estadoSolicitud, \n"
                + " 		nombreEstadoSolicitud,\n"
                + " 		enviadoPor, \n"
                + " 		asignadoA, \n"
                + " 		fechaHoraEstado, \n"
                + " 		duracion, \n"
                + " 		acumulado, \n"
                + " 		observaciones, \n"
                + " 		asignacion\n"
                + "from estados_solicitudes, trazabilidad\n"
                + "where estados_solicitudes.idEstadoSolicitud= trazabilidad.estadoSolicitud";
        
        try{
            conn=cn.getConnection();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                
                TrazabilidadDTO tzb = new TrazabilidadDTO();
                
                tzb.setIdTrazabilidad(rs.getInt(1));
                tzb.setCodigoSolicitud(rs.getString(2));
                tzb.setEstadoSolicitud(rs.getInt(3));
                tzb.setNombreEstado(rs.getString(4));
                tzb.setEnviadoPor(rs.getString(5));
                tzb.setAsignadoA(rs.getString(6));
                tzb.setFecha(rs.getString(7));
                tzb.setDuracion(rs.getString(8));
                tzb.setAcumulado(rs.getString(9));
                tzb.setObservaciones(rs.getString(10));
                tzb.setAsignacion(rs.getString(11));               
                
                listaTrazabilidad.add(tzb);
            }
        } catch(Exception e){
            
        }
        return listaTrazabilidad;
    }
    
}
