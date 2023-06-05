package PrograIII.Graph.util;

import PrograIII.Graph.Grafo;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Vertice;
import java.util.Arrays;

public class Algoritmos<T> {

    //----------------------------------------------------------------------------------------

    public boolean subgrafoCuadrado(Grafo<T> grafo){
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i]) {
                boolean[] enRecursion = new boolean[grafo.listaDeVertices().tamanio()];
                if(subgrafoCuadrado(i, grafo, marca, enRecursion) == 4)
                    return true;
            }
        }
        return false;
    }

    private int subgrafoCuadrado(int i, Grafo<T> grafo, boolean[] marca, boolean[] enRecursion) {
        marca[i] = true;
        enRecursion[i] = true;
        int aux = 0;

        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();

        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                aux += subgrafoCuadrado(j, grafo, marca, enRecursion);
                if (aux > 0)
                    return aux + 1;
            } else if (enRecursion[j]) {
                return 1;
            }
        }
        enRecursion[i] = false;
        return aux;
    }

    //----------------------------------------------------------------------------------------

    public int getGrado(Grafo<T> grafo) {
        int[] grados = new int[grafo.listaDeVertices().tamanio()];
        ListaGenerica<Arista<T>> ady = null;
        Vertice<T> v = null;
        for (int i = 0; i < grados.length; i++) {
            v = grafo.listaDeVertices().elemento(i);
            ady = grafo.listaDeAdyacentes(v);
            grados[i] += ady.tamanio(); //Sumo el grado de salida
            ady.comenzar();
            while (!ady.fin()) { //Sumo grados de entrada
                grados[ady.proximo().verticeDestino().posicion()]++;
            }
        }
        
        return Arrays.stream(grados).max().getAsInt();
    }

    //----------------------------------------------------------------------------------------

    public boolean tieneCiclo(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        boolean flag = false;
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i]) {
                boolean[] enRecursion = new boolean[grafo.listaDeVertices().tamanio()];
                flag = tieneCiclo(i, grafo, marca, enRecursion);
                if(flag)
                    return true;
            }
        }
        return false;
    }

    private boolean tieneCiclo(int i, Grafo<T> grafo, boolean[] marca, boolean[] enRecursion) {
        marca[i] = true;
        enRecursion[i] = true;
    
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
    
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                if (tieneCiclo(j, grafo, marca, enRecursion)) {
                    return true;
                }
            } else if (enRecursion[j]) {
                return true;
            }
        }
        enRecursion[i] = false;
        return false;
    }
}
