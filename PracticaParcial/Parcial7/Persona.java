package PracticaParcial.Parcial7;

public class Persona {
    private String nombre;
    private boolean jubilado;
    private boolean cobro;
    private String domicilio;

    public Persona(String nombre, boolean jubilado, boolean cobro, String domicilio){
        this.nombre = nombre;
        this.jubilado = jubilado;
        this.cobro = cobro;
        this.domicilio = domicilio;
    }

    public Persona() {
        this.nombre = "";
        this.jubilado = false;
        this.cobro = true;
        this.domicilio = "";
    }

    public String getNombre() {
        return nombre;
    }
    
    public boolean getJubilado() {
        return jubilado;
    }

    public boolean getCobro() {
        return cobro;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }

    public void setCobro(boolean cobro) {
        this.cobro = cobro;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}
