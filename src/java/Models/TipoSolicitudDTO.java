/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Alexander Elias
 */
public class TipoSolicitudDTO {
    int idTipoSolicitud;
    String nombreTipoSolicitud;

    public TipoSolicitudDTO(int idTipoSolicitud, String nombreTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }

    public TipoSolicitudDTO() {
    }

    public int getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(int idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getNombreTipoSolicitud() {
        return nombreTipoSolicitud;
    }

    public void setNombreTipoSolicitud(String nombreTipoSolicitud) {
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }
    
    
}
