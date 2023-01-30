package proyecto_final;

public class Persona extends Ingreso_Salida {

    protected String cédula;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;

    public Persona(String cédula, String nombre, String apellido, String direccion, String telefono) {
        super(hora_entrada,hora_salida);
        this.cédula = cédula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCédula() {
        return cédula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCédula(String cédula) {
        this.cédula = cédula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
