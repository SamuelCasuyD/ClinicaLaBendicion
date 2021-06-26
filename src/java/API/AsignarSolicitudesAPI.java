package API;

import Models.SolicitudesMedicasDTO;
import Models.TrazabilidadDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alexander Elias
 */
public class AsignarSolicitudesAPI {

    Conection cn = new Conection();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    int r;

    public int ActualizaasignarSolicitud(SolicitudesMedicasDTO solM) {
        String sql = "UPDATE solicitudes_medicas SET FechaModificacion=?, UsuarioModificacion= ?, UsuarioAsignacion=?, estado_solicitud = ? WHERE codigoSolicitud = ?";

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, solM.getFechaModificaion());
            pst.setInt(2, solM.getUsuraioModificacion());
            pst.setInt(3, solM.getUsuarioAsignacion());
            pst.setInt(4, solM.getEstadoSolicitud());
            pst.setString(5, solM.getCodigoSolicitud());

            r = pst.executeUpdate();

        } catch (SQLException e) {

        }

        return r;
    }
    
    
    public int asignarSolicitud2(SolicitudesMedicasDTO solM) {
        String sql = "UPDATE solicitudes_medicas SET FechaModificacion=?, UsuarioModificacion= ?, UsuarioAsignacion=?, estado_solicitud = ? WHERE idSolicitudes = ?";

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, solM.getFechaModificaion());
            pst.setInt(2, solM.getUsuraioModificacion());
            pst.setInt(3, solM.getUsuarioAsignacion());
            pst.setInt(4, solM.getEstadoSolicitud());
            pst.setInt(5, solM.getIdSolicitud());

            r = pst.executeUpdate();

        } catch (SQLException e) {

        }

        return r;
    }

    

}
