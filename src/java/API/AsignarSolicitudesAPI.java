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

    public int asignarSolicitud(SolicitudesMedicasDTO solM) {
        String sql = "update solicitudes_medicas set UsuarioAsignacion = ?, estado_solicitud = ? where codigoSolicitud = ?";

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, solM.getUsuarioAsignacion());
            pst.setInt(2, solM.getEstadoSolicitud());
            pst.setString(3, solM.getCodigoSolicitud());

            r = pst.executeUpdate();

        } catch (SQLException e) {

        }

        return r;
    }

    

}
