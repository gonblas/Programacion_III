package PracticaParcial.Parcial1;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class Parcial1Test {
    public static void main(String[] args) {
        Vertice<Ciudad> v1 = new VerticeImplListAdy<Ciudad>(new Ciudad("La Plata", 2));
        Vertice<Ciudad> v2 = new VerticeImplListAdy<Ciudad>(new Ciudad("Pinamar", 3));
        Vertice<Ciudad> v3 = new VerticeImplListAdy<Ciudad>(new Ciudad("Quilmes", 1));
        Vertice<Ciudad> v4 = new VerticeImplListAdy<Ciudad>(new Ciudad("Abasto", 2));
        Vertice<Ciudad> v5 = new VerticeImplListAdy<Ciudad>(new Ciudad("Moreno", 1));
        Vertice<Ciudad> v6 = new VerticeImplListAdy<Ciudad>(new Ciudad("Cañuelas", 3));
        Vertice<Ciudad> v7 = new VerticeImplListAdy<Ciudad>(new Ciudad("Carlos Keen", 3));
        Vertice<Ciudad> v8 = new VerticeImplListAdy<Ciudad>(new Ciudad("Lobos", 3));
        Vertice<Ciudad> v9 = new VerticeImplListAdy<Ciudad>(new Ciudad("Navarro", 4));
        Vertice<Ciudad> v10 = new VerticeImplListAdy<Ciudad>(new Ciudad("Saladillo", 4));
        Vertice<Ciudad> v11= new VerticeImplListAdy<Ciudad>(new Ciudad("Suipacha", 5));


        Grafo<Ciudad> ciudades = new GrafoImplListAdy<Ciudad>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);
        ciudades.agregarVertice(v8);
        ciudades.agregarVertice(v9);
        ciudades.agregarVertice(v10);
        ciudades.agregarVertice(v11);

        ciudades.conectar(v1, v2, 1); //La Plata - Pinamar
        ciudades.conectar(v2, v1, 1);

        ciudades.conectar(v1, v3, 1); //La Plata - Quilmes
        ciudades.conectar(v3, v1, 1);

        ciudades.conectar(v1, v4, 1); //La Plata - Abasto
        ciudades.conectar(v4, v1, 1);

        ciudades.conectar(v3, v5, 1); //Quilmes - Moreno
        ciudades.conectar(v5, v3, 1);

        ciudades.conectar(v4, v5, 1); //Abasto - Moreno
        ciudades.conectar(v5, v4, 1);

        ciudades.conectar(v7, v5, 1); //Moreno - Carlos Keen
        ciudades.conectar(v5, v7, 1);

        ciudades.conectar(v4, v6, 1); //Abasto - Cañuelas
        ciudades.conectar(v6, v4, 1);

        ciudades.conectar(v9, v6, 1); //Cañuelas - Navarro
        ciudades.conectar(v6, v9, 1);

        ciudades.conectar(v9, v10, 1); //Navarro - Saladillo
        ciudades.conectar(v10, v9, 1);

        ciudades.conectar(v9, v8, 1); //Navarro - Lobos
        ciudades.conectar(v8, v9, 1);

        ciudades.conectar(v9, v11, 1); //Navarro - Suipacha
        ciudades.conectar(v11, v9, 1);

        ciudades.conectar(v7, v11, 1); //Suipacha - Carlos Keen
        ciudades.conectar(v11, v7, 1);

        Parcial1 P1 = new Parcial1();
        ListaGenerica<Ciudad> l = P1.resolver(ciudades, "La Plata", "Carlos Keen");

        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo().getNombre());
        }
        System.out.println();
        // -> La Plata -> Abasto -> Cañuelas -> Navarro -> Suipacha -> Carlos Keen
    }
}
