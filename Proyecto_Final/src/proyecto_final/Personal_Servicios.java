package proyecto_final;

public class Personal_Servicios extends Persona {

    private String cargo;

    public Personal_Servicios(String cargo, String cédula, String nombre, String apellido, String direccion, String telefono) {
        super(cédula, nombre, apellido, direccion, telefono);
        this.cargo = cargo;
    }

    public void getAtributos() {
        System.out.println("NOMBRE: " + this.nombre);
        System.out.println("APELLIDO: " + this.apellido);
        System.out.println("CÉDULA: " + this.cédula);
        System.out.println("DIRECCIÓN: " + this.direccion);
        System.out.println("TÉLEFONO: " + this.telefono);
        System.out.println("CARGO: " + this.cargo);

    }

}
