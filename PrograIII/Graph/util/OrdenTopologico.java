package PrograIII.Graph.util;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.GenericList.Pila;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class OrdenTopologico<T> {
    public ListaGenerica<Vertice<T>> ordenTopologico(Grafo<T> grafo) {
        ListaGenerica<Vertice<T>> result = new ListaGenericaEnlazada<Vertice<T>>();
        Pila<Vertice<T>> pila = new Pila<Vertice<T>>();
        int len = grafo.listaDeVertices().tamanio();
        boolean[] marca = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!marca[i])
                this.sortTopologico(i, grafo, pila, marca);
        }
        while(!pila.esVacia()){
            result.agregarFinal(pila.desapilar());
        }
        return result;
    }

    private void sortTopologico(int i, Grafo<T> grafo, Pila<Vertice<T>> pila, boolean[] marca) {
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<T> a = ady.proximo();
            if (!marca[a.verticeDestino().posicion()]) {
                int j = a.verticeDestino().posicion();
                this.sortTopologico(j, grafo, pila, marca);
            }
        }
        pila.apilar(v);
    }
}

