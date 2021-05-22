/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.TipoMuestraDTO;
import java.sql.Connection;
import java.sql.Date;
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
    
    public List listarTipoMuestra() {
        String sql = "SELECT * FROM tipo_muestras";
        List<TipoMuestraDTO> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoMuestraDTO tm = new TipoMuestraDTO();
                tm.setIdTipoMuestra(rs.getInt(1));
                tm.setTipoMuestra(rs.getString(2));
                lista.add(tm);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public List listUniMedida() {
        String sql = "SELECT * FROM unida_medida";
        List<TipoMuestraDTO> listM = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoMuestraDTO um = new TipoMuestraDTO();
                um.setIdUnidadMedida(rs.getInt(1));
                um.setUnidadMedida(rs.getString(2));
                listM.add(um);
            }
        } catch (SQLException e) {
        }
        return listM;
    }
    
    public int CrearMuestra(TipoMuestraDTO pa) {
        String sql = "insert into muestra(IdTipoMuestra, Presentacion, "
                + "CantidadUnidades, IdUnidadMedida, Adjunto, FechaCreacion,  Eliminado) "
                + "values (?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            boolean eliminado = false;

            ps.setInt(1, pa.getIdTipoMuestra());
            ps.setString(2, pa.getPresentacion());
            ps.setInt(3, pa.getCantidadUnidades());
            ps.setInt(4, pa.getIdUnidadMedida());
            ps.setString(5, pa.getAdjunto());
            ps.setDate(6, (Date) pa.getFechaCreacion());
            ps.setBoolean(7, eliminado);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n"
                    + "SLQState: " + e.getSQLState() + "\n"
                    + "Mensaje: " + e.getMessage() + "\n");
        }
        return r;
    }
    
    public void EliminarMuestra(int id) {
        String sql = "UPDATE muestra SET  FechaModificacion = ?, Eliminado = ? WHERE IdMuestra = ?  ";
        try {
                        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            boolean eliminado = true;
                        
            ps.setDate(1, sqlDate);
            ps.setBoolean(2, eliminado);
            ps.setInt(3, id);            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n"
                    + "SLQState: " + e.getSQLState() + "\n"
                    + "Mensaje: " + e.getMessage() + "\n");
        }        
    }
    
    public List MuestrasEliminadas() {
        List<TipoMuestraDTO> listM = new ArrayList<>();
        String sql = "SELECT * FROM muestra WHERE Eliminado = 1 ";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoMuestraDTO us = new TipoMuestraDTO();
                us.setIdMuestra(rs.getInt(1));
                us.setNumMuestra(rs.getString(2));
                us.setIdTipoMuestra(rs.getInt(3));
                us.setPresentacion(rs.getString(4));
                us.setCantidadUnidades(rs.getInt(5));
                us.setIdUnidadMedida(rs.getInt(6));
                us.setAdjunto(rs.getString(7));
                us.setFechaCreacion(rs.getDate(8));
                us.setFechaModificacion(rs.getDate(9));
                us.setEliminado(rs.getBoolean(10));
                listM.add(us);
            }
        } catch (SQLException e) {
        }
        return listM;
    }
    
    public void Restaurar(int id) {
        String sql = "UPDATE muestra SET FechaModificacion = ?, Eliminado = ? WHERE IdMuestra = ?  ";
        try {
                        
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            boolean eliminado = false;
            
            ps.setDate(1, sqlDate);            
            ps.setBoolean(2, eliminado);
            ps.setInt(3, id);            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n"
                    + "SLQState: " + e.getSQLState() + "\n"
                    + "Mensaje: " + e.getMessage() + "\n");
        }        
    }
    
    public TipoMuestraDTO ModificarX_ID(int id) {
        TipoMuestraDTO mues = new TipoMuestraDTO();
        String sql = "SELECT * FROM muestra WHERE IdMuestra=" + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                mues.setIdMuestra(rs.getInt(1));
                mues.setNumMuestra(rs.getString(2));
                mues.setIdTipoMuestra(rs.getInt(3));
                mues.setPresentacion(rs.getString(4));
                mues.setCantidadUnidades(rs.getInt(5));
                mues.setIdUnidadMedida(rs.getInt(6));
                //mues.setAdjunto(rs.getString(7));
                mues.setFechaCreacion(rs.getDate(8));
                //mues.setFechaCreacion(rs.getDate(9));                
                mues.setEliminado(rs.getBoolean(10));
            }
        } catch (SQLException e) {
            System.out.println("Mensaje:....." + e.getMessage());
        }
        return mues;
    }
    
        public List ListarSolicitudes() {
        List<TipoMuestraDTO> listM = new ArrayList<>();
        String sql = "SELECT * FROM solicitudes_medicas ";
        
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
