package PrograIII.Graph.util;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

import java.util.*;

public class Dijkstra<T> {
    //O(|V|^2)
    public Costo[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> v) {
        if((!grafo.listaDeVertices().incluye(v)))
            return null;
        int length = grafo.listaDeVertices().tamanio();
        Costo[] costos = new Costo[length];
        boolean[] marca = new boolean[length];

        for (int i = 0; i < length; i++) {
            costos[i] = new Costo();
        }

        costos[v.posicion()].setMin(0);
        for (int i = 0; i < length; i++){
            int pos = verticeDesconocidoMenorDist(costos, marca);
            if(pos == -1)
                break;
            Vertice<T> U = grafo.listaDeVertices().elemento(pos);
            marca[pos] = true;
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> A = ady.proximo();
                Vertice<T> W = A.verticeDestino();
                if ((!marca[W.posicion()]) && (costos[W.posicion()].getMin() > costos[U.posicion()].getMin() + A.peso())) {
                    costos[W.posicion()].setMin(costos[U.posicion()].getMin() + A.peso());
                    costos[W.posicion()].setPrevio(U.posicion());
                }
            }
        }
        return costos;
    }
    
    private int verticeDesconocidoMenorDist(Costo[] costos, boolean[] marca) {
        int minDistancia = Integer.MAX_VALUE;
        int minPos = -1;

        for (int i = 0; i < costos.length; i++) {
            if ((!marca[i]) && (costos[i].getMin() < minDistancia)) {
                minDistancia = costos[i].getMin();
                minPos = i;
            }
        }
        return minPos;
    }
    
    //------------------------------------------------------------------------------------------
    
    //O((|V|+|E|)log|V|)  -> |V|+|E| del recorrido y log|V| para la heap
    public Costo[] dijkstraConHeap(Grafo<T> grafo, Vertice<T> v) {
        int length = grafo.listaDeVertices().tamanio();
        Costo[] costos = new Costo[length];
        if ((!grafo.listaDeVertices().incluye(v)))
            return null;
        boolean[] marca = new boolean[length];
        PriorityQueue<CostoHeap<T>> heap = new PriorityQueue<CostoHeap<T>>();

        for (int i = 0; i < length; i++) {
            costos[i] = new Costo();
        }

        costos[v.posicion()].setMin(0);
        heap.offer(new CostoHeap<T>(v.posicion(), 0));

        while (!heap.isEmpty()) {
            Vertice<T> U = grafo.listaDeVertices().elemento(heap.poll().getPos());
            if (marca[U.posicion()])
                continue;

            marca[U.posicion()] = true;
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> A = ady.proximo();
                Vertice<T> W = A.verticeDestino();
                if ((!marca[W.posicion()])
                        && (costos[W.posicion()].getMin() > costos[U.posicion()].getMin() + A.peso())) {
                    costos[W.posicion()].setMin(costos[U.posicion()].getMin() + A.peso());
                    costos[W.posicion()].setPrevio(U.posicion());
                    heap.offer(new CostoHeap<T>(W.posicion(), costos[W.posicion()].getMin()));
                }
            }
        }
        return costos;
    }
    
    /*
        El algoritmo de Djikstra solo es util para aristas con peso o costo positivo. Si los costos de las aristas es negativo no funciona el algoritmo ya que Djikstra siempre toma para procesar el vertice con menor camino que no haya sido visitado, pero si ese camino por ejemplo tiene costo X, puede que exista otro camino que sea menor ya que podriamos pasar por otro camino termine siendo menor a X, pero como el vertice ya fue visitado el camino minimo queda mal. Ejemplo:
    
                S
                ↓ ↘-5
               2↓   ↘
                V ⇾ ⇾ U
                  -10
        En este caso el camino mino desde S a U quedaria -5 cuando en realiad es -8 (S⇾V⇾U)
    */

    //------------------------------------------------------------------------------------------

    public CostoTodosMinimos[] dijkstraTodosMinimos(Grafo<T> grafo, Vertice<T> v) {
        if ((!grafo.listaDeVertices().incluye(v)))
            return null;
        int length = grafo.listaDeVertices().tamanio();
        CostoTodosMinimos[] costos = new CostoTodosMinimos[length];
        boolean[] marca = new boolean[length];

        for (int i = 0; i < length; i++) {
            costos[i] = new CostoTodosMinimos();
        }

        costos[v.posicion()].setMin(0);
        costos[v.posicion()].setCaminos(1);
        for (int i = 0; i < length; i++) {
            int pos = verticeDesconocidoMenorDist(costos, marca);
            if (pos == -1)
                break;
            Vertice<T> U = grafo.listaDeVertices().elemento(pos);
            marca[pos] = true;
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> A = ady.proximo();
                Vertice<T> W = A.verticeDestino();
                if (costos[W.posicion()].getMin() == costos[U.posicion()].getMin() + A.peso())
                    costos[W.posicion()].setCaminos(costos[W.posicion()].getCaminos()+1);
                if ((!marca[W.posicion()])
                        && (costos[W.posicion()].getMin() > costos[U.posicion()].getMin() + A.peso())) {
                    costos[W.posicion()].setMin(costos[U.posicion()].getMin() + A.peso());
                    costos[W.posicion()].setPrevio(U.posicion());
                    costos[W.posicion()].setCaminos(1);
                }
            }
        }
        return costos;
    }
    
    private int verticeDesconocidoMenorDist(CostoTodosMinimos[] costos, boolean[] marca) {
        int minDistancia = Integer.MAX_VALUE;
        int minPos = -1;

        for (int i = 0; i < costos.length; i++) {
            if ((!marca[i]) && (costos[i].getMin() < minDistancia)) {
                minDistancia = costos[i].getMin();
                minPos = i;
            }
        }
        return minPos;
    }
}
