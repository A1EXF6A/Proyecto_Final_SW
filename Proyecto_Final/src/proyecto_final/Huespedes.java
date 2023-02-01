package proyecto_final;

import java.util.Calendar;
import java.util.Scanner;

public class Huespedes extends Persona {

    public Huespedes(boolean[] estadoCama, String cédula, String nombre, String apellido, String direccion, String telefono, String hora_entrada, String hora_salida) {
        super(cédula, nombre, apellido, direccion, telefono, hora_entrada, hora_salida);
        this.estadoCama = estadoCama;
    }

    Scanner teclado = new Scanner(System.in);
    //Atributos de la clase Huespedes
    protected boolean reserva = false;
    protected boolean hospedaje = false;
    protected double temperatura = 0.0;
    protected String pais = "";
    protected boolean[] estadoCama;
    protected int camas, hora, minutos, segundos;

    public Huespedes(String date, int costo, int num_room, int bed, boolean reserva, boolean hospedaje, double temperatura, String pais, String cédula, String nombre, String apellido, String direccion, String telefono, String hora_entrada, String hora_salida) {
        super(cédula, nombre, apellido, direccion, telefono, hora_entrada, hora_salida);
        this.reserva = reserva;
        this.hospedaje = hospedaje;
        this.temperatura = temperatura;
        this.pais = pais;

    }

    public int camasDisponibles() {
        int contador = 0;
        for (int i = 0; i < camas; i++) {
            if (!estadoCama[i]) {
                System.out.printf("cama %d esta disponible: %s\n", i + 1, estadoCama[i]);
                contador++;
            }
        }
        return contador;
    }

