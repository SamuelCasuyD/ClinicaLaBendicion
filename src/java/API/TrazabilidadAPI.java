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

    public List listarTrazabildad(String codSolicitud) {
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
                + "where estados_solicitudes.idEstadoSolicitud= trazabilidad.estadoSolicitud and codigoSolicitud="+codSolicitud;

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

    //devuelve la lista de solicitudes asignadas
    public List listarSolicitudesID(int id) {
        List<SolicitudesMedicasDTO> ListaSolicitudes = new ArrayList<>();
        String sql = "SELECT A.idSolicitudes, \n"
                + "	   A.codigoSolicitud, \n"
                + "	   A.estado_solicitud, \n"
                + "	   B.nombreEstadoSolicitud , \n"
                + "	   A.UsuarioCreacion, \n"
                + "	   A.UsuarioModificacion, \n"
                + "	   A.UsuarioAsignacion, \n"
                + "	   A.FechaModificacion, \n"
                + "	   A.Descripcion, \n"
                + "	   A.observaciones \n"
                + "From solicitudes_medicas as A, estados_solicitudes as B\n"
                + "\n"
                + "WHERE A.estado_solicitud = B.idEstadoSolicitud\n"
                + "AND A.UsuarioAsignacion =" + id;

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                SolicitudesMedicasDTO tzb = new SolicitudesMedicasDTO();            
                
                tzb.setIdSolicitud(rs.getInt(1));
                tzb.setCodigoSolicitud(rs.getString(2));
                tzb.setEstadoSolicitud(rs.getInt(3));
                tzb.setNombreEstadoSolicitud(rs.getString(4));
                tzb.setUsuarioCreacion(rs.getInt(5));
                tzb.setUsuraioModificacion(rs.getInt(6));
                tzb.setUsuarioAsignacion(rs.getInt(7));
                tzb.setFechaModificaion(rs.getString(8));
                tzb.setDescripcion(rs.getString(9));
                tzb.setObservaciones(rs.getString(10));
                

                ListaSolicitudes.add(tzb);
            }
        } catch (Exception e) {

        }
        return ListaSolicitudes;
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
                + "and rollusuario.NombreRoll = 'Centralizador' \n"
                + "order by A asc LIMIT 1";

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

    public UsuarioDTO retornarUsuarioAnalistaConMenosSolicitudes() {
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
                + "and rollusuario.NombreRoll = 'Revisor/Autorizador' \n"
                + "order by A asc LIMIT 1";

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

        try {

            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, traza.getCodigoSolicitud());
            pst.setInt(2, traza.getEstadoSolicitud());
            pst.setString(3, traza.getEnviadoPor());
            pst.setInt(4, traza.getAsignadoA());
            pst.setString(5, traza.getFecha());

            r = pst.executeUpdate();

        } catch (Exception e) {

        }

        return r;
    }

    public int asignarCantidadSolicitud(UsuarioDTO user) {

        String sql = "UPDATE usuarios SET solicitudesAsignadas= ? WHERE usuarios.EntityID = ?";

        try {

            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, user.getCantidadSolicitudes());
            pst.setInt(2, user.getEntityID());

            r = pst.executeUpdate();

        } catch (Exception e) {

        }

        return r;
    }
    
    
    public int quitarCantidadSolicitud(UsuarioDTO user) {

        String sql = "UPDATE usuarios SET solicitudesAsignadas= ? WHERE usuarios.EntityID = ?";

        try {

            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, user.getCantidadSolicitudes());
            pst.setInt(2, user.getEntityID());

            r = pst.executeUpdate();

        } catch (Exception e) {

        }

        return r;
    }

}
