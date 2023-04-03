package Pruebas.Listas;

public class Persona {
    private String name;
    private int edad;
    private long DNI;

    public Persona(String name, int edad, long DNI) {
        this.name = name;
        this.edad = edad;
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public long getDNI() {
        return DNI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }
}
