package PrograIII.Graph.util;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;

public class Floyd<T> {
    public Costo[][] floyd(Grafo<T> grafo) {
        int size = grafo.listaDeVertices().tamanio();
        //GrafoImplMatrizAdy<T> grafo2 = (GrafoImplMatrizAdy<T>) grafo;
        Costo[][] costos = new Costo[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) 
                    costos[i][j] = new Costo(0, -1);
                else 
                    costos[i][j] = new Costo(Integer.MAX_VALUE, -1);
                
            }
        }


        for(int i = 0; i < size; i++){
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(grafo.listaDeVertices().elemento(i));
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> A = ady.proximo();
                costos[i][A.verticeDestino().posicion()].setMin(A.peso());
                costos[i][A.verticeDestino().posicion()].setPrevio(i);
            }
        }


        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        System.out.println(" " + costos[i][j].toString());
                    }
                    if((costos[i][k].getMin() != Integer.MAX_VALUE) && (costos[k][j].getMin() != Integer.MAX_VALUE))
                    if (costos[i][j].getMin() > costos[i][k].getMin() + costos[k][j].getMin()) {
                        costos[i][j].setMin(costos[i][k].getMin() + costos[k][j].getMin());
                        costos[i][j].setPrevio(k);
                    }
                }
            }
        }
        return costos;
    }
}
