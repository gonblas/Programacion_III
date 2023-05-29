package Practicas.Practica7.Practica7_A.Ejercicio8;

import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

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
