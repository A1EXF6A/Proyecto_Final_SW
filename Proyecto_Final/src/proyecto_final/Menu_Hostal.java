package proyecto_final;

import java.util.Scanner;

public class Menu_Hostal {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        //Atributos
        int op;
        boolean exit = false;
        String op1;
        //OPCION 2
        String opc,is;
        boolean ver,ver2; int y=0;
        int opc6=0; String option="";
        Ingreso_Salida gg = new Ingreso_Salida("", opc6, opc6, opc6, true, true, opc6, "", "", option, option, option, option);
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
                        break;
                    case 2:
                        do {
                            do {
                                System.out.println("BIENBENIDO AL HOTEL XXXXXX");
                                System.out.println("ELIJA LA OPCION\n1 ingreso\n2 salida");
                                is = tec.next();
                                ver2 = is.matches("[1]||[2]");
                                if(is.equals("1")==true){
                                    System.out.println("Ingrese los siguientes datos");
                                    gg.Entrada();
                                }else if(is.equals("2")){
                                    System.out.println("Gracias por visitarnos");
                                    gg.salir();
                                }
                                
                                
                                if(ver2==false)System.out.println("DATOS INCORRECTOS");
                            } while (ver2==false);
                            //tec.next();
                            System.out.println("si desea repetir ingrese un numero diferente de 0");
                            y = tec.nextInt();
                            //opc = tec.nextLine();
                            //ver=opc.equalsIgnoreCase("S");
                        } while (y!=0);
                        break;
                    case 3:
                        break;
                    case 4:
                        Huespedes person = new Huespedes(true, true, 36.00, "Ecuador", "0150496420", "David", "Giler", "Cuenca", "099485720");
                        person.getAtributos();
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
