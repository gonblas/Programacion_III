package Practicas.Practica7.Practica7_A.Ejercicio8;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;

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
