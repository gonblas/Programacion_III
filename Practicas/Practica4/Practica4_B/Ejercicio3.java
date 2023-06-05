package Practicas.Practica4.Practica4_B;

import PrograIII.BinaryTree.*;
import PrograIII.GenericList.ListaGenericaEnlazada;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArbolBinario<String> arbolBinarioX=new ArbolBinario<String>("¿Tiene 4 patas?");
        ArbolBinario<String> hijoIzquierdoX=new ArbolBinario<String>("¿Se mueve?");
        hijoIzquierdoX.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?"));
        hijoIzquierdoX.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<String>("Es un perro"));
        hijoIzquierdoX.agregarHijoDerecho(new ArbolBinario<String>("Es una mesa"));
        ArbolBinario<String> hijoDerechoX = new ArbolBinario<String>("¿Tiene alguna pata?");
        arbolBinarioX.agregarHijoIzquierdo(hijoIzquierdoX);
        arbolBinarioX.agregarHijoDerecho(hijoDerechoX);

        ListaGenericaEnlazada<String> l = Adivinanza.secuenciaConMasPreguntas(arbolBinarioX);
        
        System.out.println(l.toString());


    }
}
