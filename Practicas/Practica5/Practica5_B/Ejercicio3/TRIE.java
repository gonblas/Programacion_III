package Practicas.Practica5.Practica5_B.Ejercicio3;

import PrograIII.GeneralTree.ArbolGeneral;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;

public class TRIE {
    private ArbolGeneral<Character> a;


    public TRIE() {
        a = new ArbolGeneral<Character>(null);
    }

    public ArbolGeneral<Character> getArbol() {
        return a;
    }

    public void setArbol(ArbolGeneral<Character> a) {
        this.a = a;
    }

    public void agregarPalabra(String palabra) {
        int len = palabra.length();
        ArbolGeneral<Character> arbol = a;
        for (int i = 0; i < len; i++) {
            ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
            char c = palabra.charAt(i);
            if (!hijos.esVacia()) {
                hijos.comenzar();
                int j = 0;
                for (j = 0; j < hijos.tamanio(); j++) {
                    if (hijos.elemento(j).getDato() >= c) {
                        break;
                    }
                }

                if ((j != hijos.tamanio()) && (hijos.elemento(j).getDato() == c)) {
                    arbol = hijos.elemento(j);
                } else {
                    ArbolGeneral<Character> aux = new ArbolGeneral<Character>(c);
                    hijos.agregarEn(aux, j);
                    arbol = aux;
                }
            } else {
                ArbolGeneral<Character> aux = new ArbolGeneral<Character>(c);
                hijos.agregarInicio(aux);
                arbol = aux;
            }
        }
    }
    
    public ListaGenericaEnlazada<StringBuilder> palabrasQueEmpiezanCon(String prefijo) {
        int len = prefijo.length();
        ArbolGeneral<Character> arbol = a;
        ListaGenericaEnlazada<StringBuilder> result = new ListaGenericaEnlazada<StringBuilder>();
        for (int i = 0; i < len; i++) {
            ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
            char c = prefijo.charAt(i);
            if (!hijos.esVacia()) {
                hijos.comenzar();
                int j = 0;
                for (j = 0; j < hijos.tamanio(); j++) {
                    if (hijos.elemento(j).getDato() >= c) {
                        break;
                    }
                }
                if ((j <= hijos.tamanio()) && (hijos.elemento(j).getDato() == c)) {
                    arbol = hijos.elemento(j);
                } else 
                    return null;
            } else 
                return null;
        }
        StringBuilder cadena = new StringBuilder(prefijo);
        llenarLista(arbol, cadena, result);
        return result;
    }
    
    private void llenarLista(ArbolGeneral<Character> nodo, StringBuilder palabra, ListaGenerica<StringBuilder> lista) {
        if (nodo.esHoja()) {
            lista.agregarFinal(new StringBuilder(palabra));
            return;
        }
        ListaGenerica<ArbolGeneral<Character>> hijos = nodo.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
            ArbolGeneral<Character> hijo = hijos.proximo();
            llenarLista(hijo, palabra.append(hijo.getDato()), lista);
            palabra.deleteCharAt(palabra.length() - 1);
        }
    }
}
