package PrograIII.Graph.util;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class OrdenTopologico<T> {
    public ListaGenerica<Vertice<T>> ordenTopologico(Grafo<T> grafo) {
        ListaGenerica<Vertice<T>> result = new ListaGenericaEnlazada<Vertice<T>>();
        int len = grafo.listaDeVertices().tamanio();
        boolean[] marca = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!marca[i])
                this.sortTopologico(i, grafo, result, marca);
        }
        return result;
    }

    private void sortTopologico(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> lista, boolean[] marca) {
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<T> a = ady.proximo();
            int j = a.verticeDestino().posicion();
            if (!marca[j]) {
                this.sortTopologico(j, grafo, lista, marca);
            }
        }
        lista.agregarInicio(v);
    }
}

