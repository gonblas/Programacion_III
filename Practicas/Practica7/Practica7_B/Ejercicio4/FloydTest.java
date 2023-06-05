package Practicas.Practica7.Practica7_B.Ejercicio4;

import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;
import PrograIII.Graph.util.Costo;
import PrograIII.Graph.util.Floyd;

public class FloydTest {
    public static void main(String[] args) {
        Vertice<Integer> v0 = new VerticeImplListAdy<Integer>(0);
        Vertice<Integer> v1 = new VerticeImplListAdy<Integer>(1);
        Vertice<Integer> v2 = new VerticeImplListAdy<Integer>(2);
        Vertice<Integer> v3 = new VerticeImplListAdy<Integer>(3);
        Vertice<Integer> v4 = new VerticeImplListAdy<Integer>(4);
    
        Grafo<Integer> grafo = new GrafoImplListAdy<Integer>();
    
        grafo.agregarVertice(v0);
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
    
        grafo.conectar(v0, v2, 1);
    
        grafo.conectar(v1, v0, 3);
        grafo.conectar(v1, v2, 2);
        grafo.conectar(v1, v3, 4);
    
        grafo.conectar(v2, v3, 7);
        grafo.conectar(v2, v4, 4);
    
        grafo.conectar(v3, v4, 3);
        grafo.conectar(v3, v0, 1);
    
        grafo.conectar(v4, v1, 2);
        grafo.conectar(v4, v3, 2);
        grafo.conectar(v4, v0, 6);
    
        Floyd<Integer> floyd = new Floyd<Integer>();
    
        Costo[][] matriz = floyd.floyd(grafo);
    
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j].getMin() + " ");
            }
            System.out.println();
        }
    
        System.out.println("---------");
    
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j].getPrevio() + " ");
            }
            System.out.println();
        }
    }
}
