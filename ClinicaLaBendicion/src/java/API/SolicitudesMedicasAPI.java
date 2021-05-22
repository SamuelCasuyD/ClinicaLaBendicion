package API;

import Models.SolicitudesMedicasDTO;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Elias
 */
public class SolicitudesMedicasAPI {
    
    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;    
    
    public List buscarSolicitudesMedicas(String codigoSolicitud , String numExpediente, String numSoporte, String tipoSolicitud, String nit, String estado, String fechaInicio, String fechaFin){
        
        
           
        List<SolicitudesMedicasDTO> listS = new ArrayList<>();
        String sql = "SELECT A.codigoSolicitud, \n"
                + "	   A.NoExpediente, \n"
                + "	   A.nit, \n"
                + "	   A.numSoporte, \n"
                + "	   B.nombreTipoSolicitud, \n"
                + "	   A.UsuarioAsignacion, \n"
                + "	   C.nombreEstadoSolicitud, \n"
                + "	   A.FechaCreacion\n"
                + "FROM solicitudes_medicas as A, \n"
                + "	 tipos_solicitudes as B, \n"
                + "	 estados_solicitudes as C\n"
                + "WHERE C.idEstadoSolicitud = A.estado_solicitud\n"
                + "AND B.idTipoSolicitud= A.tipoSolicitud\n"
                + "AND A.codigoSolicitud = ifnull(?,A.codigoSolicitud)\n"
                + "AND A.NoExpediente = ifnull(?,A.NoExpediente)\n"
                + "AND A.numSoporte = ifnull(?,A.numSoporte)\n"
                + "AND A.tipoSolicitud = IFNULL(?,A.tipoSolicitud)\n"
                + "AND A.nit = IFNULL(?, A.nit)\n"
                + "AND A.estado_solicitud = IFNULL(?,A.estado_solicitud)\n"
                + "AND A.FechaCreacion >= IFNULL(?,A.FechaCreacion)\n"
                + "AND A.FechaCreacion <= IFNULL(?,A.FechaCreacion)";
                

        try{
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, codigoSolicitud);
            ps.setString(2, numExpediente);
            ps.setString(3, numSoporte);
            ps.setString(4, tipoSolicitud);
            ps.setString(5, nit);
            ps.setString(6, estado);
            ps.setString(7, fechaInicio);
            ps.setString(8, fechaFin);
            
             rs=ps.executeQuery();
            
            while (rs.next()) {
                 SolicitudesMedicasDTO solicitudes = new SolicitudesMedicasDTO();
        
                solicitudes.setCodigoSolicitud(rs.getString(1));
                solicitudes.setNumExpediente(rs.getString(2));
                solicitudes.setNit(rs.getString(3));
                solicitudes.setNumSoporte(rs.getString(4));
                solicitudes.setNombreTipoSolicitud(rs.getString(5));
                solicitudes.setUsuarioAsignacion(rs.getInt(6));
                solicitudes.setNombreEstadoSolicitud(rs.getString(7));
                solicitudes.setFechaCreacion(rs.getString(8));
                
                listS.add(solicitudes);
            }
            
        }catch(Exception e){
            
        }
        
        
        
        
        return listS;
        
    }
    
    
     public List listarSolicitudes(){
          List<SolicitudesMedicasDTO>SolMed = new ArrayList();
         String sql ="SELECT A.codigoSolicitud,\n" +
"	   A.NoExpediente, \n" +
"	   A.nit, \n" +
"	   A.numSoporte, \n" +
"	   D.nombreSoporte, \n" +
"	   E.nombreTipoSolicitante, \n" +
"	   B.nombreTipoSolicitud, \n" +
"	   A.UsuarioAsignacion, \n" +
"	   C.nombreEstadoSolicitud, \n" +
"	   A.UsuarioCreacion, \n" +
"	   A.FechaCreacion, \n" +
"	   A.Descripcion, \n" +
"	   A.nombre, \n" +
"	   A.Telefono, \n" +
"	   A.email \n" +
"FROM solicitudes_medicas as A, \n" +
"	 tipos_solicitudes as B, \n" +
"	 estados_solicitudes as C, \n" +
"	 soporte as D, \n" +
"	 tipos_solicitantes as E \n" +
"WHERE C.idEstadoSolicitud = A.estado_solicitud \n" +
"AND B.idTipoSolicitud= A.tipoSolicitud \n" +
"AND A.tipoSolicitante = E.idTipoSolicitante \n" +
"AND A.tipoSoporte = D.idSoporte";
       
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                SolicitudesMedicasDTO sol= new SolicitudesMedicasDTO();
               sol.setCodigoSolicitud(rs.getString(1));// A.codigoSolicitud, 
               sol.setNumExpediente(rs.getString(2)); //A.NoExpediente,
               sol.setNit(rs.getString(3)); // A.nit, 
               sol.setNumSoporte(rs.getString(4)); //   A.numSoporte,
               sol.setNombreSoporte(rs.getString(5));   //  D.nombreSoporte, 
               sol.setNombreTipoSolicitante(rs.getString(6)); // E.nombreTipoSolicitante,
               sol.setNombreTipoSolicitud(rs.getString(7));      //B.nombreTipoSolicitud,
               sol.setUsuarioAsignacion(rs.getInt(8)); // A.UsuarioAsignacion,               
               sol.setNombreEstadoSolicitud(rs.getString(9)); //C.nombreEstadoSolicitud,               
               sol.setUsuarioCreacion(rs.getInt(10));// A.UsuarioCreacion,               
               sol.setFechaCreacion(rs.getString(11));                
               sol.setDescripcion(rs.getString(12));               
               sol.setNombre(rs.getString(13));               
               sol.setTelefono(rs.getString(14));
               sol.setEmail(rs.getString(15));
               
               
               SolMed.add(sol);
               
            }
            
        }catch(Exception e){
            
        }
        
        return  SolMed;
    }
    
    
    
    
}
