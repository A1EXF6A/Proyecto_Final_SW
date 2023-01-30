package proyecto_final;


public class Reservas extends Habitaciones {
    int dia,mes,año;
    String estado_de_reserva;
    
    public Reservas(int dia,int mes, int año,String estado_de_reserva, int numero, int camas){
        super(numero,camas);
        this.dia= dia;
        this.mes= mes;
        this.año= año;
        this.numero = numero;
        this.camas = camas;
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

