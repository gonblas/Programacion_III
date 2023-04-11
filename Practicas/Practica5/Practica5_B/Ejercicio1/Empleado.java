package Practicas.Practica5.Practica5_B.Ejercicio1;

public class Empleado {
    private String nombre;
    private int antiguedad;
    private int categoria;

    public Empleado(String nombre, int antiguedad, int categoria) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.categoria = categoria;
    }

    public Empleado() {

    }

    public String getNombre() {
        return this.nombre;
    }

    public int getAntiguedad() {
        return this.antiguedad;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return " " + this.nombre + " " + this.antiguedad + " " + this.categoria + "   ";
    }
}
