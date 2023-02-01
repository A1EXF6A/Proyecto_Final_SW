package proyecto_final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu_Hostal {
    ArrayList<Personal_Servicios> ListaPersonal;

    public static void main(String[] args) throws IOException {
        int contador_archivos;
        int hora,minutos,segundos;
        String horain;
        Calendar calendario = Calendar.getInstance();
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
            System.out.println("[5] Salida de empleados");
            System.out.println("[6] Salir");
            try {
                op = Integer.valueOf(teclado.next());

                switch (op) {
                    case 1:
                        Personal_Servicios empleado = new Personal_Servicios("", "", "", "", "", "", "", "");
                        empleado.IngresarDatos();
                        hora = calendario.get(Calendar.HOUR_OF_DAY);
                        minutos = calendario.get(Calendar.MINUTE);
                        segundos = calendario.get(Calendar.SECOND);
                        empleado.hora_entrada = Integer.toString(hora)+":"+Integer.toString(minutos)+":"+Integer.toString(segundos);
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
                        leer_empleados_vit(empleados);
                        System.out.println("\033[44mDatos de los huespedes");
                        leer(huespedes);
                        datosGenerales(empleados, huespedes);
                        
                        
                        
                        break;
                        
                    case 5:
                        salida_hora(empleados);
                        break;
                        
                    case 6:
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
            FileWriter datos = new FileWriter("lectura2.txt",true);
            
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
      public static void salida_hora(File arc) throws IOException{
        String nombre_archivoempleados="empleados.txt",nombre_archivohuespedes="huespedes.txt";
        File empleados = new File(nombre_archivoempleados);
        FileWriter fwempleados = new FileWriter(empleados,true); //TRUE PARA QUE NO SE SOBREESCRIBA EL ARCHIVO
        PrintWriter Guardar_empleados = new PrintWriter(fwempleados);
         Calendar calendario = Calendar.getInstance();
         
           int hora,minutos,segundos;
           boolean control = false;
           String hora_salida = null;
           int cantidad_lineas = 0;
           Scanner teclado = new Scanner(System.in) ;
           String ingreso_cedula = null;
           System.out.println("Ingrese su cedula");
           ingreso_cedula= teclado.next();
           String linea_remplazo = null;
            Scanner archivo = new Scanner(arc);
            int numero_linea=0;
            ArrayList<String> lineas = new ArrayList<>();
//            while(archivo.hasNext()){
//            contador_limite++;
//            }
          //  String acumulador[] = new String[contador_limite];
            String linea_hora_salida[] = null;
            String linea;
int cont = 0;
while(archivo.hasNext()){
    if (cont<7) {
        cont=0;
    }
    linea = archivo.nextLine(); //se asigna una linea a un string
    if(linea.contains(ingreso_cedula)){ //se verifica si la linea contiene la cedula
        numero_linea=cantidad_lineas;
        linea_hora_salida= linea.split(",");
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        hora_salida = Integer.toString(hora)+":"+Integer.toString(minutos)+":"+Integer.toString(segundos);
//        Guardar_empleados.printf("%s,%s,%s,%s,%s,%s,%s,%s %n", linea_hora_salida[0],linea_hora_salida[1],linea_hora_salida[2],
//                linea_hora_salida[3],linea_hora_salida[4],linea_hora_salida[5],linea_hora_salida[6],hora_salida);
//        Guardar_empleados.close();   
         linea_remplazo=linea_hora_salida[0]+","+linea_hora_salida[1]+","+linea_hora_salida[2]+","+
                linea_hora_salida[3]+","+linea_hora_salida[4]+","+linea_hora_salida[5]+","+linea_hora_salida[6]+","+hora_salida;
        //imprime los datos del objeto
    }else if(linea.contains(ingreso_cedula)==false){ //para ver si existe la cedula 0 si existe y + de  cero si no existe
        cont++;
    }
    lineas.add(linea);
    cantidad_lineas++;}
    lineas.set(numero_linea, linea_remplazo);
//    BufferedWriter bw = new BufferedWriter(new FileWriter(arc));
//    bw.write("");
//    bw.close();
    File archivobor = new File("C:\\Users\\pc\\Documents\\GitHub\\Proyecto_Final_SW\\Proyecto_Final\\empleados.txt");
    
//    if (archivobor.delete()) {
//              System.out.println("se borro el fichero");
//              archivobor.createNewFile();
//               for (int i = 0; i < lineas.size(); i++) {
//              Guardar_empleados.println(lineas.get(i));   
//          }
//          Guardar_empleados.close();
//          }
//          else{
//          
//              System.out.println(" nose pudo ingresar la salida ");}
          if (arc.delete()) {
              System.out.println("se borro el fichero");
              arc.createNewFile();
               for (int i = 0; i < lineas.size(); i++) {
              Guardar_empleados.println(lineas.get(i));   
          }
          Guardar_empleados.close();
          }
          else{
          
              System.out.println(" nose pudo ingresar la salida ");}
// for (int i = 0; i < lineas.size(); i++) {
//              Guardar_empleados.println(lineas.get(i));  }
//  Guardar_empleados.close();
         
//if(cont>0)System.out.println("NO EXISTE EN REGISTRO de los empleados");
       System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n",linea_hora_salida[0],linea_hora_salida[1],linea_hora_salida[2],
                           linea_hora_salida[3],linea_hora_salida[4],linea_hora_salida[5],linea_hora_salida[6],hora_salida);
    }
        public static void leer_empleados_vit(File arc){
        try {
            ArrayList<Personal_Servicios>lectura_empleados = new ArrayList<>();
            Scanner archivo = new Scanner(arc);
            String linea[];
            while(archivo.hasNext()){
                linea = archivo.nextLine().split(",");
                lectura_empleados.add(new Personal_Servicios(linea[0],linea[1],linea[2],linea[3],linea[4],linea[5],linea[6],linea[7]));
  
            }
            System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", "CARGO", "CEDULA", "NOMBRE", "APELLIDO",
                                   "DIRECCION", "TELEFONO", "HORA DE ENTRADA", "HORA DE SALIDA");
            for (int i = 0; i < lectura_empleados.size(); i++) {
                     System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", lectura_empleados.get(i).cargo,
                                    lectura_empleados.get(i).cédula, lectura_empleados.get(i).nombre, lectura_empleados.get(i).apellido,
                                    lectura_empleados.get(i).direccion, lectura_empleados.get(i).telefono, lectura_empleados.get(i).hora_entrada, lectura_empleados.get(i).hora_salida);
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_Hostal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void leer_huespedes_vit(File arc){
//        try {
//            ArrayList<Huespedes>lectura_huespedess = new ArrayList<>();
//            Scanner archivo = new Scanner(arc);
//            String linea[];
//            while(archivo.hasNext()){
//                linea = archivo.nextLine().split(",");
//                lectura_huespedes.add(new Huespedes(Integer.valueOf(linea[0]),linea[1],linea[2],linea[3],linea[4],linea[5],linea[6],linea[7],linea[8],linea[9],linea[10]));
//                System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n","TEMPERATURA",
//                                   "PAIS", "CEDULA", "NOMBRE", "APELLIDO","DIRECCION","TELEFONO","HORA DE ENTRADA","HORA DE SALIDA");
//                for (int i = 0; i < lectura_empleados.size(); i++) {
//                     System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n", lectura_empleados.get(i).cargo,
//                                    lectura_empleados.get(i).cédula, lectura_empleados.get(i).nombre, lectura_empleados.get(i).apellido,
//                                    lectura_empleados.get(i).direccion, lectura_empleados.get(i).telefono, lectura_empleados.get(i).hora_entrada, lectura_empleados.get(i).hora_salida);
//                }
//                           
//                
//            }  
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Menu_Hostal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//        public static void salida_hora(File arc) throws IOException{
////        String nombre_archivoempleados="empleados.txt";
////        File empleados = new File(nombre_archivoempleados);
//        FileWriter mod = new FileWriter(arc,true); //TRUE PARA QUE NO SE SOBREESCRIBA EL ARCHIVO
//    //    PrintWriter mod = new PrintWriter(arc);
//         Calendar calendario = Calendar.getInstance();
//         
//           int hora,minutos,segundos,referencia_linea = 0;
//           String hora_salida = null;
//           int cont = 0,contadorgeneral=0;
//           Scanner teclado = new Scanner(System.in) ;
//           String ingreso_cedula = null;
//           System.out.println("Ingrese su cedula");
//           ingreso_cedula= teclado.next();
//           String linea_remplazo = null;
//            Scanner archivo = new Scanner(arc);
//            int contador_limite=0;
//            while(archivo.hasNext()){
//            contador_limite++;
//            }
//            String acumulador[] = new String[contador_limite];
//            while(archivo.hasNext()){   
//            acumulador[contadorgeneral]=archivo.nextLine();
//            contadorgeneral++;
//            }
//            String linea_hora_salida[] = new String[8];
//            String linea;
//            int contador_remplazo=0;
//while(archivo.hasNext()){
//    linea = archivo.nextLine(); //se asigna una linea a un string
//    if(linea.contains(ingreso_cedula)){ //se verifica si la linea contiene la cedula
//        
//        linea_hora_salida= linea.split(",");
//        
//        hora = calendario.get(Calendar.HOUR_OF_DAY);
//        minutos = calendario.get(Calendar.MINUTE);
//        segundos = calendario.get(Calendar.SECOND);
//        hora_salida = Integer.toString(hora)+":"+Integer.toString(minutos)+":"+Integer.toString(segundos);
////        Guardar_empleados.printf("%s,%s,%s,%s,%s,%s,%s,%s %n", linea_hora_salida[0],linea_hora_salida[1],linea_hora_salida[2],
////                linea_hora_salida[3],linea_hora_salida[4],linea_hora_salida[5],linea_hora_salida[6],hora_salida);
////        Guardar_empleados.close();  
//
//
//        referencia_linea=contador_remplazo;
//         linea_remplazo=linea_hora_salida[0]+","+linea_hora_salida[1]+","+linea_hora_salida[2]+","+
//                linea_hora_salida[3]+","+linea_hora_salida[4]+","+linea_hora_salida[5]+","+linea_hora_salida[6]+","+hora_salida;
//         acumulador[referencia_linea]=linea_remplazo;
//            arc.delete();
//              arc.createNewFile();
//
//              
//              for (int i = 0; i < contador_limite; i++) {
//                  System.out.println(acumulador[i]);
//                  mod.write(acumulador[i]);
//                  mod.flush();
//              }
//              mod.close();
//        //imprime los datos del objeto
//    }else if(linea.contains(ingreso_cedula)==false){ //para ver si existe la cedula 0 si existe y + de  cero si no existe
//        cont++;
//            }
//    contador_remplazo++;
//    }
//    
////if(cont>0)System.out.println("NO EXISTE EN REGISTRO de los empleados");
//       System.out.printf("|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|%-17s|\n",linea_hora_salida[0],linea_hora_salida[1],linea_hora_salida[2],
//                           linea_hora_salida[3],linea_hora_salida[4],linea_hora_salida[5],linea_hora_salida[6],hora_salida);
//    }
}
