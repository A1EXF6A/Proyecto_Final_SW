package proyecto_final;

public class Huespedes extends Persona {

    //Atributos de la clase Huespedes
    private boolean reserva = false;
    private boolean hospedaje = false;
    private double temperatura = 0.0;
    private String pais = "";

    //Constructor
    public Huespedes(boolean reserva, boolean hospedaje, double temperatura, String pais, String cédula, String nombre, String apellido, String direccion, String telefono) {
        super(cédula, nombre, apellido, direccion, telefono);
        this.reserva = reserva;
        this.hospedaje = hospedaje;
        this.temperatura = temperatura;
        this.pais = pais;
    }

    //Mostrar datos
    public void getAtributos() {
        System.out.println("NOMBRE: " + this.nombre);
        System.out.println("APELLIDO: " + this.apellido);
        System.out.println("CÉDULA: " + this.cédula);
        System.out.println("DIRECCIÓN: " + this.direccion);
        System.out.println("TÉLEFONO: " + this.telefono);
        if (this.reserva = false) {
            System.out.println("RESERVACIÓN: " + "NO TIENE RESERVACIÓN");
        } else {
            System.out.println("RESERVACIÓN: " + "SI TIENE RESERVACION");
        }
        if (this.hospedaje = false) {
            System.out.println("HOSPEDAJE: " + "NO SE ENCUENTRA HOSPEDADO");
        } else {
            System.out.println("HOSPEDAJE: " + "SE ENCUENTRA ACTUALMENTE HOSPEDADO");
        }
        System.out.println("TEMPERATURA: " + this.temperatura);
        System.out.println("PAIS DE DONDE VIENE: " + this.pais);

    }

}
