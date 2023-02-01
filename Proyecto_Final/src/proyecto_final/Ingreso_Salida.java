package proyecto_final;

import java.util.Calendar;

public class Ingreso_Salida {

    protected String date;
    protected int costo;
    protected int num_room;
    protected int bed;
    protected String hora_entrada;
    protected String hora_salida;
    public String patroncedula="[0-9]{10}";
    protected Calendar calendario = Calendar.getInstance();

    Ingreso_Salida(String hora_entrada, String hora_salida) {
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }

    public Ingreso_Salida(String date, int costo, int num_room, int bed) {
        this.date = date;
        this.costo = costo;
        this.num_room = num_room;
        this.bed = bed;
    }
}
