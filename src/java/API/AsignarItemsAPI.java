package API;

import Models.SolicitudesMedicasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alexander Elias
 */
public class AsignarItemsAPI {

    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    int r;

    public int add(int codItem, int codMuestra) {
        String sql = "INSERT INTO items_muestras_asociadas(idMuestra, idItems) VALUES ("+codMuestra+","+codItem+")";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (Exception e) {

        }

        return r;
    }

}
