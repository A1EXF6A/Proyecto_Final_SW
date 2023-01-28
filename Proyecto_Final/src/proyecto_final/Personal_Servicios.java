package proyecto_final;

public class Personal_Servicios extends Persona {
    //Atributos de la clase Personal_Servicios
    private String cargo;
    private int hora_entrada,hora_salida;
   
    
    //Constructor de la clase
    public Personal_Servicios(String cargo, String cédula, String nombre, String apellido, String direccion, String telefono) {
        super(cédula, nombre, apellido, direccion, telefono);
        this.cargo = cargo;
    }

    //Mostrar datos
    public void getAtributos() {
        System.out.println("NOMBRE: " + this.nombre);
        System.out.println("APELLIDO: " + this.apellido);
        System.out.println("CÉDULA: " + this.cédula);
        System.out.println("DIRECCIÓN: " + this.direccion);
        System.out.println("TÉLEFONO: " + this.telefono);
        System.out.println("CARGO: " + this.cargo);
    }
    
    //Metodos de la clase
    public void actCargo(String newcargo){
        this.cargo=newcargo;
    }
       
}
