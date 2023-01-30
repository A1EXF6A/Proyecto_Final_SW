package proyecto_final;

class Habitaciones extends Huespedes{
    int numero;
    protected int camas;
    protected boolean[] estadoCama;

    public Habitaciones(int numero, int camas) {
        this.numero = numero;
        this.camas = camas;
        this.estadoCama = new boolean[camas];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
                contador++;
            }
        }
        return contador;
    }

    public int reservarCama() {
        for (int i = 0; i < camas; i++) {
            if (!estadoCama[i]) {
                estadoCama[i] = true;
                return i;
            }
        }
        return -1;
    }

    public void liberarCama(int numCama) {
        if (numCama >= 0 && numCama < camas) {
            estadoCama[numCama] = false;
        }
    }
}
