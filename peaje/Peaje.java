package peaje;
import java.util.ArrayList;

public class Peaje {
    private String nombre;
    private String departamento;
    private ArrayList<Boleta> boletas = new ArrayList<Boleta>();

    public Peaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Método para obtener el nombre del peaje
    public String getNombre() {
        return nombre;
    }

    public int verificar_boleta(Boleta b) {
        if (boletas.isEmpty()) {
            return 1;
        } else {
            for (Boleta i : boletas) {
                if (i.getPatente().equals(b.getPatente())) {
                    return -1;
                }
            }
            return 1;
        }
    }

    public int ingresar_boleta(Boleta b) {
        if (verificar_boleta(b) == 1) {
            boletas.add(b);
            System.out.println("Pago registrado correctamente de su " + b.getTipo());
            return 1;
        } else {
            System.out.println("El vehículo con esa patente ya está registrado");
            return 0;
        }
    }

    public void imprimir() {
        if (boletas == null || boletas.size() == 0) {
            System.out.println("No hay boletas registradas.");
        } else {
            System.out.println("Lista de boletas:");
            System.out.println(boletas.toString());
        }
    }

    public ArrayList<Boleta> getBoletas() {
        return boletas;
    }
}
