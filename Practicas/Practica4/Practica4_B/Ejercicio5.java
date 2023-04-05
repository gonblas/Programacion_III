package Practicas.Practica4.Practica4_B;

import PrograIII.BinaryTree.Adivinanza;
import PrograIII.BinaryTree.ArbolBinario;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArbolBinario<String> arbolBinarioX=new ArbolBinario<String>("¿Tiene 4 patas?");
        ArbolBinario<String> hijoIzquierdoX=new ArbolBinario<String>("¿Se mueve?");
        hijoIzquierdoX.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?"));
        
        hijoIzquierdoX.agregarHijoDerecho(new ArbolBinario<String>("Es una mesa"));
        ArbolBinario<String> hijoDerechoX = new ArbolBinario<String>("¿Tiene alguna pata?");
        arbolBinarioX.agregarHijoIzquierdo(hijoIzquierdoX);
        arbolBinarioX.agregarHijoDerecho(hijoDerechoX);

        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> l = Adivinanza
                .secuenciaConMasPreguntasVersion2(arbolBinarioX);
        
        for (int i = 0; i < l.tamanio(); i++){
            System.out.println(l.elemento(i).toString());
        }

    }
}
