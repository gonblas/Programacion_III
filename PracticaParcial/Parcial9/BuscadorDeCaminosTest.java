package PracticaParcial.Parcial9;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class BuscadorDeCaminosTest {
    public static void main(String[] args) {
        Vertice<String> v0 = new VerticeImplListAdy<String>("Casa Caperucita");
        Vertice<String> v1 = new VerticeImplListAdy<String>("Claro 1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Claro 2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Claro 3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Claro 4");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Claro 5");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Casa de la abuela");

        Grafo<String> bosque = new GrafoImplListAdy<String>();
        bosque.agregarVertice(v0);
        bosque.agregarVertice(v1);
        bosque.agregarVertice(v2);
        bosque.agregarVertice(v3);
        bosque.agregarVertice(v4);
        bosque.agregarVertice(v5);
        bosque.agregarVertice(v6);


        bosque.conectar(v0, v1, 4); //Casa de caperucita - Claro 1
        bosque.conectar(v1, v0, 4);

        bosque.conectar(v0, v2, 4); //Casa de caperucita - Claro 2
        bosque.conectar(v2, v0, 4);

        bosque.conectar(v0, v3, 3); //Casa de caperucita - Claro 3
        bosque.conectar(v3, v0, 3);

        bosque.conectar(v3, v5, 15); //Claro 3 - Claro 5
        bosque.conectar(v5, v3, 15);
        
        bosque.conectar(v1, v5, 3); //Claro 1 - Claro 5
        bosque.conectar(v5, v1, 3);

        bosque.conectar(v1, v2, 4); //Claro 1 - Claro 2
        bosque.conectar(v2, v1, 4);

        bosque.conectar(v2, v5, 11); //Claro 2 - Claro 5
        bosque.conectar(v5, v2, 11);

        bosque.conectar(v2, v4, 10); //Claro 2 - Claro 4
        bosque.conectar(v4, v2, 10);

        bosque.conectar(v5, v6, 4); //Claro 5 - Casa Abuelita
        bosque.conectar(v6, v5, 4);

        bosque.conectar(v4, v6, 9); //Claro 4 - Casa Abuelita
        bosque.conectar(v6, v4, 9);


        BuscadorDeCaminos P9 = new BuscadorDeCaminos(bosque);
        ListaGenerica<ListaGenerica<String>> l = P9.recorridosMasSeguros("Casa Caperucita", "Casa de la abuela");
        l.comenzar();
        while (!l.fin()) {
            ListaGenerica<String> aux = l.proximo();
            aux.comenzar();
            while(!aux.fin()){
                System.out.print(" -> " + aux.proximo());
            }
            System.out.println();
        }
        System.out.println();
        // -> Casa Caperucita -> Claro 1 -> Claro 5 -> Casa de la abuela
        // -> Casa Caperucita -> Claro 2 -> Claro 1 -> Claro 5 -> Casa de la abuela
    }
}
