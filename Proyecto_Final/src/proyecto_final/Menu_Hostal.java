package proyecto_final;

import java.util.ArrayList;
import java.util.Scanner;
import static proyecto_final.Personal_Servicios.DatosPersonal;

public class Menu_Hostal {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        //Atributos
        int op;
        boolean exit = false;
        //Codigo Menú
        do {
            System.out.printf("\n", "OPCIONES");
            System.out.println("[1] Ingreso de datos del personal de servicios");
            System.out.println("[2] Ingreso-Salida de huespedes");
            System.out.println("[3] Ver atributos de objetos");
            System.out.println("[4] Datos Generales");
            System.out.println("[5] Salir");
            try {
                op = Integer.valueOf(tec.next());

                switch (op) {
                    case 1:
                        DatosPersonal();
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        exit = true;
                        System.out.println("GRACIAS POR USAR EL PROGRAMA");
                        break;
                    default:
                        System.out.println("Ingresar solo numeros dentro del menú");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ingrese solo numeros");
            }
        } while (exit != true);

    }
}
