package Practicas.Practica3.Practica3_A;
import PrograIII.ListInt.ListaDeEnterosEnlazada;

public class Ejercicio2 {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        l.agregarFinal(12);
        l.agregarFinal(2);
        l.agregarFinal(3);
        l.agregarFinal(309);
        ListaDeEnterosEnlazada l2 = l.ordenar();

        System.out.println(l2.toString());
    }
    
}
