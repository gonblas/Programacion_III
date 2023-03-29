package Practicas.Practica3.Practica3_B;
import PrograIII.ListGeneric.Cola;

public class Ejercicio5 {
    public static void main(String[] args) {
        Cola<String> c = new Cola<String>();

        c.encolar("Messi");
        c.encolar("is");
        c.encolar("the");
        c.encolar("GOAT");

        while(!c.esVacia()){
            System.out.println(c.desencolar());
        }
    }
}
