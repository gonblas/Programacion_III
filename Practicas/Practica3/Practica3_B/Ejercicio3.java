package Practicas.Practica3.Practica3_B;

import PrograIII.GenericList.Pila;


public class Ejercicio3 {
    public static void main(String[] args) {
        Pila<Character> p = new Pila<>();

        p.apilar('a');
        p.apilar('b');
        p.apilar('c');
        p.apilar('d');
        p.apilar('e');

        for (int i = 0; i < 6; i++)
            p.desapilar();
        
        System.out.println("El tope de la pila es: " + p.tope());
    }
}
