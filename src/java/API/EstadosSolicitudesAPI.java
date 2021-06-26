/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Models.EstadosSolicitudesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Elias
 */
public class EstadosSolicitudesAPI {
    
    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    public List listarEstadosSolicitudes(){
        List<EstadosSolicitudesDTO>estado = new ArrayList();
        String sql="select * from estados_solicitudes";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                EstadosSolicitudesDTO estSol = new EstadosSolicitudesDTO();
                estSol.setIdEstado(rs.getInt(1));
                estSol.setNombreEstado(rs.getString(2));
                            
                estado.add(estSol);
            }
        } catch(Exception e){
            
        }
        
        return estado;
        
    }
    
    public List<EstadosSolicitudesDTO> listarEstadosSolicitudesCentralizador(){
        List<EstadosSolicitudesDTO>estado = new ArrayList();
        String sql="select * from estados_solicitudes WHERE idEstadoSolicitud = 3 and idEstadoSolicitud < 8";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                EstadosSolicitudesDTO estSol = new EstadosSolicitudesDTO();
                estSol.setIdEstado(rs.getInt(1));
                estSol.setNombreEstado(rs.getString(2));
                            
                estado.add(estSol);
            }
        } catch(Exception e){
            
        }
        
        return estado;
        
    }
    
    public List<EstadosSolicitudesDTO> listarEstadosSolicitudesRevisior(){
        List<EstadosSolicitudesDTO>estado = new ArrayList();
        String sql="select * from estados_solicitudes WHERE idEstadoSolicitud > 3 and idEstadoSolicitud < 8 or idEstadoSolicitud = 9";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                EstadosSolicitudesDTO estSol = new EstadosSolicitudesDTO();
                estSol.setIdEstado(rs.getInt(1));
                estSol.setNombreEstado(rs.getString(2));
                            
                estado.add(estSol);
            }
        } catch(Exception e){
            
        }
        
        return estado;
        
    }
    
}
