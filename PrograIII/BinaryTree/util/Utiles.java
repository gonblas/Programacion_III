package PrograIII.BinaryTree.util;

import PrograIII.BinaryTree.ArbolBinario;
import PrograIII.GenericList.Cola;
import PrograIII.GenericList.ListaGenericaEnlazada;


public class Utiles {
    public static int sumaMaximaVertical(ArbolBinario<Integer> tree) {
        if (tree != null) {
            if(tree.esHoja()) 
                return tree.getDato(); //Devuelvo el valor de la hoja
            
            int sumIzq = sumaMaximaVertical(tree.getHijoIzquierdo()); //Sumo el camino izquierdo
            int sumDer = sumaMaximaVertical(tree.getHijoDerecho()); //Sumo el camino derecho

            if (sumIzq > sumDer) { //Retorno la mayor de las sumas incluyendo el dato del nodo actual
                return tree.getDato() + sumIzq;
            }
            else
                return tree.getDato() + sumDer;
        }
        return 0;
    }

    public static int sumaMaximaHorizontal(ArbolBinario<Integer> tree) {
		ArbolBinario<Integer> arbol = null;
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		cola.encolar(tree);
		int sum = 0, max = Integer.MIN_VALUE;
		cola.encolar(null);

		while (!cola.esVacia()) {
			arbol = cola.desencolar();
            if (arbol != null) {
                sum += arbol.getDato(); 
				if(arbol.tieneHijoIzquierdo()){
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if(arbol.tieneHijoDerecho()){
					cola.encolar(arbol.getHijoDerecho());
				}
			}
            else {
                if (!cola.esVacia()) {
                    cola.encolar(null);
                    sum = 0;
                }
                if (sum > max) 
                    max = sum;
			}
		}
		return max;
	}

    public static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> tree) {
        ListaGenericaEnlazada<Integer> result = new ListaGenericaEnlazada<>();
        result = buscarCaminos(tree, 0);
        return result;
    }
    
    private static ListaGenericaEnlazada<Integer> buscarCaminos(ArbolBinario<Integer> tree, int lvl) {
        ListaGenericaEnlazada<Integer> result = new ListaGenericaEnlazada<>();
        if (tree != null) {
            if (tree.esHoja()) {
                ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<>();
                l.agregarInicio(tree.getDato() * lvl);
                return l;
            }
            if (tree.tieneHijoIzquierdo()) {
                ListaGenericaEnlazada<Integer> izq = buscarCaminos(tree.getHijoIzquierdo(), lvl + 1);
                for (int i = 0; i < izq.tamanio(); i++) 
                    result.agregarFinal(izq.elemento(i) + (tree.getDato() * lvl));

            }
            if (tree.tieneHijoDerecho()) {
                ListaGenericaEnlazada<Integer> der = buscarCaminos(tree.getHijoDerecho(), lvl + 1);
                for (int i = 0; i < der.tamanio(); i++) 
                    result.agregarFinal(der.elemento(i) + (tree.getDato() * lvl));
            }
        }
        return result;
    }
}
