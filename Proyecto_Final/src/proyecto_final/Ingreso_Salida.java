package proyecto_final;

import java.util.Scanner;

public class Ingreso_Salida extends Huespedes{
    private String date;
    private int costo;
    private int num_room;
    private int bed;

    
    public Ingreso_Salida(String date, int costo, int num_room, int bed, boolean reserva, boolean hospedaje, double temperatura, String pais, String cédula, String nombre, String apellido, String direccion, String telefono) {
        super(reserva, hospedaje, temperatura, pais, cédula, nombre, apellido, direccion, telefono);
        this.date = date;
        this.costo = costo;
        this.num_room = num_room;
        this.bed = bed;
    }
    public void Entrada(){
        Scanner tec = new Scanner(System.in);
        //Ingreso_Salida c = new Ingreso_Salida(); 
        String date;
        boolean ver,conversion;
        int num;
        double num2;
        System.out.println("INGRESE LOS SIGUIENTES DATOS: ");
        do {
            System.out.print("Fecha: "); date = tec.next();
            ver = date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}");
            if(ver==false)System.out.println("Datos incorrectos");
            if(ver==true) this.date=date;   
        } while (ver==false);
        do {
            System.out.print("Costo: "); date = tec.next();
            ver=date.matches("\\d{2,4}");
            if(ver==true){
                num=Integer.parseInt(date);
                this.costo=num;
            }
            if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Habitacion: "); date = tec.next();
            ver = date.matches("[0-9]{1,2}");
            if(ver==false)System.out.println("Error de datos");
             if(ver==true){
                num=Integer.parseInt(date);
                this.num_room=num;
            }
        } while (ver==false);
        do {
            System.out.print("Numero de camas: "); date = tec.next();
            ver=date.matches("[0-5]");
             if(ver==true){
                num=Integer.parseInt(date);
                this.bed=num;
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Tiene reserva ingrese true o false: "); date = tec.next();
            ver=date.matches("true||false");
            if(ver==true){
                conversion = Boolean.parseBoolean(date);
                super.setReserva(ver);
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Hospedaje ingrese true or false: "); date = tec.next();
            ver=date.matches("true||false");
            if(ver==true){
                conversion = Boolean.parseBoolean(date);
                super.setHospedaje(conversion);
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Temperatura: "); date = tec.next();
            ver=date.matches("[0-9]{1,4}[.][0-9]*");
            if(ver==true){
                num2=Double.parseDouble(date);
                super.setTemperatura(num2);
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Pais: "); date = tec.next();
            ver=date.matches("[a-z]{3,15}");
            if(ver==true){
               super.setPais(date);
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Cedula: "); date = tec.next();
            ver=date.matches("[0-2][0-9][0-9]{8}");
            if(ver==true){
               super.cédula=date;
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Nombre: "); date = tec.next();
            ver=date.matches("[a-z]{3,15}");
            if(ver==true){
               super.nombre=date;
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Apellido: "); date = tec.next();
            ver=date.matches("[a-z]{3,15}");
            if(ver==true){
               super.apellido=date;
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("Direccion: "); date = tec.next();
            ver=date.matches("[a-z]{3,20}[0-9]{1,10}");
            if(ver==true){
               super.direccion=date;
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
        do {
            System.out.print("telefono: "); date = tec.next();
            ver=date.matches("[0][9][0-9]{8}");
            if(ver==true){
               super.telefono=date;
            }if(ver==false)System.out.println("Error de datos");
        } while (ver==false);
    }
    //METODO QUE DEVUELVE TODOS LOS ATRIBUTOS DEL CLIENTE EN FORMA DE CADENA
    //ESTE CADENA SE LA PUEDE IMPRIMIR EN UN ARCHIVO
    public String getA(){
        return "fecha: "+this.date+" costo: "+this.costo+super.getA();
    }
    
    public void salir(){
        System.out.println("GRACIAS POR HOSPEDARSE EN EL HOTEL XXXXXXXXX");
        System.out.println("ESPERAMOS QUE VUELVA PRONTO SEÑOR: "+this.nombre+" "+this.apellido);
    }
    
}
