package PracticaParcial.Parcial11;

public class Ciudad {
    private String nombre;
    private int maxDias;

    public Ciudad(String nombre, int maxDias) {
        this.nombre = nombre;
        this.maxDias = maxDias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaxDias() {
        return maxDias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaxDias(int maxDias) {
        this.maxDias = maxDias;
    }
}
