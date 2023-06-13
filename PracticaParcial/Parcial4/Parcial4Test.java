package PracticaParcial.Parcial4;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class Parcial4Test {
    public static void main(String[] args) {
        Vertice<Sitio> v1 = new VerticeImplListAdy<Sitio>(new Sitio("Casa", false));
        Vertice<Sitio> v2 = new VerticeImplListAdy<Sitio>(new Sitio("Plaza", false));
        Vertice<Sitio> v3 = new VerticeImplListAdy<Sitio>(new Sitio("Parque", false));
        Vertice<Sitio> v4 = new VerticeImplListAdy<Sitio>(new Sitio("Banco", false));
        Vertice<Sitio> v5 = new VerticeImplListAdy<Sitio>(new Sitio("Estacion de tren", true));
        Vertice<Sitio> v6 = new VerticeImplListAdy<Sitio>(new Sitio("Municipalidad", false));


        Grafo<Sitio> sitios = new GrafoImplListAdy<Sitio>();
        sitios.agregarVertice(v1);
        sitios.agregarVertice(v2);
        sitios.agregarVertice(v3);
        sitios.agregarVertice(v4);
        sitios.agregarVertice(v5);
        sitios.agregarVertice(v6);

        sitios.conectar(v1, v6, 1); //Casa - Municipalidad
        sitios.conectar(v6, v1, 1);

        sitios.conectar(v1, v2, 0); //Casa - Plaza
        sitios.conectar(v2, v1, 0);

        sitios.conectar(v1, v3, 1); //Casa - Parque
        sitios.conectar(v3, v1, 1);

        sitios.conectar(v1, v5, 0); //Casa - Estacion de tren
        sitios.conectar(v5, v1, 0);


        sitios.conectar(v2, v3, 1); //Plaza - Parque
        sitios.conectar(v3, v2, 1);

        sitios.conectar(v2, v4, 0); //Plaza - Banco
        sitios.conectar(v4, v2, 0);

        sitios.conectar(v3, v6, 0); //Parque - Municipalidad
        sitios.conectar(v6, v3, 0);

        sitios.conectar(v4, v6, 0); //Banco - Municipalidad
        sitios.conectar(v6, v4, 0);

        Parcial4 P4 = new Parcial4();
        ListaGenerica<String> l = P4.resolver(sitios, "Casa", "Municipalidad");
        //RTA: Casa -> Plaza -> Banco -> Municipalidad
        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo());
        }
        System.out.println();
        // -> Casa -> Plaza -> Banco -> Municipalidad
    }
}
