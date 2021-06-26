package API;

import Models.SolicitudesMedicasDTO;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
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
public class SolicitudesMedicasAPI {

    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List buscarSolicitudesMedicas(String codigoSolicitud, String numExpediente, String numSoporte, String tipoSolicitud, String nit, String estado, String fechaInicio, String fechaFin) {

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

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigoSolicitud);
            ps.setString(2, numExpediente);
            ps.setString(3, numSoporte);
            ps.setString(4, tipoSolicitud);
            ps.setString(5, nit);
            ps.setString(6, estado);
            ps.setString(7, fechaInicio);
            ps.setString(8, fechaFin);

            rs = ps.executeQuery();

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

        } catch (Exception e) {

        }

        return listS;

    }

    public List listarSolicitudes() {
        List<SolicitudesMedicasDTO> SolMed = new ArrayList();
        String sql = "SELECT   A.codigoSolicitud,\n"
                + "	   A.NoExpediente, \n"
                + "	   A.nit, \n"
                + "	   A.numSoporte, \n"
                + "	   D.nombreSoporte, \n"
                + "	   E.nombreTipoSolicitante, \n"
                + "	   B.nombreTipoSolicitud, \n"
                + "	   A.UsuarioAsignacion, \n"
                + "        A.estado_solicitud,\n"
                + "	   C.nombreEstadoSolicitud, \n"
                + "	   A.UsuarioCreacion, \n"
                + "	   A.FechaCreacion, \n"
                + "	   A.Descripcion, \n"
                + "	   A.nombre, \n"
                + "	   A.Telefono, \n"
                + "	   A.email, \n"
                + "        A.idSolicitudes\n"
                + "FROM solicitudes_medicas as A, \n"
                + "	 tipos_solicitudes as B, \n"
                + "	 estados_solicitudes as C, \n"
                + "	 soporte as D, \n"
                + "	 tipos_solicitantes as E \n"
                + "WHERE C.idEstadoSolicitud = A.estado_solicitud \n"
                + "AND B.idTipoSolicitud= A.tipoSolicitud \n"
                + "AND A.tipoSolicitante = E.idTipoSolicitante \n"
                + "AND A.tipoSoporte = D.idSoporte AND A.estado_solicitud <> 10";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                SolicitudesMedicasDTO sol = new SolicitudesMedicasDTO();

                sol.setCodigoSolicitud(rs.getString(1));// A.codigoSolicitud, 
                sol.setNumExpediente(rs.getString(2)); //A.NoExpediente,
                sol.setNit(rs.getString(3)); // A.nit, 
                sol.setNumSoporte(rs.getString(4)); //   A.numSoporte,
                sol.setNombreSoporte(rs.getString(5));   //  D.nombreSoporte, 
                sol.setNombreTipoSolicitante(rs.getString(6)); // E.nombreTipoSolicitante,
                sol.setNombreTipoSolicitud(rs.getString(7));      //B.nombreTipoSolicitud,
                sol.setUsuarioAsignacion(rs.getInt(8)); // A.UsuarioAsignacion,    
                sol.setEstadoSolicitud(rs.getInt(9));
                sol.setNombreEstadoSolicitud(rs.getString(10)); //C.nombreEstadoSolicitud,               
                sol.setUsuarioCreacion(rs.getInt(11));// A.UsuarioCreacion,               
                sol.setFechaCreacion(rs.getString(12));
                sol.setDescripcion(rs.getString(13));
                sol.setNombre(rs.getString(14));
                sol.setTelefono(rs.getString(15));
                sol.setEmail(rs.getString(16));
                sol.setIdSolicitud(rs.getInt(17));

                SolMed.add(sol);

            }

        } catch (Exception e) {

        }

        return SolMed;
    }

    public int add(SolicitudesMedicasDTO sol) {
        String sql = "INSERT INTO solicitudes_medicas(tipoSolicitante, tipoSolicitud,Descripcion, NoExpediente, nit,nombre,Telefono, email, FechaCreacion,UsuarioCreacion,tipoSoporte, numSoporte,estado_solicitud) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, sol.getTipoSolicitante());
            ps.setInt(2, sol.getTipoSolicitud());
            ps.setString(3, sol.getDescripcion());
            ps.setString(4, sol.getNumExpediente());
            ps.setString(5, sol.getNit());
            ps.setString(6, sol.getNombre());
            ps.setString(7, sol.getTelefono());
            ps.setString(8, sol.getEmail());
            ps.setString(9, sol.getFechaCreacion());
            ps.setInt(10, sol.getUsuarioCreacion());
            ps.setInt(11, sol.getTipoSoporte());
            ps.setString(12, sol.getNumSoporte());
            ps.setInt(13, sol.getEstadoSolicitud());

            r = ps.executeUpdate();

            String sql2 = "INSERT INTO tipos_solicitante_recovery(codigoTipoSolicitud) VALUES (?)";
            con = cn.getConnection();
            ps = con.prepareStatement(sql2);
            ps.setInt(1, sol.getTipoSolicitante());
            r = ps.executeUpdate();

            /*sql="select codigoSolicitud from solicitudes_medicas order by idSolicitudes desc limit 1";
            rs=ps.executeQuery(sql);
            rs.next();
            CodigoSolicitud = rs.getString("idCompras");
            rs.close();*/
        } catch (Exception e) {

        }

        return r;
    }

    public SolicitudesMedicasDTO listarExpediente(int limit) {
        SolicitudesMedicasDTO solmedica = new SolicitudesMedicasDTO();
        String sql = "select codigoSolicitud from solicitudes_medicas order by idSolicitudes desc limit ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, limit);
            rs = ps.executeQuery();

            while (rs.next()) {
                solmedica.setCodigoSolicitud(rs.getString("codigoSolicitud"));
            }
        } catch (Exception e) {
        }
        return solmedica;

    }

    public int EliminarSolicitud(SolicitudesMedicasDTO soli) {

        String sql = "update solicitudes_medicas set estado_solicitud = ? where idSolicitudes = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, soli.getEstadoSolicitud());
            ps.setInt(2, soli.getIdSolicitud());

            r = ps.executeUpdate();

        } catch (SQLException e) {

        }

        return r;

    }

    public SolicitudesMedicasDTO listarSolicitudesId(int id) {
        SolicitudesMedicasDTO sol = new SolicitudesMedicasDTO();
        String sql = "SELECT   A.codigoSolicitud,\n"
                + "	   A.NoExpediente, \n"
                + "	   A.nit, \n"
                + "	   A.numSoporte, \n"
                + "	   D.nombreSoporte, \n"
                + "	   E.nombreTipoSolicitante, \n"
                + "	   B.nombreTipoSolicitud, \n"
                + "	   A.UsuarioAsignacion, \n"
                + "        A.estado_solicitud,\n"
                + "	   C.nombreEstadoSolicitud, \n"
                + "	   A.UsuarioCreacion, \n"
                + "	   A.FechaCreacion, \n"
                + "	   A.Descripcion, \n"
                + "	   A.nombre, \n"
                + "	   A.Telefono, \n"
                + "	   A.email, \n"
                + "        A.idSolicitudes\n"
                + "FROM solicitudes_medicas as A, \n"
                + "	 tipos_solicitudes as B, \n"
                + "	 estados_solicitudes as C, \n"
                + "	 soporte as D, \n"
                + "	 tipos_solicitantes as E \n"
                + "WHERE C.idEstadoSolicitud = A.estado_solicitud \n"
                + "AND B.idTipoSolicitud= A.tipoSolicitud \n"
                + "AND A.tipoSolicitante = E.idTipoSolicitante \n"
                + "AND A.tipoSoporte = D.idSoporte AND A.estado_solicitud <> 10 and idSolicitudes="+id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                sol.setCodigoSolicitud(rs.getString(1));// A.codigoSolicitud, 
                sol.setNumExpediente(rs.getString(2)); //A.NoExpediente,
                sol.setNit(rs.getString(3)); // A.nit, 
                sol.setNumSoporte(rs.getString(4)); //   A.numSoporte,
                sol.setNombreSoporte(rs.getString(5));   //  D.nombreSoporte, 
                sol.setNombreTipoSolicitante(rs.getString(6)); // E.nombreTipoSolicitante,
                sol.setNombreTipoSolicitud(rs.getString(7));      //B.nombreTipoSolicitud,
                sol.setUsuarioAsignacion(rs.getInt(8)); // A.UsuarioAsignacion,    
                sol.setEstadoSolicitud(rs.getInt(9));
                sol.setNombreEstadoSolicitud(rs.getString(10)); //C.nombreEstadoSolicitud,               
                sol.setUsuarioCreacion(rs.getInt(11));// A.UsuarioCreacion,               
                sol.setFechaCreacion(rs.getString(12));
                sol.setDescripcion(rs.getString(13));
                sol.setNombre(rs.getString(14));
                sol.setTelefono(rs.getString(15));
                sol.setEmail(rs.getString(16));
                sol.setIdSolicitud(rs.getInt(17));

            }

        } catch (Exception e) {

        }

        return sol;
    }

}
