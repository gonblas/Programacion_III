package Practicas.Practica3.Practica3_A;
import PrograIII.ListInt.ListaDeEnterosEnlazada;
public class Ejercicio4 {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        l.agregarFinal(12);
        l.agregarFinal(2);
        l.agregarFinal(132);
        l.agregarFinal(125);
        l.agregarFinal(112);
        l.agregarFinal(192);
        l.agregarFinal(1209);

        ListaDeEnterosEnlazada l2 = UtilitariosLista.mergeSort(l);
        
        System.out.println(l2.toString());
    }
}
