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
public class ItemsDTO {
    
    int IdItems;
    String NombreItems;
    Date FechaCreacion;
    Date FechaModificacion;
    boolean Eliminado;

    public ItemsDTO() {
    }

    public ItemsDTO(int IdItems, String NombreItems, Date FechaCreacion, Date FechaModificacion, boolean Eliminado) {
        this.IdItems = IdItems;
        this.NombreItems = NombreItems;
        this.FechaCreacion = FechaCreacion;
        this.FechaModificacion = FechaModificacion;
        this.Eliminado = Eliminado;
    }

    public int getIdItems() {
        return IdItems;
    }

    public void setIdItems(int IdItems) {
        this.IdItems = IdItems;
    }

    public String getNombreItems() {
        return NombreItems;
    }

    public void setNombreItems(String NombreItems) {
        this.NombreItems = NombreItems;
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
