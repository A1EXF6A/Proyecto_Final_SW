package proyecto_final;

import java.util.Calendar;
import java.util.Scanner;

public class Personal_Servicios extends Persona {

    Scanner teclado = new Scanner(System.in);
    //Atributos de la clase Personal_Servicios
    protected String cargo;

    //Constructor de la clase
    public Personal_Servicios(String cargo, String cédula, String nombre, String apellido, String direccion, String telefono, String hora_entrada, String hora_salida) {
        super(cédula, nombre, apellido, direccion, telefono, hora_entrada, hora_salida);
        this.cargo = cargo;
    }

    //Mostrar datos
    public void IngresarDatos() {
        boolean verificar = false;
        String ingreso_nombre;
        do {
            try {
                System.out.print("Nombre: ");
                ingreso_nombre = teclado.next();
                verificar = ingreso_nombre.matches("[a-zA-Z]{3,15}");
                if (verificar == true) {
                    super.nombre = ingreso_nombre;
                }
                if (verificar == false) {
                    System.out.println("Nombre invalido");
                }
            } catch (Exception e) {
                System.out.println("Ingrese solo letras");
            }
        } while (verificar == false);

        String ingreso_apellido;
        do {
            try {
                System.out.print("Apellido: ");
                ingreso_apellido = teclado.next();
                verificar = ingreso_apellido.matches("[a-zA-Z]{3,15}");
                if (verificar == true) {
                    super.apellido = ingreso_apellido;
                }
                if (verificar == false) {
                    System.out.println("Error de datos");
                }
            } catch (Exception e) {
                System.out.println("Ingrese solo letras");
            }
        } while (verificar == false);
        String ingreso_cedula = null;

        do {
            try {
                System.out.print("Cedula: ");
                ingreso_cedula = teclado.next();
                verificar = ingreso_cedula.matches(patroncedula);
                if (verificar == true) {
                    super.cédula = ingreso_cedula;
                }
                if (verificar == false) {
                    System.out.println("ingrese una cedula valida");
                }
            } catch (Exception e) {
                System.out.println("Ingrese unicamente numeros");
            }
        } while (verificar == false);
        String ingreso_direccion;
        do {
            System.out.print("Direccion: ");
            ingreso_direccion = teclado.next();
            verificar = ingreso_direccion.matches("[a-zA-Z0-9]{3,20}");
            if (verificar == true) {
                super.direccion = ingreso_direccion;
            }
            if (verificar == false) {
                System.out.println("Direccion invalida");
            }
        } while (verificar == false);
        String ingreso_telefono;
        do {
            System.out.print("telefono: ");
            ingreso_telefono = teclado.next();
            verificar = ingreso_telefono.matches("[0][9][0-9]{8}");
            if (verificar == true) {
                super.telefono = ingreso_telefono;
            }
            if (verificar == false) {
                System.out.println("telefono invalido");
            }
        } while (verificar == false);
        String ingreso_cargo;
        do {
            System.out.print("Cargo: ");
            ingreso_cargo = teclado.next();
            verificar = ingreso_cargo.matches("[a-zA-Z]{5,15}");
            if (verificar == true) {
                this.cargo = ingreso_cargo;
            }
            if (verificar == false) {
                System.out.println("Ingresar cargo valido");
            }
        } while (verificar == false);
    }

    public void Entrar() {
        String opcion2 = null;
        int hora, minutos, segundos;
        do {
            try {
                System.out.println("Quiere empezar su turno");
                opcion2 = teclado.next();
                if (opcion2.equalsIgnoreCase("Si")) {
                    hora = calendario.get(Calendar.HOUR_OF_DAY);
                    minutos = calendario.get(Calendar.MINUTE);
                    segundos = calendario.get(Calendar.SECOND);
                    System.out.println("Hora de ingreso: " + hora + ":" + minutos + ":" + segundos);
                    super.hora_entrada = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);
                } else if (opcion2.equalsIgnoreCase("no")) {
                } else {
                    System.out.println("Ingrese solo si o no");
                }

            } catch (Exception e) {
                System.out.println("error");

            }
        } while (!opcion2.equalsIgnoreCase("no") && !opcion2.equalsIgnoreCase("si"));

    }
        public void salir() {
        String opcion2 = null;
        int hora, minutos, segundos;
        do {
            try {
                System.out.println("Quiere terminar su turno");
                opcion2 = teclado.next();
                if (opcion2.equalsIgnoreCase("Si")) {
                    hora = calendario.get(Calendar.HOUR_OF_DAY);
                    minutos = calendario.get(Calendar.MINUTE);
                    segundos = calendario.get(Calendar.SECOND);
                    System.out.println("Hora de ingreso: " + hora + ":" + minutos + ":" + segundos);
                    super.hora_salida = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);
                } else if (opcion2.equalsIgnoreCase("no")) {
                } else {
                    System.out.println("Ingrese solo si o no");
                }

            } catch (Exception e) {
                System.out.println("error");

            }
        } while (!opcion2.equalsIgnoreCase("no") && !opcion2.equalsIgnoreCase("si"));

    }

    
    public void getAtributos() {
//return ("NOMBRE: " + this.nombre+"APELLIDO: " + this.apellido+"CÉDULA: " + this.cédula+"DIRECCIÓN: " + this.direccion+"TÉLEFONO: " + this.telefono+"CARGO: " + this.cargo);
        cargo = teclado.next();
        System.out.println("NOMBRE: " + this.nombre);
        System.out.println("APELLIDO: " + this.apellido);
        System.out.println("CÉDULA: " + this.cédula);
        System.out.println("DIRECCIÓN: " + this.direccion);
        System.out.println("TÉLEFONO: " + this.telefono);
        System.out.println("CARGO: " + this.cargo);
    }

    //Metodos de la clase
}
