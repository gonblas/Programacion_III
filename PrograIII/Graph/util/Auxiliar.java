package PrograIII.Graph.util;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;

public class Auxiliar<T> {
    private ListaGenerica<T> camino;
    private int costo;

    public Auxiliar() {
        camino = new ListaGenericaEnlazada<>();
        costo = 0;
    }

    public ListaGenerica<T> getCamino() {
        return camino;
    }
    
    public int getCosto() {
        return costo;
    }

    public void setCamino(ListaGenerica<T> camino) {
        this.camino = camino;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void copiarCamino(ListaGenerica<T> list) {
        camino = new ListaGenericaEnlazada<T>();
        list.comenzar();
        while(!list.fin()){
            camino.agregarFinal(list.proximo());
        }
    }
}
