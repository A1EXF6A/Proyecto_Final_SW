package proyecto_final;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu_Hostal {

    ArrayList<Personal_Servicios> ListaPersonal;

    public static void main(String[] args) throws IOException {
        int contador_archivos;
        String nombre_archivoempleados = "empleados.txt", nombre_archivohuespedes = "huespedes.txt";
        File empleados = new File(nombre_archivoempleados);
        File huespedes = new File(nombre_archivohuespedes);
        FileWriter fwempleados = new FileWriter(empleados);
        PrintWriter Guardar_empleados = new PrintWriter(fwempleados);
        FileReader frempleados = new FileReader(empleados);
        Scanner leer_empleados = new Scanner(frempleados);

        Scanner teclado = new Scanner(System.in);
        //Atributos
        int op, op1;
        boolean exit = false;
        ArrayList<Personal_Servicios> ListaPersonal = new ArrayList();
        //Codigo Menú
        do {
            System.out.printf("\n", "OPCIONES");
            System.out.println("[1] Menú del Personal");
            System.out.println("[2] Ingreso-Salida de huespedes");
            System.out.println("[3] Datos de empleados y huespedes");
            System.out.println("[4] Datos Generales");
            System.out.println("[5] Salir");
            try {
                op = Integer.valueOf(teclado.next());

                switch (op) {
                    case 1:
                        Personal_Servicios empleado = new Personal_Servicios("", "", "", "", "", "", "", "");
                        int op3;
                        boolean salir = false;
                        do {
                            try {
                                System.out.println("Que accion desea realizar: ");
                                System.out.println("[1] Ingresar un nuevo empleado");
                                System.out.println("[2] Ingresar a trabajar");
                                System.out.println("[3] Salir de trabajar");
                                System.out.println("[4] Regresar");
                                op3 = Integer.valueOf(teclado.next());
                                switch (op3) {
                                    case 1:
                                        empleado.IngresarDatos();
                                        Guardar_empleados.printf("%s,%s,%s,%s,%s,%s,%s,%s", empleado.cargo, empleado.cédula, empleado.nombre, empleado.apellido,
                                                empleado.direccion, empleado.telefono, empleado.hora_entrada, empleado.hora_salida);
                                        ListaPersonal.add(new Personal_Servicios(empleado.cargo, empleado.cédula, empleado.nombre, empleado.apellido,
                                                empleado.direccion, empleado.telefono, empleado.hora_entrada, empleado.hora_salida));
                                        Guardar_empleados.close();
                                        break;
                                    case 2:
                                        empleado.Entrar();
                                        break;
                                    case 3:
                                        empleado.salir();
                                        break;
                                    case 4:
                                        salir = true;
                                        break;
                                    default:
                                        System.out.println("Ingresar solo numeros dentro del menu");
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ingresar solo numeros");
                            }
                        } while (salir != true);

//                        System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", "CARGO", "CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO", "HORA DE ENTRADA", "HORA DE SALIDA");
//                        for (int i = 0; i < ListaPersonal.size(); i++) {
//                            System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", ListaPersonal.get(i).cargo,
//                                    ListaPersonal.get(i).cédula, ListaPersonal.get(i).nombre, ListaPersonal.get(i).apellido,
//                                    ListaPersonal.get(i).direccion, ListaPersonal.get(i).telefono, ListaPersonal.get(i).hora_entrada, ListaPersonal.get(i).hora_salida);
//                        }
                        break;
                    case 2:
                        Huespedes huesped = new Huespedes(false, false, 0, "", "", "", "", "", "", "", "");
                        System.out.println("[1] Hacer una reservacion");
                        System.out.println("[2] Confirmar un hospedaje");
                        System.out.println("[3] Desocupar cuarto");
                        op1 = Integer.valueOf(teclado.next());
                        switch (op1) {
                            case 1:
                                String op2;
                                do {
                                    System.out.println("Bienvenido, desea alojarse en nuestro hotel:");
                                    op2 = teclado.next();
                                    if (op2.equalsIgnoreCase("Sí")) {
                                        huesped.Entrada();
                                        ArrayList<Huespedes> ListaHuespedes = new ArrayList();
                                        ListaHuespedes.add(huesped);
                                        //reservacion
                                    } else if (op2.equalsIgnoreCase("no")) {
                                        break;
                                    } else {
                                        System.out.println("Ingrese solo si o no");
                                    }
                                } while (!op2.equalsIgnoreCase("no") && !op2.equalsIgnoreCase("si"));
                                break;
                            case 2:
                                System.out.println("Desea confirmar hospedaje");
                                //Guardar en archivo

                                break;
                            case 3:
                                System.out.println("Desea salir del hotel");
                                break;

                            default:
                                System.out.println("Ingresar numeros dentro del menu");

                        }

                        break;
                    case 3:
                        for (int i = 0; i < ListaPersonal.size(); i++) {

                            System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", "CARGO", "CEDULA", "NOMBRE", "APELLIDO",
                                    "DIRECCION", "TELEFONO", "HORA DE ENTRADA", "HORA DE SALIDA");
                            System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", ListaPersonal.get(i).cargo,
                                    ListaPersonal.get(i).cédula, ListaPersonal.get(i).nombre, ListaPersonal.get(i).apellido,
                                    ListaPersonal.get(i).direccion, ListaPersonal.get(i).telefono, ListaPersonal.get(i).hora_entrada, ListaPersonal.get(i).hora_salida);
                        }
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
