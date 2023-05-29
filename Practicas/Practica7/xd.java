package Practicas.Practica7;

import PrograIII.Graph.VerticeImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.ListGeneric.ListaGenerica;

public class xd {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Asunsion");
        Vertice<String> v6 = new VerticeImplListAdy<String>("La Habana");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Caracas");

        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);
        ciudades.conectar(v1, v2, 3);
   
        ciudades.conectar(v1, v4, 4);
        ciudades.conectar(v1, v5, 8);
        ciudades.conectar(v2, v5, 500);

        ciudades.conectar(v4, v5, 2);
        ciudades.conectar(v2, v6, 4);
        ciudades.conectar(v7, v5, 11);
        ciudades.conectar(v7, v6, 10);
        
        DijkstraAlgorithm<String> D = new DijkstraAlgorithm<String>();
        ListaGenerica<Vertice<String>> l = D.Dijkstra(ciudades, v1, v5);
        l.comenzar();
        while (!l.fin()) {
            System.out.print("-> " + l.proximo().dato() + " ");
        }

    }
}
