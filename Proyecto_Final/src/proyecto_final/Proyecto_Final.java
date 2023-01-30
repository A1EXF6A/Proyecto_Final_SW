/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class Proyecto_Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        String option="";
        boolean opc;
        int opc6=0;
        
        Ingreso_Salida gg = new Ingreso_Salida("", opc6, opc6, opc6, true, true, opc6, "", "", option, option, option, option);
        gg.Entrada();
        System.out.println(gg.getA());
        gg.salir();
        
        do {
            do {
              System.out.println("Escoja una opcion");
              System.out.println("1 opcion");
              System.out.println("2 opcion");
              System.out.println("3 opcion");
              System.out.println("4 opcion");
              System.out.println("Ingrese una opcion");
              try{
                opc6 = Integer.valueOf(tec.next());
              }catch(NumberFormatException e){
                  limp();
            System.out.println("\033[41mERROR DE DATOS");
        }
              
        } while (opc6<1||opc6>5);
            switch (opc6) {
            case 1:
               do{            
            
            linea();
            System.out.printf("\n\033[41mDEESA REPETIR LA OPCION 1 S/N: ");
            option = tec.nextLine();
            opc=verf(option);
            limp();
        }while(opc==false);
                
                System.out.println("\033[41mSALIO DE LA OPCION 1");
                break;
            case 2:
               do{            
            
            linea();
            System.out.printf("\n\033[45mDEESA REPETIR LA OPCION 2 S/N: ");
            option = tec.nextLine();
            opc=verf(option);
            limp();
        }while(opc==false);
                System.out.println("\033[45mSALIO DE LA OPCION 2");
               
                break;
            case 3:
                do{            
            
            linea();
            System.out.printf("\n\033[44mDEESA REPETIR LA OPCION 3 S/N: ");
            option = tec.nextLine();
            opc=verf(option);
            limp();
        }while(opc==false);
                System.out.println("\033[44mSALIO DE LA OPCION 3");
                break;
            case 4:
                do{            
            
            linea();
            System.out.printf("\n\033[44mDEESA REPETIR LA OPCION 4 S/N: ");
            option = tec.nextLine();
            opc=verf(option);
            limp();
        }while(opc==false);
                System.out.println("\033[44mSALIO DE LA OPCION 4");
                break;
            case 5:
                limp();
                System.out.println("\033[41mFin del programa"); 
                System.exit(0);
                break;
        }
        } while (opc6!=5);
    }
    public static boolean verf(String opci){
        boolean ver = opci.matches("[sSnN]{1}");
        if (ver==true) {
                if(opci.equalsIgnoreCase("n")){
                    ver=true;
                }else{
                    ver=false;
                }    
            }else{
                System.out.println("\033[41mDATOS INCORRECTOS INGRESE S/N");
                ver=false;
            }
        return ver;
    }
    public static void limp(){
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }}
        public static void linea(){
        for (int i = 0; i < 198; i++) {
            System.out.printf("-");
        }
    }
    
}
