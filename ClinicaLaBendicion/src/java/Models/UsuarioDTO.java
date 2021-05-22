
package Models;

public class UsuarioDTO {
    
    int EntityID;
    String PrimerNombre;
    String SegundoNombre;
    String OtroNombre;
    String PrimerApellido;
    String SegundoApellido;
    String Usuario;
    String PasswordUser;
    String FechaNacimiento;
    int Genero;
    String TelDomicilio;
    String TelMovil;
    String Correo;
    int TipoUsurio;
    String FechaCreacion;
    String FechaModificacion;
    int Estado;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int EntityID, String PrimerNombre, String SegundoNombre, String OtroNombre, String PrimerApellido, String SegundoApellido, String Usuario, String PasswordUser, String FechaNacimiento, int Genero, String TelDomicilio, String TelMovil, String Correo, int TipoUsurio, String FechaCreacion, String FechaModificacion, int Estado) {
        this.EntityID = EntityID;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.OtroNombre = OtroNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Usuario = Usuario;
        this.PasswordUser = PasswordUser;
        this.FechaNacimiento = FechaNacimiento;
        this.Genero = Genero;
        this.TelDomicilio = TelDomicilio;
        this.TelMovil = TelMovil;
        this.Correo = Correo;
        this.TipoUsurio = TipoUsurio;
        this.FechaCreacion = FechaCreacion;
        this.FechaModificacion = FechaModificacion;
        this.Estado = Estado;
    }

    public int getEntityID() {
        return EntityID;
    }

    public void setEntityID(int EntityID) {
        this.EntityID = EntityID;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getOtroNombre() {
        return OtroNombre;
    }

    public void setOtroNombre(String OtroNombre) {
        this.OtroNombre = OtroNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPasswordUser() {
        return PasswordUser;
    }

    public void setPasswordUser(String PasswordUser) {
        this.PasswordUser = PasswordUser;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int Genero) {
        this.Genero = Genero;
    }

    public String getTelDomicilio() {
        return TelDomicilio;
    }

    public void setTelDomicilio(String TelDomicilio) {
        this.TelDomicilio = TelDomicilio;
    }

    public String getTelMovil() {
        return TelMovil;
    }

    public void setTelMovil(String TelMovil) {
        this.TelMovil = TelMovil;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getTipoUsurio() {
        return TipoUsurio;
    }

    public void setTipoUsurio(int TipoUsurio) {
        this.TipoUsurio = TipoUsurio;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(String FechaModificacion) {
        this.FechaModificacion = FechaModificacion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }    
    
}
