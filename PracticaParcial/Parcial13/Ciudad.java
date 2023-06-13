package PracticaParcial.Parcial13;

public class Ciudad {
    private String nombre;
    private int fase;

    public Ciudad(String nombre, int fase) {
        this.nombre = nombre;
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFase() {
        return fase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

}
