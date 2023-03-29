package Practicas.Practica3.Practica3_A;
import PrograIII.ListInt.ListaDeEnterosEnlazada;

public class Ejercicio1 {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        l.comenzar();
        l.agregarFinal(10);
        l.agregarFinal(32);
        l.agregarFinal(1);

        Recorrer(l);
        System.out.println();
    }

    public static void Recorrer(ListaDeEnterosEnlazada l){
		Integer dato = null;
        if(!l.fin()){
            dato = l.proximo();
			Recorrer(l);
        }
		if(dato!=null)
            System.out.print(dato + " ");
	}
}

