package Practicas.Practica3.Practica3_A;
import PrograIII.IntList.ListaDeEnterosEnlazada;

public class Ejercicio3 {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        l.agregarFinal(1);
        l.agregarFinal(3);
        l.agregarFinal(6);

        ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada();
        l2.agregarFinal(2);
        l2.agregarFinal(4);
        l2.agregarFinal(5);

        ListaDeEnterosEnlazada l3 = l2.cambiarOrdenado(l);
        System.out.println(l3.toString());

    }
}