package proyecto_final;

import java.util.Scanner;

public class Menu_Hostal {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        //Atributos
        int op;
        boolean exit = false;
        String op1;
        //Codigo Menú

        System.out.printf("\n", "OPCIONES");
        System.out.println("[1] Ingreso de datos del personal de servicios");
        System.out.println("[2] Ingreso-Salida de huespedes");
        System.out.println("[3] Ver atributos de objetos");
        System.out.println("[4] Datos Generales");
        System.out.println("[5] Salir");
        op = Integer.valueOf(tec.next());

        switch (op) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Huespedes person = new Huespedes(true, true, 36.00, "Ecuador", "0150496420", "David", "Giler", "Cuenca", "099485720");
                person.getAtributos();
                break;
            case 5:
                System.out.println("De verdad deseas salir s/n");
                op1 = tec.next();
                if (op1.equalsIgnoreCase("S")) {
                    exit = true;
                }
                break;
        }

    }

    public static void DatosPersonal() {
        Scanner tec = new Scanner(System.in);
        //Atributos
        String nombre, apellido, cedula, telefono, direccion, cargo;

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
        Personal_Servicios empleado = new Personal_Servicios(cargo, cedula, nombre, apellido, direccion, telefono);
        System.out.println("Se agrego un nuevo empleado");

    }
}
