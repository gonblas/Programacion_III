package PracticaParcial.Parcial8;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class MapaDeBicisendaTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Estacion 1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Estacion 2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Estacion 3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Estacion 4");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Estacion 5");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Estacion 6");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Estacion 7");
        Vertice<String> v8 = new VerticeImplListAdy<String>("Estacion 8");
        Vertice<String> v9 = new VerticeImplListAdy<String>("Estacion 9");
        Vertice<String> v10 = new VerticeImplListAdy<String>("Estacion 10");
        Vertice<String> v11 = new VerticeImplListAdy<String>("Estacion 11");
        Vertice<String> v12 = new VerticeImplListAdy<String>("Estacion 12");

        Grafo<String> estaciones = new GrafoImplListAdy<String>();
        estaciones.agregarVertice(v1);
        estaciones.agregarVertice(v2);
        estaciones.agregarVertice(v3);
        estaciones.agregarVertice(v4);
        estaciones.agregarVertice(v5);
        estaciones.agregarVertice(v6);
        estaciones.agregarVertice(v7);
        estaciones.agregarVertice(v8);
        estaciones.agregarVertice(v9);
        estaciones.agregarVertice(v10);
        estaciones.agregarVertice(v11);
        estaciones.agregarVertice(v12);

        estaciones.conectar(v1, v2, 1);
        estaciones.conectar(v2, v1, 1);

        estaciones.conectar(v1, v3, 1);
        estaciones.conectar(v3, v1, 1);

        estaciones.conectar(v1, v4, 1);
        estaciones.conectar(v4, v1, 1);

        estaciones.conectar(v1, v5, 1);
        estaciones.conectar(v5, v1, 1);
        
        estaciones.conectar(v2, v5, 1);
        estaciones.conectar(v5, v2, 1);

        estaciones.conectar(v3, v5, 1);
        estaciones.conectar(v5, v3, 1);

        estaciones.conectar(v4, v5, 1);
        estaciones.conectar(v5, v4, 1);

        estaciones.conectar(v2, v6, 1);
        estaciones.conectar(v6, v2, 1);

        estaciones.conectar(v7, v5, 1);
        estaciones.conectar(v5, v7, 1);

        estaciones.conectar(v7, v6, 1);
        estaciones.conectar(v6, v7, 1);

        estaciones.conectar(v7, v8, 1);
        estaciones.conectar(v8, v7, 1);

        estaciones.conectar(v9, v8, 1);
        estaciones.conectar(v8, v9, 1);

        estaciones.conectar(v9, v10, 1);
        estaciones.conectar(v10, v9, 1);

        estaciones.conectar(v11, v10, 1);
        estaciones.conectar(v10, v11, 1);

        estaciones.conectar(v12, v11, 1);
        estaciones.conectar(v11, v12, 1);

        MapaDeBicisenda P8 = new MapaDeBicisenda(estaciones);
        ListaGenerica<String> l = P8.buscarCaminoEntreOrigenYDestino("Estacion 1", "Estacion 12");

        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo());
        }
        System.out.println();
        // -> Estacion 1 -> Estacion 2 -> Estacion 5 -> Estacion 7 -> Estacion 8 -> Estacion 9 -> Estacion 10 -> Estacion 11 -> Estacion 12 es un camino
    }
}
