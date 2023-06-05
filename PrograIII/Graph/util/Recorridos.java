package PrograIII.Graph.util;

import PrograIII.GenericList.Cola;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;


public class Recorridos<T> {
    //Orden O(|V|+|E|)
    public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
        ListaGenerica<Vertice<T>> l = new ListaGenericaEnlazada<Vertice<T>>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.dfs(i, grafo, marca, l);
        }
        return l;
    }
    
    private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> l){
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        l.agregarFinal(v);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                this.dfs(j, grafo, marca, l);
            }
        }
    } 
    
    //Orden O(|V|+|E|)
    public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
        ListaGenerica<Vertice<T>> l = new ListaGenericaEnlazada<Vertice<T>>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i])
                this.bfs(i, grafo, marca, l);
        }
        return l;
    }
    
    private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> l) {
        ListaGenerica<Arista<T>> ady = null;
        Cola<Vertice<T>> cola = new Cola<Vertice<T>>();
        cola.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while (!cola.esVacia()) {
            Vertice<T> V = cola.desencolar();
            l.agregarFinal(V);
            ady = grafo.listaDeAdyacentes(V);
            ady.comenzar();
            while(!ady.fin()){
                Arista<T> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();
                if (!marca[j]) {
                    marca[j] = true;
                    cola.encolar(arista.verticeDestino());
                }
            }
        }
    }
}
