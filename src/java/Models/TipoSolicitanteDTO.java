
package Models;

/**
 *
 * @author Alexander Elias
 */
public class TipoSolicitanteDTO {
    
    int idTipoSolicitnate;
    String nombreTipoSolicitante;

    public TipoSolicitanteDTO() {
    }

    public TipoSolicitanteDTO(int idTipoSolicitnate, String nombreTipoSolicitante) {
        this.idTipoSolicitnate = idTipoSolicitnate;
        this.nombreTipoSolicitante = nombreTipoSolicitante;
    }

    public int getIdTipoSolicitnate() {
        return idTipoSolicitnate;
    }

    public void setIdTipoSolicitnate(int idTipoSolicitnate) {
        this.idTipoSolicitnate = idTipoSolicitnate;
    }

    public String getNombreTipoSolicitante() {
        return nombreTipoSolicitante;
    }

    public void setNombreTipoSolicitante(String nombreTipoSolicitante) {
        this.nombreTipoSolicitante = nombreTipoSolicitante;
    }

   
    
}
