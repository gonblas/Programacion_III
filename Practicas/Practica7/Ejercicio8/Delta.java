package Practicas.Practica7.Ejercicio8;

import PrograIII.Graph.Grafo;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Vertice;
import PrograIII.ListGeneric.ListaGenerica;

public class Delta {

    public int maxIslasDistintas(Grafo<String> grafo) {
        int aux, max = -1;
        Vertice<String> v = grafo.listaDeVertices().elemento(0); //Muelle principal
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        marca[0] = true;
        grafo.listaDeAdyacentes(v).comenzar();
        while (!grafo.listaDeAdyacentes(v).fin()) {
            aux = maxIslasDistintas(grafo.listaDeAdyacentes(v).proximo().verticeDestino().posicion(), grafo, marca); //Le paso la primera isla de cada camino a partir del muelle
            if(aux > max)
                max = aux;
        }
        return max;
    }

    private int maxIslasDistintas(int i, Grafo<String> grafo, boolean[] marca){
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

    public RutaMinima<String> caminoMasCorto(Grafo<String> grafo, String islaO, String islaD){
        Auxiliar<String> act = new Auxiliar<String>();
        Auxiliar<String> min = new Auxiliar<String>();
        min.setCosto(Integer.MAX_VALUE);
        RutaMinima<String> result = new RutaMinima<>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (grafo.listaDeVertices().elemento(i).dato().equals(islaO)) {
                break;
            }
        }
        if (i < marca.length) //Si la ciudad se encuentra en el grafo
            caminoMasCorto(i, grafo, islaD, marca, act, min);
        result.setCamino(min.getCamino());
        if (result.getCamino().incluye(grafo.listaDeVertices().elemento(0).dato()))
            result.setBoletoUnico(false);
        return result;
    }

    private void caminoMasCorto(int i, Grafo<String> grafo, String islaD, boolean[] marca, Auxiliar<String> act, Auxiliar<String> min) {
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        marca[i] = true;
        act.getCamino().agregarFinal(v.dato());
        if (v.dato().equals(islaD)) {
            if (act.getCosto() < min.getCosto()) {
                min.copiarCamino(act.getCamino());
                min.setCosto(act.getCosto());
            }
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> A = ady.proximo();
                int j = A.verticeDestino().posicion();
                if (!marca[j]) {
                    int basura = act.getCosto();
                    act.setCosto(act.getCosto()+A.peso());
                    caminoMasCorto(j, grafo, islaD, marca, act, min);
                    act.setCosto(basura);
                    marca[j] = false;
                    act.getCamino().eliminarEn(act.getCamino().tamanio()-1);
                }
            }
        }
    }
}
