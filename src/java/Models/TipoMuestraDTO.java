/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author SammyKazzu
 */
public class TipoMuestraDTO {
    
    int IdTipoMuestra;
    String TipoMuestra;    
    int IdUnidadMedida;
    String UnidadMedida;    
    int IdMuestra;
    String NumMuestra;
    String Presentacion;
    int CantidadUnidades;
    String Adjunto;
    Date FechaCreacion;
    Date FechaModificacion;
    boolean Eliminado;
    int idSolicitudes ;

    public TipoMuestraDTO() {
    }

    public TipoMuestraDTO(int IdTipoMuestra, String TipoMuestra, int IdUnidadMedida, 
                            String UnidadMedida, int IdMuestra, String NumMuestra, String Presentacion,
                            int CantidadUnidades, String Adjunto, Date FechaCreacion, Date FechaModificacion, boolean Eliminado, int idSolicitudes) {
        this.IdTipoMuestra = IdTipoMuestra;
        this.TipoMuestra = TipoMuestra;
        this.IdUnidadMedida = IdUnidadMedida;
        this.UnidadMedida = UnidadMedida;
        this.IdMuestra = IdMuestra;
        this.NumMuestra = NumMuestra;
        this.Presentacion = Presentacion;
        this.CantidadUnidades = CantidadUnidades;
        this.Adjunto = Adjunto;
        this.FechaCreacion = FechaCreacion;
        this.FechaModificacion = FechaModificacion;
        this.Eliminado = Eliminado;
        this.idSolicitudes = idSolicitudes;
    }

    public int getIdTipoMuestra() {
        return IdTipoMuestra;
    }

    public void setIdTipoMuestra(int IdTipoMuestra) {
        this.IdTipoMuestra = IdTipoMuestra;
    }

    public String getTipoMuestra() {
        return TipoMuestra;
    }

    public void setTipoMuestra(String TipoMuestra) {
        this.TipoMuestra = TipoMuestra;
    }

    public int getIdUnidadMedida() {
        return IdUnidadMedida;
    }

    public void setIdUnidadMedida(int IdUnidadMedida) {
        this.IdUnidadMedida = IdUnidadMedida;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    public int getIdMuestra() {
        return IdMuestra;
    }

    public void setIdMuestra(int IdMuestra) {
        this.IdMuestra = IdMuestra;
    }

    public String getNumMuestra() {
        return NumMuestra;
    }

    public void setNumMuestra(String NumMuestra) {
        this.NumMuestra = NumMuestra;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String Presentacion) {
        this.Presentacion = Presentacion;
    }

    public int getCantidadUnidades() {
        return CantidadUnidades;
    }

    public void setCantidadUnidades(int CantidadUnidades) {
        this.CantidadUnidades = CantidadUnidades;
    }

    public String getAdjunto() {
        return Adjunto;
    }

    public void setAdjunto(String Adjunto) {
        this.Adjunto = Adjunto;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Date getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(Date FechaModificacion) {
        this.FechaModificacion = FechaModificacion;
    }

    public boolean isEliminado() {
        return Eliminado;
    }

    public void setEliminado(boolean Eliminado) {
        this.Eliminado = Eliminado;
    }
    
    public int getIdSolicitudes() {
        return idSolicitudes;
    }

    public void setIdSolicitudes(int idSolicitudes) {
        this.idSolicitudes = idSolicitudes;
    }
    
    
}