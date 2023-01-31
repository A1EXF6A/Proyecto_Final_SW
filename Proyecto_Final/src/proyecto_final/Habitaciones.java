package proyecto_final;

class Habitaciones extends Huespedes{
    int numero_habitacion;

    public Habitaciones(int numero_habitacion, String date, int costo, int num_room, int bed, boolean reserva, boolean hospedaje, double temperatura, String pais, String cédula, String nombre, String apellido, String direccion, String telefono, String hora_entrada, String hora_salida) {
        super(date, costo, num_room, bed, reserva, hospedaje, temperatura, pais, cédula, nombre, apellido, direccion, telefono, hora_entrada, hora_salida);
        this.numero_habitacion = numero_habitacion;
    }
    


    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public boolean[] getEstadoCama() {
        return estadoCama;
    }

    public void setEstadoCama(boolean[] estadoCama) {
        this.estadoCama = estadoCama;
    }

    public int camasDisponibles() {
        int contador = 0;
        for (int i = 0; i < camas; i++) {
            if (!estadoCama[i]) {
                System.out.printf("cama %d esta disponible: %s\n",i+1,estadoCama[i]);
                contador++;
            }
        }
        return contador;
    }

   

    public void liberarCama(int numCama) {
        if (numCama >= 0 && numCama < camas) {
            estadoCama[numCama] = false;
        }
    }
}
