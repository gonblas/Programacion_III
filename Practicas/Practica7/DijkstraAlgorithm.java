package Practicas.Practica7;

import java.util.Arrays;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;
import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;


public class DijkstraAlgorithm<T> {
    public ListaGenerica<Vertice<T>> Dijkstra(Grafo<T> grafo, Vertice<T> origen, Vertice<T> destino) {
        ListaGenerica<Vertice<T>> result = new ListaGenericaEnlazada<Vertice<T>>();
        if((!grafo.listaDeVertices().incluye(origen)) || (!grafo.listaDeVertices().incluye(destino)))
            return result;
        int lenght = grafo.listaDeVertices().tamanio();
        int[] minimos = new int[lenght];
        int[] anterior = new int[lenght];
        boolean[] marca = new boolean[lenght];
        int posOrigen = origen.posicion(), posDestino = destino.posicion();

        Arrays.fill(minimos, Integer.MAX_VALUE);
        minimos[posOrigen] = 0;
        while(true) {
            int pos = verticeDesconocidoMenorDist(minimos, marca);
            Vertice<T> U = grafo.listaDeVertices().elemento(pos);
            marca[pos] = true;
            if(marca[posDestino]) //Corto cuando encuentro el camino minimo hasta el destino
                break;
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> A = ady.proximo();
                Vertice<T> W = A.verticeDestino();
                if ((!marca[W.posicion()]) && (minimos[W.posicion()] > minimos[U.posicion()] + A.peso())) {
                    minimos[W.posicion()] = minimos[U.posicion()] + A.peso();
                    anterior[W.posicion()] = U.posicion();
                }
            }
        }
        int posAux = posDestino;
        while(true){
            result.agregarInicio(grafo.listaDeVertices().elemento(posAux));
            if(posAux == posOrigen)
                break;
            posAux = anterior[posAux];
        }
        return result;
    }
    
    public int verticeDesconocidoMenorDist(int[] minimos, boolean[] marca) {
        int minDistancia = Integer.MAX_VALUE;
        int minPos = -1;
        
        for(int i = 0; i < minimos.length; i++){
            if ((!marca[i]) && (minimos[i] < minDistancia)) {
                minDistancia = minimos[i];
                minPos = i;
            }
        }
        
        return minPos;
    }
}
