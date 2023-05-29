package Practicas.Practica7.Practica7_A.Ejercicio9;

import java.util.Arrays;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Vertice;
import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class GuiaDeTurismo {
    //DEBERIA COMPARAR PARA CADA LISTA QUE SE VA ARMANDO SI LA CANTIDAD DE PASAJEROS EN TODO EL VIAJE ES MAXIMA Y AHI SI ESTABLEZCO EL NUEVO VALOR
    public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String origen, String destino) {
        ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
        Vertice<String> vertOrigen = null, vertDestino = null;
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        while (!vertices.fin() && (vertOrigen == null | vertDestino == null)) {
            Vertice<String> V = vertices.proximo();
            if (V.dato().equals(origen))
                vertOrigen = V;
            if (V.dato().equals(destino))
                vertDestino = V;
        }
        if((vertOrigen == null) | (vertDestino == null))
            return result;
        int lenght = grafo.listaDeVertices().tamanio();
        int[] maximos = new int[lenght];
        int[] anterior = new int[lenght];
        boolean[] marca = new boolean[lenght];
        int posOrigen = vertOrigen.posicion(), posDestino = vertDestino.posicion();

        Arrays.fill(maximos, -1);
        maximos[posOrigen] = 0;
        while(true) {
            int pos = verticeDesconocidoMenorDist(maximos, marca);
            Vertice<String> U = grafo.listaDeVertices().elemento(pos);
            marca[pos] = true;
            if(marca[posDestino]) //Corto cuando encuentro el camino minimo hasta el destino
                break;
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> A = ady.proximo();
                Vertice<String> W = A.verticeDestino();
                if ((!marca[W.posicion()]) && (maximos[W.posicion()] < maximos[U.posicion()] + A.peso())) {
                    maximos[W.posicion()] = maximos[U.posicion()] + A.peso();
                    anterior[W.posicion()] = U.posicion();
                }
            }
        }
        int posAux = posDestino;
        while(true){
            result.agregarInicio(grafo.listaDeVertices().elemento(posAux).dato());
            if(posAux == posOrigen)
                break;
            posAux = anterior[posAux];
        }
        return result;
    }
    
    public int verticeDesconocidoMenorDist(int[] maximos, boolean[] marca) {
        int maxDistancia = -1;
        int maxPos = -1;
        
        for(int i = 0; i < maximos.length; i++){
            if ((!marca[i]) && (maximos[i] > maxDistancia)) {
                maxDistancia = maximos[i];
                maxPos = i;
            }
        }
        
        return maxPos;
    }
}
