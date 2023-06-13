package PracticaParcial.Parcial2;

import PrograIII.GenericList.ListaGenericaEnlazada;
import PracticaParcial.Parcial1.Ciudad;
import PrograIII.GenericList.ListaGenerica;

public class Auxiliar {
    private ListaGenerica<Ciudad> lista;
    private int cant;

    public Auxiliar(){
        this.lista = new ListaGenericaEnlazada<>();
        this.cant = 0;
    }

    public ListaGenerica<Ciudad> getLista(){
        return lista;
    }

    public int getCant(){
        return cant;
    }

    public void setLista(ListaGenerica<Ciudad> lista){
        this.lista = lista;
    }

    public void setCant(int cant){
        this.cant = cant;
    }
}
