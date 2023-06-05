package PrograIII.Graph.util;

import PrograIII.Graph.Grafo;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Vertice;

public class GuiaDeTurismo {
    // public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String origen, String destino) {
    //     ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
    //     Vertice<String> vertOrigen = null, vertDestino = null;
    //     ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    //     vertices.comenzar();
    //     while (!vertices.fin() && (vertOrigen == null | vertDestino == null)) {
    //         Vertice<String> V = vertices.proximo();
    //         if (V.dato().equals(origen))
    //             vertOrigen = V;
    //         if (V.dato().equals(destino))
    //             vertDestino = V;
    //     }
    //     if((vertOrigen == null) | (vertDestino == null))
    //         return result;
    //     int lenght = grafo.listaDeVertices().tamanio();
    //     int[] maximos = new int[lenght];
    //     int[] anterior = new int[lenght];
    //     boolean[] marca = new boolean[lenght];
    //     int posOrigen = vertOrigen.posicion(), posDestino = vertDestino.posicion();

    //     Arrays.fill(maximos, -1);
    //     maximos[posOrigen] = 0;
    //     while(true) {
    //         int pos = verticeDesconocidoMayorDist(maximos, marca);
    //         Vertice<String> U = grafo.listaDeVertices().elemento(pos);
    //         marca[pos] = true;
    //         if(marca[posDestino]) //Corto cuando encuentro el camino minimo hasta el destino
    //             break;
    //         ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(U);
    //         ady.comenzar();
    //         while (!ady.fin()) {
    //             Arista<String> A = ady.proximo();
    //             Vertice<String> W = A.verticeDestino();
    //             if ((!marca[W.posicion()]) && (maximos[W.posicion()] < A.peso())) { 
    //                 maximos[W.posicion()] = A.peso();
    //                 anterior[W.posicion()] = U.posicion();
    //             }
    //         }
    //     }
    //     int posAux = posDestino;
    //     while(true){
    //         result.agregarInicio(grafo.listaDeVertices().elemento(posAux).dato());
    //         if(posAux == posOrigen)
    //             break;
    //         posAux = anterior[posAux];
    //     }
    //     return result;
    // }
    
    // private int verticeDesconocidoMayorDist(int[] maximos, boolean[] marca) {
    //     int maxDistancia = -1;
    //     int maxPos = -1;

    //     for (int i = 0; i < maximos.length; i++) {
    //         if ((!marca[i]) && (maximos[i] > maxDistancia)) {
    //             maxDistancia = maximos[i];
    //             maxPos = i;
    //         }
    //     }

    //     return maxPos;
    // }
    
    public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String origen, String destino) {
        if (grafo == null) {
            return null;
        }
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        Vertice<String> vertOrigen = null, vertDestino = null;
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        while ((!vertices.fin()) && ((vertOrigen == null) || (vertDestino == null))) {
            Vertice<String> aux = vertices.proximo();
            if (aux.dato().equals(origen))
                vertOrigen = aux;
            if (aux.dato().equals(destino))
                vertDestino = aux;
        }
        Viaje result = new Viaje();
        result.setMin(0);
        Viaje actual = new Viaje();
        if (((vertOrigen != null) && (vertDestino != null)))
            caminoConMenorNrodeViajes(vertOrigen, vertDestino, grafo, marca, result, actual);

        return result.getLista();
    }
    
    
    private void caminoConMenorNrodeViajes(Vertice<String> vOrigen, Vertice<String> vDestino, Grafo<String> grafo, boolean[] marca, Viaje result, Viaje actual) {
        
        marca[vOrigen.posicion()] = true;
        actual.getLista().agregarFinal(vOrigen.dato());
        
        if (vOrigen == vDestino) {
            if (result.getMin() < actual.getMin()) { //Mayor de los minimos
                result.copiarLista(actual.getLista());
                result.setMin(actual.getMin());
            }
        }
        else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vOrigen);
            ady.comenzar();
            int aux;
            while (!ady.fin()) {
                Arista<String> A = ady.proximo();
                Vertice<String> W = A.verticeDestino();
                if (!marca[W.posicion()]) {
                    aux = actual.getMin();
                    if (actual.getMin() > A.peso()) //Menor peso del camino
                        actual.setMin(A.peso());
                    caminoConMenorNrodeViajes(W, vDestino, grafo, marca, result, actual);
                    actual.setMin(aux);
                    marca[W.posicion()] = false;
                    actual.getLista().eliminarEn(actual.getLista().tamanio() - 1);
                }
            }
            
        }
    } 
}
