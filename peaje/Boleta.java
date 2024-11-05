package peaje;

public class Boleta {
    private String tipo;
    private int total;
    private String patente;
    private Peaje peaje; // Nuevo atributo para el peaje

    public Boleta(String tipo, int total, String patente, Peaje peaje) {
        this.tipo = tipo;
        this.total = total;
        this.patente = patente;
        this.peaje = peaje; // Inicialización del peaje
    }

    public String getTipo() {
        return tipo;
    }

    public int getTotal() {
        return total;
    }

    public String getPatente() {
        return patente;
    }

    public Peaje getPeaje() {
        return peaje;
    }
}
