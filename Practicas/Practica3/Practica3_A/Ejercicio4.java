package Practicas.Practica3.Practica3_A;

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

        while (!l2.fin()) {
            System.out.println(l2.proximo());
        }
    }
}
