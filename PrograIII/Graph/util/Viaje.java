package PrograIII.Graph.util;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;

public class Viaje {
    private ListaGenerica<String> lista;
    private int min;


    public Viaje() {
        lista = new ListaGenericaEnlazada<String>();
        min = Integer.MAX_VALUE;
    }

    public ListaGenerica<String> getLista() {
        return lista;
    }

    public int getMin() {
        return min;
    }

    public void setLista(ListaGenerica<String> lista) {
        this.lista = lista;
    }
    
    public void setMin(int min) {
        this.min = min;
    }

    public void copiarLista(ListaGenerica<String> copia) {
        this.lista = new ListaGenericaEnlazada<String>();
        copia.comenzar();
        while(!copia.fin()){
            this.lista.agregarFinal(copia.proximo());
        }
    }
}
