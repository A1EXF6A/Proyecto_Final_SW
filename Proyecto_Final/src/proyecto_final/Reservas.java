package proyecto_final;


public class Reservas extends Habitaciones {
    int dia,mes,año;
    String estado_de_reserva;

    public Reservas(int dia, int mes, int año, String estado_de_reserva, int numero_habitacion, String date, int costo, int num_room, int bed, boolean reserva, boolean hospedaje, double temperatura, String pais, String cédula, String nombre, String apellido, String direccion, String telefono, String hora_entrada, String hora_salida) {
        super(numero_habitacion, date, costo, num_room, bed, reserva, hospedaje, temperatura, pais, cédula, nombre, apellido, direccion, telefono, hora_entrada, hora_salida);
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.estado_de_reserva = estado_de_reserva;
    }
    
    
    
     public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getEstadoreserva() {
        return estado_de_reserva;
    }

    public void setEstadoreserva(String estado_de_reserva) {
        this.estado_de_reserva = estado_de_reserva;
    }
   
}

