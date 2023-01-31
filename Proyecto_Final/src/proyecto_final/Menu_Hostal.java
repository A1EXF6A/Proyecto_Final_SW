package proyecto_final;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu_Hostal {
    ArrayList<Personal_Servicios> ListaPersonal;

    public static void main(String[] args) throws IOException {
        int contador_archivos;
        String nombre_archivoempleados="empleados.txt",nombre_archivohuespedes="huespedes.txt";
        File empleados = new File(nombre_archivoempleados);
        File huespedes = new File(nombre_archivohuespedes);
        FileWriter fwempleados = new FileWriter(empleados,true); //TRUE PARA QUE NO SE SOBREESCRIBA EL ARCHIVO
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
            System.out.println("[1] Ingreso de datos del personal de servicios");
            System.out.println("[2] Ingreso-Salida de huespedes");
            System.out.println("[3] Datos de empleados y huespedes");
            System.out.println("[4] Datos Generales");
            System.out.println("[5] Salir");
            try {
                op = Integer.valueOf(teclado.next());

                switch (op) {
                    case 1:
                        Personal_Servicios empleado = new Personal_Servicios("", "", "", "", "", "", "", "");
                        empleado.IngresarDatos();
                        
                        Guardar_empleados.printf("%s,%s,%s,%s,%s,%s,%s,%s %n",empleado.cargo,empleado.cédula,empleado.nombre,empleado.apellido,
                                empleado.direccion,empleado.telefono,empleado.hora_entrada,empleado.hora_salida);
                        ListaPersonal.add(new Personal_Servicios(empleado.cargo,empleado.cédula,empleado.nombre,empleado.apellido,
                                empleado.direccion,empleado.telefono,empleado.hora_entrada,empleado.hora_salida));
                        Guardar_empleados.close();
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
                                    if (op2.equalsIgnoreCase("Si")) {
                                        huesped.Entrada();
                                        ArrayList<Huespedes> ListaHuespedes=new ArrayList();
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
                            /*for (int i = 0; i < ListaPersonal.size(); i++) {
                           
                           System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", "CARGO", "CEDULA", "NOMBRE", "APELLIDO",
                                   "DIRECCION", "TELEFONO", "HORA DE ENTRADA", "HORA DE SALIDA");
                            System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", ListaPersonal.get(i).cargo,
                                    ListaPersonal.get(i).cédula, ListaPersonal.get(i).nombre, ListaPersonal.get(i).apellido,
                                    ListaPersonal.get(i).direccion, ListaPersonal.get(i).telefono, ListaPersonal.get(i).hora_entrada, ListaPersonal.get(i).hora_salida);
                        }*/
                        
                        //PARA LEER LOS DATOS DESDE LOS ARCHIVOS QUE SE CREAN EN LAS OPCIONES 1 Y 2
                        String ingreso_cedula = null,repetir=null; boolean verificar =false; int cont = 0;String linea;
                        //File arc = new File("C:\\Users\\HOME\\OneDrive - UNIVERSIDAD TÉCNICA DE AMBATO\\Escritorio\\Proyecto_Final\\Proyecto_Final_SW\\Proyecto_Final\\huespedes.txt");
                        do {
                                do {
                            try {
                                System.out.print("Cedula: "); //pide la cedula para buscar en los archivos
                                ingreso_cedula = teclado.next();
                                verificar = ingreso_cedula.matches("[0-9]{10}");
                                if (verificar == false) {
                                    System.out.println("ingrese una cedula valida");  
                                }
                                if(verificar==true){
                                    //lee el archivo
                                    leer_huespedes(huespedes, ingreso_cedula);
                                    leer_empleados(empleados, ingreso_cedula);
                                    
                                    
                                }
                            } catch (Exception e) {
                                System.out.println("Ingrese unicamente numeros");
                            }
                        } while (verificar == false);
                                System.out.println("Desea nuscar otra persona ingrese S");
                                repetir=teclado.next();         
                        } while (repetir.equalsIgnoreCase("S")==true);
                        
                        
                        break;
                            
                        
                    case 4:
                        System.out.println("Los datos contenidos que posee el hotel son");
                        System.out.println("\033[44mDatos de los empleados");
                        leer(empleados);
                        System.out.println("\033[44mDatos de los huespedes");
                        leer(huespedes);
                        datosGenerales(empleados, huespedes);
                        
                        
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
    //metodo que lee los archivos
    public static void leer(File arc){
        try {
            Scanner archivo = new Scanner(arc);
            String linea;
            while(archivo.hasNext()){
                linea = archivo.nextLine();
                System.out.println(linea);
                
            }  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_Hostal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void leer_huespedes(File arc,String ingreso_cedula){
        try {
            Scanner archivo = new Scanner(arc);
            String linea; int cont = 0;
            while(archivo.hasNext()){
                   linea = archivo.nextLine(); //se asigna una linea a un string
                   if(linea.contains(ingreso_cedula)){ //se verifica si la linea contiene la cedula
                   System.out.println(linea);     //imprime los datos del objeto
                   }else if(linea.contains(ingreso_cedula)==false){ //para ver si existe la cedula 0 si existe y + de  cero si no existe
                   cont++;
                   }}
            //if(cont>0)System.out.println("NO EXISTE EN REGISTRO De huespedes");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_Hostal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void leer_empleados(File arc,String ingreso_cedula){
        try {
            Scanner archivo = new Scanner(arc);
            String linea; int cont = 0;
            while(archivo.hasNext()){
                   linea = archivo.nextLine(); //se asigna una linea a un string
                   if(linea.contains(ingreso_cedula)){ //se verifica si la linea contiene la cedula
                   System.out.println(linea);     //imprime los datos del objeto
                   }else if(linea.contains(ingreso_cedula)==false){ //para ver si existe la cedula 0 si existe y + de  cero si no existe
                   cont++;
                   }}
            //if(cont>0)System.out.println("NO EXISTE EN REGISTRO de los empleados");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_Hostal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void datosGenerales(File acr1,File acr2){
        try {
            FileWriter datos = new FileWriter("C:\\Users\\HOME\\OneDrive - UNIVERSIDAD TÉCNICA DE AMBATO\\1 semestre-repeticion\\LECTRURA\\lectura2.txt",true);
            
            Scanner ar = new Scanner(acr1); Scanner ar2 = new Scanner(acr1); String line = "";
            datos.write("DATOS EMPLEADOS: \n");
            while(ar.hasNext()){
                line = ar.nextLine();
                datos.write(line+"\n");
            }
            datos.write("DATOS HUESPEDES: \n");
            while(ar2.hasNext()){
                line = ar2.nextLine();
                datos.write(line+"\n");
            }
            
            datos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Menu_Hostal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
