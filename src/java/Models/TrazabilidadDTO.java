package Models;

import java.util.Date;

/**
 *
 * @author Alexander Elias
 */
public class TrazabilidadDTO {
    
    int idTrazabilidad;
    String codigoSolicitud;
    int estadoSolicitud;
    String nombreEstado;
    String enviadoPor;
    String asignadoA;
    String fecha;
    String duracion;
    String acumulado;
    String observaciones;
    String asignacion;

    public TrazabilidadDTO() {
    }

    public TrazabilidadDTO(int idTrazabilidad, String codigoSolicitud, int estadoSolicitud, String nombreEstado, String enviadoPor, String asignadoA, String fecha, String duracion, String acumulado, String observaciones, String asignacion) {
        this.idTrazabilidad = idTrazabilidad;
        this.codigoSolicitud = codigoSolicitud;
        this.estadoSolicitud = estadoSolicitud;
        this.nombreEstado = nombreEstado;
        this.enviadoPor = enviadoPor;
        this.asignadoA = asignadoA;
        this.fecha = fecha;
        this.duracion = duracion;
        this.acumulado = acumulado;
        this.observaciones = observaciones;
        this.asignacion = asignacion;
    }

    public int getIdTrazabilidad() {
        return idTrazabilidad;
    }

    public void setIdTrazabilidad(int idTrazabilidad) {
        this.idTrazabilidad = idTrazabilidad;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public int getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(int estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getEnviadoPor() {
        return enviadoPor;
    }

    public void setEnviadoPor(String enviadoPor) {
        this.enviadoPor = enviadoPor;
    }

    public String getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(String asignadoA) {
        this.asignadoA = asignadoA;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(String acumulado) {
        this.acumulado = acumulado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

   
   
    
    
    
}
