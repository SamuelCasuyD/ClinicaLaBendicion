
package Models;

/**
 *
 * @author Alexander Elias
 */
public class SolicitudesMedicasDTO {
    
    int idSolicitud;
    String codigoSolicitud;
    int tipoSolicitante;    
    String nombreTipoSolicitante;
    int tipoSolicitud;  
    String nombreTipoSolicitud;
    String Descripcion;
    String numExpediente;
    String nit;
    String nombre;
    String telefono;
    String email;
    String fechaCreacion;
    String fechaModificaion;
    int usuarioCreacion;
    int usuraioModificacion;
    int usuarioAsignacion;
    int tipoSoporte;
    String numSoporte;
    String nombreSoporte;

    int estadoSolicitud;
    String nombreEstadoSolicitud;

    int cantidadMuestras;
    int cantidadItems;
    int cantidadDocs;
    int diasVencimiento;
    
    String observaciones;

    public SolicitudesMedicasDTO() {
    }

    public SolicitudesMedicasDTO(int idSolicitud, String codigoSolicitud, int tipoSolicitante, String nombreTipoSolicitante, int tipoSolicitud, String nombreTipoSolicitud, String Descripcion, String numExpediente, String nit, String nombre, String telefono, String email, String fechaCreacion, String fechaModificaion, int usuarioCreacion, int usuraioModificacion, int usuarioAsignacion, int tipoSoporte, String numSoporte, String nombreSoporte, int estadoSolicitud, String nombreEstadoSolicitud, int cantidadMuestras, int cantidadItems, int cantidadDocs, int diasVencimiento, String observaciones) {
        this.idSolicitud = idSolicitud;
        this.codigoSolicitud = codigoSolicitud;
        this.tipoSolicitante = tipoSolicitante;
        this.nombreTipoSolicitante = nombreTipoSolicitante;
        this.tipoSolicitud = tipoSolicitud;
        this.nombreTipoSolicitud = nombreTipoSolicitud;
        this.Descripcion = Descripcion;
        this.numExpediente = numExpediente;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificaion = fechaModificaion;
        this.usuarioCreacion = usuarioCreacion;
        this.usuraioModificacion = usuraioModificacion;
        this.usuarioAsignacion = usuarioAsignacion;
        this.tipoSoporte = tipoSoporte;
        this.numSoporte = numSoporte;
        this.nombreSoporte = nombreSoporte;
        this.estadoSolicitud = estadoSolicitud;
        this.nombreEstadoSolicitud = nombreEstadoSolicitud;
        this.cantidadMuestras = cantidadMuestras;
        this.cantidadItems = cantidadItems;
        this.cantidadDocs = cantidadDocs;
        this.diasVencimiento = diasVencimiento;
        this.observaciones = observaciones;
    }

    

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public int getTipoSolicitante() {
        return tipoSolicitante;
    }

    public void setTipoSolicitante(int tipoSolicitante) {
        this.tipoSolicitante = tipoSolicitante;
    }

    public String getNombreTipoSolicitante() {
        return nombreTipoSolicitante;
    }

    public void setNombreTipoSolicitante(String nombreTipoSolicitante) {
        this.nombreTipoSolicitante = nombreTipoSolicitante;
    }

    public int getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(int tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getNombreTipoSolicitud() {
        return nombreTipoSolicitud;
    }

    public void setNombreTipoSolicitud(String nombreTipoSolicitud) {
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificaion() {
        return fechaModificaion;
    }

    public void setFechaModificaion(String fechaModificaion) {
        this.fechaModificaion = fechaModificaion;
    }

    public int getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(int usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public int getUsuraioModificacion() {
        return usuraioModificacion;
    }

    public void setUsuraioModificacion(int usuraioModificacion) {
        this.usuraioModificacion = usuraioModificacion;
    }

    public int getUsuarioAsignacion() {
        return usuarioAsignacion;
    }

    public void setUsuarioAsignacion(int usuarioAsignacion) {
        this.usuarioAsignacion = usuarioAsignacion;
    }

    public int getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(int tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    public String getNumSoporte() {
        return numSoporte;
    }

    public void setNumSoporte(String numSoporte) {
        this.numSoporte = numSoporte;
    }

    public String getNombreSoporte() {
        return nombreSoporte;
    }

    public void setNombreSoporte(String nombreSoporte) {
        this.nombreSoporte = nombreSoporte;
    }

    public int getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(int estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getNombreEstadoSolicitud() {
        return nombreEstadoSolicitud;
    }

    public void setNombreEstadoSolicitud(String nombreEstadoSolicitud) {
        this.nombreEstadoSolicitud = nombreEstadoSolicitud;
    }

    public int getCantidadMuestras() {
        return cantidadMuestras;
    }

    public void setCantidadMuestras(int cantidadMuestras) {
        this.cantidadMuestras = cantidadMuestras;
    }

    public int getCantidadItems() {
        return cantidadItems;
    }

    public void setCantidadItems(int cantidadItems) {
        this.cantidadItems = cantidadItems;
    }

    public int getCantidadDocs() {
        return cantidadDocs;
    }

    public void setCantidadDocs(int cantidadDocs) {
        this.cantidadDocs = cantidadDocs;
    }

    public int getDiasVencimiento() {
        return diasVencimiento;
    }

    public void setDiasVencimiento(int diasVencimiento) {
        this.diasVencimiento = diasVencimiento;
    }   

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
