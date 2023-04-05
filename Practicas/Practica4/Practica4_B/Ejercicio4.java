package Practicas.Practica4.Practica4_B;

import PrograIII.BinaryTree.ArbolBinario;
import PrograIII.BinaryTree.Utiles;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
        ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        ListaGenericaEnlazada<Integer> l = Utiles.trayectoriaPesada(arbolBinarioB);
        System.out.println(l.toString());
    }
}
