package proyecto_final;

import java.util.Scanner;

public class Menu_Hostal {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        //Atributos
        int op;
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
                Huespedes person=new Huespedes(true,true,36.00,"Ecuador","0150496420","David","Giler","Cuenca","099485720");
                person.getAtributos();
                break;
            case 5:
                break;
        }

    }
}
