package Practicas.Practica4.Practica4_A;

import PrograIII.BinaryTree.ArbolBinario;

public class Ejercicio2 {
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
        
        System.out.print("Preorden: ");
        arbolBinarioB.printPreorden();
        System.out.println();
        System.out.print("Inorden: ");
        arbolBinarioB.printInorden();
        System.out.println();
        System.out.print("Postorden: ");
        arbolBinarioB.printPostorden();
        System.out.println();
        System.out.println("Por niveles: ");
        arbolBinarioB.recorridoPorNiveles();
    }
}
