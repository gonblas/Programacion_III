package Practicas.Practica7.Ejercicio8;

import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class RutaMinima<T> {
    private ListaGenerica<T> camino;
    private boolean boletoUnico;

    public RutaMinima() {
        camino = new ListaGenericaEnlazada<>();
        boletoUnico = true;
    }

    public ListaGenerica<T> getCamino() {
        return camino;
    }
    
    public boolean getBoletoUnico() {
        return boletoUnico;
    }

    public void setCamino(ListaGenerica<T> camino) {
        this.camino = camino;
    }

    public void setBoletoUnico(boolean boletoUnico) {
        this.boletoUnico = boletoUnico;
    }

}
