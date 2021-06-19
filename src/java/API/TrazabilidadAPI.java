package API;

import Models.SolicitudesMedicasDTO;
import Models.TipoSolicitudDTO;
import Models.TrazabilidadDTO;
import Models.UsuarioDTO;
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
    int r;

    public List listarTrazabildad() {
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

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                TrazabilidadDTO tzb = new TrazabilidadDTO();

                tzb.setIdTrazabilidad(rs.getInt(1));
                tzb.setCodigoSolicitud(rs.getString(2));
                tzb.setEstadoSolicitud(rs.getInt(3));
                tzb.setNombreEstado(rs.getString(4));
                tzb.setEnviadoPor(rs.getString(5));
                tzb.setAsignadoA(rs.getInt(6));
                tzb.setFecha(rs.getString(7));
                tzb.setDuracion(rs.getString(8));
                tzb.setAcumulado(rs.getString(9));
                tzb.setObservaciones(rs.getString(10));
                tzb.setAsignacion(rs.getString(11));

                listaTrazabilidad.add(tzb);
            }
        } catch (Exception e) {

        }
        return listaTrazabilidad;
    }

    public UsuarioDTO retornarUsuarioConMenosSolicitudes() {
        UsuarioDTO user = new UsuarioDTO();
        String sql = "select usuarios.EntityID,\n"
                + "	   usuarios.PrimerNombre, \n"
                + "	   usuarios.PrimerApellido, \n"
                + "       rollusuario.NombreRoll,\n"
                + "       usuarios.solicitudesAsignadas as \"A\"\n"
                + "       \n"
                + "\n"
                + "FROM usuarios , rollusuario \n"
                + "\n"
                + "WHERE usuarios.rolUsuario = rollusuario.IdRoll \n"
                + "and rollusuario.NombreRoll = 'Analista' \n"
                + "order by A Asc LIMIT 1";

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                user.setEntityID(rs.getInt(1));
                user.setPrimerNombre(rs.getString(2));
                user.setPrimerApellido(rs.getString(3));
                user.setRolUsuaario(rs.getString(4));
                user.setCantidadSolicitudes(rs.getInt(5));

            }
        } catch (Exception e) {

        }

        return user;
    }

    public int asignarTrazabilidad(TrazabilidadDTO traza) {
        String sql = "insert into trazabilidad(codigoSolicitud, estadoSolicitud, enviadoPor, asignadoA, fechaHoraEstado) values (?,?,?,?,?)";
        
        try{
            
            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, traza.getCodigoSolicitud());
            pst.setInt(2, traza.getEstadoSolicitud());
            pst.setString(3, traza.getEnviadoPor());
            pst.setInt(4, traza.getAsignadoA());
            pst.setString(5, traza.getFecha());
            
            r= pst.executeUpdate();
            
        }catch(Exception e){
        
        }
        
        return r;
    }
    
}
