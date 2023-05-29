package Practicas.Practica7.Practica7_A.Ejercicio8;

import java.util.Arrays;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Vertice;
import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class Delta{

    public int maxIslasDistintas(Grafo<String> grafo) {
        int aux, max = -1;
        Vertice<String> v = grafo.listaDeVertices().elemento(0); //Muelle principal
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        marca[0] = true;
        grafo.listaDeAdyacentes(v).comenzar();
        while (!grafo.listaDeAdyacentes(v).fin()) {
            aux = maxIslasDistintas(grafo.listaDeAdyacentes(v).proximo().verticeDestino().posicion(), grafo, marca); //Le paso la primera isla de cada camino a partir del muelle
            if (aux > max)
                max = aux;
        }
        return max;
    }

    private int maxIslasDistintas(int i, Grafo<String> grafo, boolean[] marca) {
        marca[i] = true;
        int cant = 0;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        cant++; //Sumo por cada vertice visitado
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                cant += maxIslasDistintas(j, grafo, marca);
            }
        }
        return cant;
    }

    //Corregir O(∞)//Corregir O(∞) y una clase extra armada
    // public RutaMinima<String> caminoMasCorto(Grafo<String> grafo, String islaO, String islaD){
    //     Auxiliar<String> act = new Auxiliar<String>();
    //     Auxiliar<String> min = new Auxiliar<String>();
    //     min.setCosto(Integer.MAX_VALUE);
    //     RutaMinima<String> result = new RutaMinima<>();
    //     boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    //     int i;
    //     for (i = 0; i < marca.length; i++) {
    //         if (grafo.listaDeVertices().elemento(i).dato().equals(islaO)) {
    //             break;
    //         }
    //     }
    //     if (i < marca.length) //Si la ciudad se encuentra en el grafo
    //         caminoMasCorto(i, grafo, islaD, marca, act, min);
    //     result.setCamino(min.getCamino());
    //     if (result.getCamino().incluye(grafo.listaDeVertices().elemento(0).dato()))
    //         result.setBoletoUnico(false);
    //     return result;
    // }

    // private void caminoMasCorto(int i, Grafo<String> grafo, String islaD, boolean[] marca, Auxiliar<String> act, Auxiliar<String> min) {
    //     Vertice<String> v = grafo.listaDeVertices().elemento(i);
    //     marca[i] = true;
    //     act.getCamino().agregarFinal(v.dato());
    //     if (v.dato().equals(islaD)) {
    //         if (act.getCosto() < min.getCosto()) {
    //             min.copiarCamino(act.getCamino());
    //             min.setCosto(act.getCosto());
    //         }
    //     } else {
    //         ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    //         ady.comenzar();
    //         while (!ady.fin()) {
    //             Arista<String> A = ady.proximo();
    //             int j = A.verticeDestino().posicion();
    //             if (!marca[j]) {
    //                 int basura = act.getCosto();
    //                 act.setCosto(act.getCosto()+A.peso());
    //                 caminoMasCorto(j, grafo, islaD, marca, act, min);
    //                 act.setCosto(basura);
    //                 marca[j] = false;
    //                 act.getCamino().eliminarEn(act.getCamino().tamanio()-1);
    //             }
    //         }
    //     }
    // }

    public RutaMinima<String> caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
        RutaMinima<String> RM = new RutaMinima<String>();
        Vertice<String> vertOrigen = null, vertDestino = null;
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        while (!vertices.fin() && (vertOrigen == null | vertDestino == null)) {
            Vertice<String> V = vertices.proximo();
            if (V.dato().equals(islaO))
                vertOrigen = V;
            if (V.dato().equals(islaD))
                vertDestino = V;
        }

        if((vertOrigen != null) && (vertDestino != null)){
            RM.setCamino(Dijkstra(grafo, vertOrigen, vertDestino));
            if (RM.getCamino().incluye(grafo.listaDeVertices().elemento(0).dato()))
                RM.setBoletoUnico(false);
        }
        return RM;
    }
    
    public ListaGenerica<String> Dijkstra(Grafo<String> grafo, Vertice<String> origen, Vertice<String> destino) {
        ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
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
            Vertice<String> U = grafo.listaDeVertices().elemento(pos);
            marca[pos] = true;
            if(marca[posDestino]) //Corto cuando encuentro el camino minimo hasta el destino
                break;
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(U);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> A = ady.proximo();
                Vertice<String> W = A.verticeDestino();
                if ((!marca[W.posicion()]) && (minimos[W.posicion()] > minimos[U.posicion()] + A.peso())) {
                    minimos[W.posicion()] = minimos[U.posicion()] + A.peso();
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
