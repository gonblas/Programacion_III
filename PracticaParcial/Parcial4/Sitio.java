package PracticaParcial.Parcial4;

public class Sitio {
    private String nombre;
    private boolean mafia;


    public Sitio(String nombre, boolean mafia) {
        this.nombre = nombre;
        this.mafia = mafia;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getMafia() {
        return mafia;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setMafia(boolean mafia){
        this.mafia = mafia;
    }

}
