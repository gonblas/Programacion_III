package PracticaParcial.Parcial6;

import PrograIII.GenericList.Cola;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial6<T> {
    public int resolver(Vertice<T> vOrigen, Grafo<T> grafo){
    if(grafo == null || grafo.esVacio() || (!grafo.listaDeVertices().incluye(vOrigen)))
        return -1;
    Cola<Vertice<T>> cola = new Cola<Vertice<T>>();
    cola.encolar(vOrigen);
    cola.encolar(null);
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    int counter = 0;
    while(!cola.esVacia()){
        Vertice<T> V = cola.desencolar();
        if(V != null){
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(V);
            ady.comenzar();
            while(!ady.fin()){
                Vertice<T> W = ady.proximo().verticeDestino();
                if (!marca[W.posicion()]) {
                    cola.encolar(W);
                    marca[W.posicion()] = true;
                }
                    
            }
        }
        else
            if(!cola.esVacia()){
                cola.encolar(null);
                counter++;
            }
    }
    return counter;
}
}
