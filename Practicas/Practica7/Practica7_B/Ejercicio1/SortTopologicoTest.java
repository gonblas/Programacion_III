package Practicas.Practica7.Practica7_B.Ejercicio1;

import PrograIII.Graph.util.OrdenTopologico;
import PrograIII.Graph.VerticeImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;


public class SortTopologicoTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("boxer");
        Vertice<String> v2 = new VerticeImplListAdy<String>("pantalones");
        Vertice<String> v3 = new VerticeImplListAdy<String>("cinturon");
        Vertice<String> v4 = new VerticeImplListAdy<String>("camisa");
        Vertice<String> v5 = new VerticeImplListAdy<String>("corbata");
        Vertice<String> v6 = new VerticeImplListAdy<String>("saco");
        Vertice<String> v7 = new VerticeImplListAdy<String>("medias");
        Vertice<String> v8 = new VerticeImplListAdy<String>("zapatos");
        Vertice<String> v9 = new VerticeImplListAdy<String>("reloj");

        Grafo<String> prendas = new GrafoImplListAdy<String>();
        prendas.agregarVertice(v1);
        prendas.agregarVertice(v2);
        prendas.agregarVertice(v3);
        prendas.agregarVertice(v4);
        prendas.agregarVertice(v5);
        prendas.agregarVertice(v6);
        prendas.agregarVertice(v7);
        prendas.agregarVertice(v8);
        prendas.agregarVertice(v9);

        prendas.conectar(v1, v2, 1);
        prendas.conectar(v2, v3, 1);
        prendas.conectar(v3, v5, 1);
        prendas.conectar(v5, v6, 1);
        prendas.conectar(v4, v3, 1);
        prendas.conectar(v4, v5, 1);
        prendas.conectar(v1, v8, 1);
        prendas.conectar(v2, v8, 1);
        prendas.conectar(v7, v8, 1);

        OrdenTopologico<String> OT = new OrdenTopologico<String>(); 

        ListaGenerica<Vertice<String>> l = OT.ordenTopologico(prendas);
        

        l.comenzar();
        while (!l.fin()) {
            System.out.print("-> " + l.proximo().dato());
        }
        System.out.println();

    }
}
