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
public class TipoSoporteDTO {
    
    int idSoprte;
    String nombreSoporte;
    int idTipoSoporte;
    String nombreTipoSoporte;

    public TipoSoporteDTO() {
    }

    public TipoSoporteDTO(int idSoprte, String nombreSoporte, int idTipoSoporte, String nombreTipoSoporte) {
        this.idSoprte = idSoprte;
        this.nombreSoporte = nombreSoporte;
        this.idTipoSoporte = idTipoSoporte;
        this.nombreTipoSoporte = nombreTipoSoporte;
    }
    
    

    public int getIdSoprte() {
        return idSoprte;
    }

    public void setIdSoprte(int idSoprte) {
        this.idSoprte = idSoprte;
    }

    public String getNombreSoporte() {
        return nombreSoporte;
    }

    public void setNombreSoporte(String nombreSoporte) {
        this.nombreSoporte = nombreSoporte;
    }

    public int getIdTipoSoporte() {
        return idTipoSoporte;
    }

    public void setIdTipoSoporte(int idTipoSoporte) {
        this.idTipoSoporte = idTipoSoporte;
    }

    public String getNombreTipoSoporte() {
        return nombreTipoSoporte;
    }

    public void setNombreTipoSoporte(String nombreTipoSoporte) {
        this.nombreTipoSoporte = nombreTipoSoporte;
    }
    
    
    
    

    
}
