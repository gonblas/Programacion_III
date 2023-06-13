package PracticaParcial.Parcial16;

import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class Parcial16Test {
    public static void main(String[] args) {
        Vertice<Integer> v1 = new VerticeImplListAdy<Integer>(1);
        Vertice<Integer> v2 = new VerticeImplListAdy<Integer>(2);
        Vertice<Integer> v3 = new VerticeImplListAdy<Integer>(3);
        Vertice<Integer> v4 = new VerticeImplListAdy<Integer>(4);
        Vertice<Integer> v5 = new VerticeImplListAdy<Integer>(5);
        Vertice<Integer> v6 = new VerticeImplListAdy<Integer>(6);
        Vertice<Integer> v12 = new VerticeImplListAdy<Integer>(12);

        Grafo<Integer> jugadores = new GrafoImplListAdy<Integer>();
        jugadores.agregarVertice(v1);
        jugadores.agregarVertice(v2);
        jugadores.agregarVertice(v3);
        jugadores.agregarVertice(v4);
        jugadores.agregarVertice(v5);
        jugadores.agregarVertice(v6);
        jugadores.agregarVertice(v12);

        jugadores.conectar(v1, v2, 90);
        jugadores.conectar(v1, v3, 70);
        jugadores.conectar(v2, v3, 60);
        jugadores.conectar(v2, v5, 10);
        jugadores.conectar(v3, v4, 50);
        jugadores.conectar(v4, v3, 100);
        jugadores.conectar(v4, v6, 80);
        jugadores.conectar(v4, v1, 90);
        jugadores.conectar(v3, v6, 10);
        jugadores.conectar(v3, v12, 20);
        jugadores.conectar(v5, v12, 70);
        jugadores.conectar(v6, v5, 30);
        jugadores.conectar(v6, v12, 60);

        Parcial16 P16 = new Parcial16();
        System.out.println(P16.resolver(jugadores, 1, 12).toString());
    }
}
