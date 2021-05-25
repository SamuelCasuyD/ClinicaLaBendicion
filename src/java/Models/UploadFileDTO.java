/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author SammyKazzu
 */
public class UploadFileDTO {
    
    int IdAdjunto;
    String NumMuestra;
    String PathName;
    Date FechaCreacion;
    Date FechaModificacion;
    boolean Eliminado;

    public UploadFileDTO() {
    }

    public UploadFileDTO(int IdAdjunto, String NumMuestra, String PathName, Date FechaCreacion, Date FechaModificacion, boolean Eliminado) {
        this.IdAdjunto = IdAdjunto;
        this.NumMuestra = NumMuestra;
        this.PathName = PathName;
        this.FechaCreacion = FechaCreacion;
        this.FechaModificacion = FechaModificacion;
        this.Eliminado = Eliminado;
    }

    public int getIdAdjunto() {
        return IdAdjunto;
    }

    public void setIdAdjunto(int IdAdjunto) {
        this.IdAdjunto = IdAdjunto;
    }

    public String getNumMuestra() {
        return NumMuestra;
    }

    public void setNumMuestra(String NumMuestra) {
        this.NumMuestra = NumMuestra;
    }

    public String getPathName() {
        return PathName;
    }

    public void setPathName(String PathName) {
        this.PathName = PathName;
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
    
}
