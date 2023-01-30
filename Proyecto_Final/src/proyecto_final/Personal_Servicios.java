package proyecto_final;

import java.util.ArrayList;
import java.util.Scanner;

public class Personal_Servicios extends Persona {

    //Atributos de la clase Personal_Servicios

    private String cargo;
    private int hora_entrada, hora_salida;

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
    public void actCargo(String newcargo) {
        this.cargo = newcargo;
    }

    public static void DatosPersonal() {
        Scanner tec = new Scanner(System.in);
        //Atributos
        String nombre, apellido, cedula, telefono, direccion, cargo;
        System.out.println("AGREGAR NUEVO EMPLEADO");
        System.out.println("Ingrese el nombre");
        nombre = tec.next();
        System.out.println("Ingrese el apellido");
        apellido = tec.next();
        System.out.println("Ingrese el numero de cedula");
        cedula = tec.next();
        System.out.println("Ingrese el numero de telefono");
        telefono = tec.next();
        System.out.println("Ingrese la direccion");
        direccion = tec.next();
        System.out.println("Ingrese el cargo de trabajo");
        cargo = tec.next();
        ArrayList<Personal_Servicios> ListaEmpleados = new ArrayList();
        Personal_Servicios empleado = new Personal_Servicios(cargo, cedula, nombre, apellido, direccion, telefono);
        ListaEmpleados.add(empleado);

    }

}
