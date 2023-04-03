package Practicas.Practica4.Practica4_A;

import PrograIII.BinaryTree.ArbolBinario;
import PrograIII.ListGeneric.ListaGenerica;

public class Ejercicio3 {
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
        
        //Inciso a)
        System.out.println("La cantidad de hojas del arbol es " + arbolBinarioB.contarHojas());

        //Inciso b)
        ListaGenerica<Integer> l = arbolBinarioB.frontera2();
        while (!l.fin()) {
            System.out.print(l.proximo() + " ");
        }
        System.out.println();

        //Inciso c)
        // System.out.println(arbolBinarioB.esLleno());
        
        //Inciso d)
        System.out.println(arbolBinarioB.esCompleto());
    }
}
