package Practicas.Practica3.Practica3_A;

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

        ListaDeEnteros l3 = l2.cambiarOrdenado(l);
        l3.comenzar();
        while(!l3.fin()){
            System.out.println(l3.proximo());
        }
    }
}