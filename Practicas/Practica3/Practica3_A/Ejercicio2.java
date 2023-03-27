package Practicas.Practica3.Practica3_A;

public class Ejercicio2 {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        l.agregarFinal(12);
        l.agregarFinal(2);
        l.agregarFinal(3);
        l.agregarFinal(309);
        ListaDeEnterosEnlazada l2 = l.ordenar();
        while(!l2.fin()){
            System.out.println(l2.proximo());
        }
    }
    
}
