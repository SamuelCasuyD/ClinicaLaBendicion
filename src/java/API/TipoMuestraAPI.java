/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.TipoMuestraDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SammyKazzu
 */
public class TipoMuestraAPI {
    
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List ListarMuestras() {
        List<TipoMuestraDTO> listM = new ArrayList<>();
        String sql = "SELECT * FROM muestra WHERE Eliminado = 0 ";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoMuestraDTO m = new TipoMuestraDTO();
                m.setIdMuestra(rs.getInt(1));
                m.setNumMuestra(rs.getString(2));
                m.setIdTipoMuestra(rs.getInt(3));
                m.setPresentacion(rs.getString(4));
                m.setCantidadUnidades(rs.getInt(5));
                m.setIdUnidadMedida(rs.getInt(6));
                m.setAdjunto(rs.getString(7));
                m.setFechaCreacion(rs.getDate(8));
                m.setFechaModificacion(rs.getDate(9));
                m.setEliminado(rs.getBoolean(10));
                listM.add(m);
            }
        } catch (SQLException e) {
        }
        return listM;
    }
    
}
