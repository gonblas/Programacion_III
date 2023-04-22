package PrograIII.BinaryTree;
import javax.naming.spi.DirStateFactory.Result;

import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class Adivinanza {
    public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
        if (abinario.esVacio()) { //Si es vacio la lista es vacia
            return null;
        }

        if (abinario.esHoja()) { //Devuelvo una lista con el dato de la hoja
            ListaGenericaEnlazada<String> result = new ListaGenericaEnlazada<String>();
            result.agregarInicio(abinario.getDato());
            return result;
        }
        
        ListaGenericaEnlazada<String> izq = new ListaGenericaEnlazada<>();
        ListaGenericaEnlazada<String> der = new ListaGenericaEnlazada<>();
        
        //Llamo recursivamente y almaceno en las listas izq y der
        if (abinario.tieneHijoIzquierdo())
            izq = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
        if (abinario.tieneHijoDerecho())
            der = secuenciaConMasPreguntas(abinario.getHijoDerecho());
        
            //Comparo aquel que sea mayor y lo retorno
        if (izq.tamanio() >= der.tamanio()) {
            izq.agregarInicio("SI");
            izq.agregarInicio(abinario.getDato());
            return izq;
        } else {
            izq.agregarInicio("NO");
            der.agregarInicio(abinario.getDato());
            return der;
        }
    }

    public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasVersion2(
            ArbolBinario<String> abinario) {
        if (abinario.esVacio()) {
            return null;
        }

        if (abinario.esHoja()) {
            ListaGenericaEnlazada<String> aux = new ListaGenericaEnlazada<>();
            aux.agregarInicio(abinario.getDato());
            ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
            result.agregarInicio(aux);
            return result;
        }

        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> izq = new ListaGenericaEnlazada<>();
        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> der = new ListaGenericaEnlazada<>();

        if (abinario.tieneHijoIzquierdo())
            izq = secuenciaConMasPreguntasVersion2(abinario.getHijoIzquierdo());
        if (abinario.tieneHijoDerecho())
            der = secuenciaConMasPreguntasVersion2(abinario.getHijoDerecho());

        int max = -1;

        for (int i = 0; i < izq.tamanio(); i++) {
            if (izq.elemento(i).tamanio() > max)
                max = izq.elemento(i).tamanio();
        }

        for (int i = 0; i < der.tamanio(); i++) {
            if (der.elemento(i).tamanio() > max)
                max = der.elemento(i).tamanio();
        }

        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();

        for (int i = 0; i < izq.tamanio(); i++) {
            if (izq.elemento(i).tamanio() == max) {
                izq.elemento(i).agregarInicio("SI");
                izq.elemento(i).agregarInicio(abinario.getDato());
                result.agregarFinal(izq.elemento(i));
            }
        }

        for (int i = 0; i < der.tamanio(); i++) {
            if (der.elemento(i).tamanio() == max) {
                der.elemento(i).agregarInicio("NO");
                der.elemento(i).agregarInicio(abinario.getDato());
                result.agregarFinal(der.elemento(i));
            }
        }

        return result;
    }
}
