/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.ItemsDTO;
import Models.SolicitudesMedicasDTO;
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

    //SELECT COUNT(idItems) as "Items" FROM items_muestras_asociadas WHERE idMuestra = 1;
    public List ListarMuestras() {
        List<TipoMuestraDTO> listM = new ArrayList<>();
        String sql = "SELECT A.IdMuestra, A.NumMuestra, A.IdTipoMuestra, A.Presentacion, A.CantidadUnidades, A.IdUnidadMedida, A.Adjunto, A.FechaCreacion, A.FechaModificacion, A.Eliminado, A.idSolicitudes, A.idItem, COUNT(B.idItems) as 'cantItems' FROM muestra A, items_muestras_asociadas B \n"
                + "\n"
                + "WHERE A.IdMuestra = B.idMuestra and A.Eliminado = 0\n"
                + "\n"
                + "GROUP BY IdMuestra";

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
                m.setIdSolicitudes(rs.getInt(11));
                m.setCantItems(rs.getInt("cantItems"));
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

    public List ListarItems() {
        List<ItemsDTO> item = new ArrayList<>();
        String sql = "select * from items";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ItemsDTO m = new ItemsDTO();

                m.setIdItems(rs.getInt(1));
                m.setNombreItems(rs.getString(2));
                m.setFechaCreacion(rs.getDate(3));
                m.setFechaModificacion(rs.getDate(4));
                m.setEliminado(rs.getBoolean(5));

                item.add(m);
            }
        } catch (SQLException e) {
        }
        return item;
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
            //ps.setInt(8, pa.getIdMuestra());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("C??digo de Error: " + e.getErrorCode() + "\n"
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
            System.out.println("C??digo de Error: " + e.getErrorCode() + "\n"
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
            System.out.println("C??digo de Error: " + e.getErrorCode() + "\n"
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
        List<SolicitudesMedicasDTO> listM = new ArrayList<>();
        String sql = "SELECT * FROM solicitudes_medicas";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                SolicitudesMedicasDTO sol = new SolicitudesMedicasDTO();

                sol.setIdSolicitud(rs.getInt("idSolicitudes"));// A.codigoSolicitud, 
                sol.setCodigoSolicitud(rs.getString("codigoSolicitud")); //A.NoExpediente,
                sol.setNumExpediente(rs.getString("NoExpediente")); //A.NoExpediente,
                //sol.setNit(rs.getString(3)); // A.nit, 
                //sol.setNumSoporte(rs.getString(4)); //   A.numSoporte,
                //sol.setNombreSoporte(rs.getString(5));   //  D.nombreSoporte, 
                //sol.setNombreTipoSolicitante(rs.getString(6)); // E.nombreTipoSolicitante,
                //sol.setNombreTipoSolicitud(rs.getString(7));      //B.nombreTipoSolicitud,
                //sol.setUsuarioAsignacion(rs.getInt(8)); // A.UsuarioAsignacion,               
                //sol.setNombreEstadoSolicitud(rs.getString(9)); //C.nombreEstadoSolicitud,               
                //sol.setUsuarioCreacion(rs.getInt(10));// A.UsuarioCreacion,               
                //sol.setFechaCreacion(rs.getString(11));                
                //sol.setDescripcion(rs.getString(12));               
                sol.setNombre(rs.getString("nombre"));
                //sol.setTelefono(rs.getString(14));
                //sol.setEmail(rs.getString(15));
                listM.add(sol);
            }
        } catch (SQLException e) {
        }
        return listM;
    }

    public int actualizar(TipoMuestraDTO pau) {
        String sql = "UPDATE muestra SET IdTipoMuestra=?, Presentacion=?, CantidadUnidades=?, "
                + "IdUnidadMedida=?, FechaModificacion=? "
                + "WHERE IdMuestra=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, pau.getIdTipoMuestra());
            ps.setString(2, pau.getPresentacion());
            ps.setInt(3, pau.getCantidadUnidades());
            ps.setInt(4, pau.getIdUnidadMedida());
            ps.setDate(5, (Date) pau.getFechaCreacion());
            ps.setInt(6, pau.getIdMuestra());
            ps.executeUpdate();

        } catch (SQLException e) {
        }
        return r;
    }

    public SolicitudesMedicasDTO Buscasoli(String codigoSolicitud) {
        SolicitudesMedicasDTO idSoli = new SolicitudesMedicasDTO();
        String sql = "select* from solicitudes_medicas where codigoSolicitud = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigoSolicitud);
            rs = ps.executeQuery();

            while (rs.next()) {
                idSoli.setIdSolicitud(rs.getInt("idSolicitudes"));// A.codigoSolicitud, 
                idSoli.setCodigoSolicitud(rs.getString("codigoSolicitud")); //A.NoExpediente,
                idSoli.setNumExpediente(rs.getString("NoExpediente")); //A.NoExpediente,
                idSoli.setNombre(rs.getString("nombre")); //A.NoExpediente, 
            }
        } catch (Exception e) {
        }
        return idSoli;
    }

    public TipoMuestraDTO BuscarNoMuestra(String codigoSolicitud) {
        TipoMuestraDTO idSoli = new TipoMuestraDTO();
        String sql = "select* from muestra where NumMuestra  = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigoSolicitud);
            rs = ps.executeQuery();

            while (rs.next()) {
                idSoli.setIdMuestra(rs.getInt("IdMuestra"));
                idSoli.setNumMuestra(rs.getString("NumMuestra"));
            }
        } catch (Exception e) {
        }
        return idSoli;
    }

}
