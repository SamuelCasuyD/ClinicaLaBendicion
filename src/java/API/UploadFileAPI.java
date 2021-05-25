/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.UploadFileDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SammyKazzu
 */
public class UploadFileAPI {
    
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int addUploadFile(UploadFileDTO upFile){
        int rData = 0;
        
        String sql = "insert into muestra(IdAdjunto, NumMuestra, "
                + "PathName, FechaCreacion, Eliminado) "
                + "values (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            boolean eliminado = false;

            ps.setInt(1, upFile.getIdAdjunto());
            ps.setString(2, upFile.getNumMuestra());
            ps.setString(3, upFile.getPathName());
            ps.setDate(4, sqlDate);
            ps.setBoolean(5, eliminado);
            ps.executeUpdate();
            
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n"
                    + "SLQState: " + e.getSQLState() + "\n"
                    + "Mensaje: " + e.getMessage() + "\n");
        }        
        return rData ;
    }
    
}