    public void reservarCama() {
        int opcion_cama, control_cama = 0;
        do {
            System.out.println("Ingrese la cama que desea reservar");
            opcion_cama = Integer.valueOf(teclado.next());
            if (!estadoCama[opcion_cama - 1]) {
                estadoCama[opcion_cama - 1] = true;
                control_cama = 1;
            } else {
                System.out.println("cama no disponible");
                System.out.println("Reserve una cama dosponible");
            }
        } while (control_cama != 1);
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public void setHospedaje(boolean hospedaje) {
        this.hospedaje = hospedaje;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    //Constructor
    public Huespedes(boolean reserva, boolean hospedaje, double temperatura, String pais, String cédula, String nombre, String apellido, String direccion, String telefono, String hora_entrada, String hora_salida) {
        super(cédula, nombre, apellido, direccion, telefono, hora_entrada, hora_salida);
        this.reserva = reserva;
        this.hospedaje = hospedaje;
        this.temperatura = temperatura;
        this.pais = pais;
    }

    public void HacerReserva() {

        String opcion = null;
        do {
            try {
                System.out.println("Desea hacer una reserva: ");
                opcion = teclado.next();
                if (opcion.equalsIgnoreCase("Si")) {
                    this.reserva = true;
                } else if (opcion.equalsIgnoreCase("no")) {
                    this.reserva = false;
                } else {
                    System.out.println("Ingrese unicamente si o no");
                }
            } catch (Exception e) {
                System.out.println("error");

            }
        } while (!opcion.equalsIgnoreCase("no") && !opcion.equalsIgnoreCase("si"));
    }

    public void CancelarReserva() {
        this.reserva = false;
    }

    public void Hospedaje() {

        String opcion = null;
        do {
            try {
                System.out.println("Desea hospedarse: ");
                opcion = teclado.next();
                if (opcion.equalsIgnoreCase("Si")) {
                    this.hospedaje = true;
                    hora = calendario.get(Calendar.HOUR_OF_DAY);
                    minutos = calendario.get(Calendar.MINUTE);
                    segundos = calendario.get(Calendar.SECOND);
                    System.out.println("Hora de ingreso: " + hora + ":" + minutos + ":" + segundos);
                    super.hora_entrada = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);
                } else if (opcion.equalsIgnoreCase("no")) {
                    this.hospedaje = false;
                } else {
                    System.out.println("Ingrese unicamente si o no");
                }
            } catch (Exception e) {
                System.out.println("error");

            }
        } while (!opcion.equalsIgnoreCase("no") && !opcion.equalsIgnoreCase("si"));
    }
    //Mostrar datos

    public void Salida() {
        int a = 0;
        String cedula_salida;
        do {
            System.out.println("Ingrese su numero de cedula");
            cedula_salida = teclado.next();
            if (cedula_salida.matches(patroncedula)) {
                a = 1;
            } else {
                System.out.println("Ingrese una cedula valida");
            }
        } while (a != 1);
        //poner busqueda en archivos
        this.hospedaje = false;
    }

    public void getAtributos() {
        System.out.println("NOMBRE: " + super.nombre);
        System.out.println("APELLIDO: " + super.apellido);
        System.out.println("CÉDULA: " + super.cédula);
        System.out.println("DIRECCIÓN: " + super.direccion);
        System.out.println("TÉLEFONO: " + super.telefono);
        if (this.reserva = false) {
            System.out.println("RESERVACIÓN: " + "NO TIENE RESERVACIÓN");
        } else {
            System.out.println("RESERVACIÓN: " + "SI TIENE RESERVACION");
        }
        if (this.hospedaje = false) {
            System.out.println("HOSPEDAJE: " + "NO SE ENCUENTRA HOSPEDADO");
        } else {
            System.out.println("HOSPEDAJE: " + "SE ENCUENTRA ACTUALMENTE HOSPEDADO");
        }
        System.out.println("TEMPERATURA: " + this.temperatura);
        System.out.println("PAIS DE DONDE VIENE: " + this.pais);
        System.out.println("HORA DE ENTRADA : " + super.hora_entrada);
        System.out.println("");

    }

    //metodo que devuelve los aributos en forma de cadena
    public void Entrada() {
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Scanner teclado = new Scanner(System.in);
        //Ingreso_Salida c = new Ingreso_Salida(); 
        String fecha;
        boolean verificar, conversion;
        int num;
        double num2;
        System.out.println("INGRESE LOS SIGUIENTES DATOS: ");
        //fecha
        do {
            System.out.print("Fecha: ");
            fecha = teclado.next();
            verificar = fecha.matches("[0-3][0-9]/[0-9][0-9]/[0-9]{2}");
            if (verificar == false) {
                System.out.println("Datos incorrectos");
            }
            if (verificar == true) {
                this.date = fecha;
            }
        } while (verificar == false);
        //costos
        int cantidad_camas, costo_cama = 0, opcion_camas = 0;
        do {

            try {

                System.out.println("Elija una de las siguientes opciones para su hospedaje");
                System.out.println("1.-50$ por cama");
                System.out.println("2.-100$ por cama");
                opcion_camas = Integer.valueOf(teclado.next());
                if (opcion_camas != 1 && opcion_camas != 2) {
                    System.out.println("Ingrese unicamente un valor como 1 o 2");
                }

            } catch (NumberFormatException e) {
                System.out.println("Ingrese unicamente numeros");
            }

        } while (opcion_camas != 1 && opcion_camas != 2);

        if (opcion_camas == 1) {
            costo_cama = 50;
        }
        if (opcion_camas == 2) {
            costo_cama = 100;
        }

        do {
            try {
                System.out.println("Ingrese el numero de camas que desea maximo 5");
                this.camas = Integer.valueOf(teclado.next());
                if (this.camas < 0) {
                    System.out.println("Numero fuera de rango");
                } else if (this.camas > 6) {
                    System.out.println("Numero fuera de rango");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese unicamente numeros");
            }
        } while (this.camas < 0 || this.camas > 6);

        System.out.printf("Hay %d camas disponibles\n", camasDisponibles());
        reservarCama();

        super.costo = (this.camas * costo_cama);
        //asignamiento habitacion - archivos
        do {
            System.out.print("Habitacion: ");
            fecha = teclado.next();
            verificar = fecha.matches("[0-9]{1,2}");
            if (verificar == false) {
                System.out.println("Error de datos");
            }
            if (verificar == true) {
                num = Integer.parseInt(fecha);
                this.num_room = num;
            }
        } while (verificar == false);
        //camas asignadas - archivos
        do {
            System.out.printf("Numero de camas: %d\n", this.camas);
            fecha = teclado.next();
            verificar = fecha.matches("[0-5]");
            if (verificar == true) {
                num = Integer.parseInt(fecha);
                this.bed = num;
            }
            if (verificar == false) {
                System.out.println("Error de datos");
            }
        } while (verificar == false);
        //comprobacion de reserva
//        do {
//            System.out.print("Tiene reserva ingrese true o false: ");
//            fecha = teclado.next();
//            verificar = fecha.matches("true||false");
//            if (verificar == true) {
//                conversion = Boolean.parseBoolean(fecha);
//                super.setReserva(verificar);
//            }
//            if (verificar == false) {
//                System.out.println("Error de datos");
//            }
//        } while (verificar == false);
//        //confirmacion de hospedaje
//        do {
//            System.out.print("Confirmacion de hospedaje: ");
//            fecha = teclado.next();
//            verificar = fecha.matches("true||false");
//            if (verificar == true) {
//                conversion = Boolean.parseBoolean(fecha);
//                super.setHospedaje(conversion);
//            }
//            if (verificar == false) {
//                System.out.println("Error de datos");
//            }
//        } while (verificar == false);
        //temperatura
        int control_temperatura = 0;
        do {
            try {
                System.out.print("Ingrese su temperatura: ");
                this.temperatura = Double.valueOf(teclado.next());
                if (this.temperatura < 34) {
                    System.out.println("Usted no puede hacer una reserva");
                    break;
                } else if (this.temperatura > 38) {
                    System.out.println("Usted no puede hacer una reserva");
                    break;
                } else {
                    control_temperatura = 1;
                    System.out.println("Temperatura normal");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese unicamente numeros");
            }
        } while (control_temperatura != 1);
        //pais origen
        int control_pais = 0;
        String formato_pais = "[a-zA-Z]";
        do {
            try {
                System.out.println("Ingrese el pais de procedencia");
                this.pais = teclado.next();
                if (this.pais.matches(formato_pais)) {
                    control_pais = 1;
                }
            } catch (Exception e) {
                System.out.println("Ingrese unicamente letras");
            }
        } while (control_pais != 1);
        //cedula
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

        //nombre
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
        //apellido
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
        //direccion
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
        //telefono
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
    }
}
