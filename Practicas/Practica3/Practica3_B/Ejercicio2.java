package Practicas.Practica3.Practica3_B;

import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class Ejercicio2 {
    public static void main(String[] args) {
        ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<>();
        l.agregarFinal("Messi");
        l.agregarFinal("is");
        l.agregarFinal("the");
        l.agregarFinal("GOAT");
        ListaGenericaEnlazada<String> l2 = l.invertir();

        System.out.println(l2.toString());
        System.out.println(l.toString());

    }

}
