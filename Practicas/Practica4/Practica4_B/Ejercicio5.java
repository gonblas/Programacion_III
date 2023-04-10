package Practicas.Practica4.Practica4_B;

import PrograIII.BinaryTree.Adivinanza;
import PrograIII.BinaryTree.ArbolBinario;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArbolBinario<String> arbolBinarioB;
        arbolBinarioB = new ArbolBinario<String>("¿Tiene 4 patas?");
		ArbolBinario<String> hijoIzquierdoB = new ArbolBinario<String>("¿Se mueve?");
		ArbolBinario<String> h = new ArbolBinario<>("¿Es de madera?");
		ArbolBinario<String> hh = new ArbolBinario<>("¿Es rojo?");
		hh.agregarHijoDerecho(new ArbolBinario<String>("Sapo"));
		h.agregarHijoIzquierdo(hh);
		h.agregarHijoDerecho(new ArbolBinario<String>("MESA"));

		hijoIzquierdoB.agregarHijoDerecho(h);
		ArbolBinario<String> hhijoIzquierdoB = new ArbolBinario<String>("¿Ladra?");
		hhijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<String>("Es un perro"));
		hhijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<String>("Es un gato"));
		hijoIzquierdoB.agregarHijoIzquierdo(hhijoIzquierdoB);
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(new ArbolBinario<String>("Es una persona"));

        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> l = Adivinanza
                .secuenciaConMasPreguntasVersion2(arbolBinarioB);
        
        for (int i = 0; i < l.tamanio(); i++){
            System.out.println(l.elemento(i).toString());
        }

    }
}
