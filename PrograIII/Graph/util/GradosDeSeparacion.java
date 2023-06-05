package PrograIII.Graph.util;

import PrograIII.Graph.Grafo;
import PrograIII.GenericList.Cola;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Vertice;


public class GradosDeSeparacion {
    public int maximoGradoDeSeparacion(Grafo<String> grafo) {
        int len = grafo.listaDeVertices().tamanio();
        int max = -1, aux;
        for (int i = 0; i < len; i++) {
            aux = maximoGradoDeSeparacion(i, grafo);
            if(aux > max)
                max = aux;
        }
        return max;
    }

    private int maximoGradoDeSeparacion(int i, Grafo<String> grafo) {
        ListaGenerica<Arista<String>> ady = null;
        Cola<Vertice<String>> cola = new Cola<Vertice<String>>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int cant = 0;
        marca[i] = true;
        cola.encolar(grafo.listaDeVertices().elemento(i));
        cola.encolar(null);
        while (!cola.esVacia()) {
            Vertice<String> V = cola.desencolar();
            if (V != null) {
                ady = grafo.listaDeAdyacentes(V);
                ady.comenzar();
                while (!ady.fin()) {
                    Arista<String> arista = ady.proximo();
                    Vertice<String> W = arista.verticeDestino();
                    if (!marca[W.posicion()]) {
                        marca[W.posicion()] = true;
                        cola.encolar(W);
                    }
                }
            }
            else 
                if(!cola.esVacia()){
                    cant++;
                    cola.encolar(null);
                }
        }
        return cant;
    }
    
}
