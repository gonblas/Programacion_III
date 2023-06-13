package PracticaParcial.Parcial11;

import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class Parcial11Test {
    public static void main(String[] args) {
        Vertice<Ciudad> sp = new VerticeImplListAdy<Ciudad>(new Ciudad("Suipacha", 3));
        Vertice<Ciudad> ck = new VerticeImplListAdy<Ciudad>(new Ciudad("Carlos Keen", 2));
        Vertice<Ciudad> m = new VerticeImplListAdy<Ciudad>(new Ciudad("Moreno", 2));
        Vertice<Ciudad> q = new VerticeImplListAdy<Ciudad>(new Ciudad("Quilmes", 3));
        Vertice<Ciudad> l = new VerticeImplListAdy<Ciudad>(new Ciudad("La Plata", 1));
        Vertice<Ciudad> a = new VerticeImplListAdy<Ciudad>(new Ciudad("Abasto", 1));
        Vertice<Ciudad> c = new VerticeImplListAdy<Ciudad>(new Ciudad("CaÃ±uelas", 2));
        Vertice<Ciudad> n = new VerticeImplListAdy<Ciudad>(new Ciudad("Navarro", 1));
        Vertice<Ciudad> sa = new VerticeImplListAdy<Ciudad>(new Ciudad("Saladillo", 2));
        Vertice<Ciudad> lo = new VerticeImplListAdy<Ciudad>(new Ciudad("Lobos", 1));
        Vertice<Ciudad> pi = new VerticeImplListAdy<Ciudad>(new Ciudad("Pinamar", 1));

        Grafo<Ciudad> ciudades = new GrafoImplListAdy<Ciudad>();

        ciudades.agregarVertice(sp);
        ciudades.agregarVertice(ck);
        ciudades.agregarVertice(m);
        ciudades.agregarVertice(q);
        ciudades.agregarVertice(l);
        ciudades.agregarVertice(a);
        ciudades.agregarVertice(c);
        ciudades.agregarVertice(n);
        ciudades.agregarVertice(sa);
        ciudades.agregarVertice(lo);
        ciudades.agregarVertice(pi);

        ciudades.conectar(sp, ck, 2);
        ciudades.conectar(ck, sp, 2);
        ciudades.conectar(sp, n, 1);
        ciudades.conectar(n, sp, 1);
        ciudades.conectar(ck, m, 2);
        ciudades.conectar(m, ck, 2);
        ciudades.conectar(m, q, 2);
        ciudades.conectar(q, m, 2);
        ciudades.conectar(q, l, 2);
        ciudades.conectar(l, q, 2);
        ciudades.conectar(l, a, 2);
        ciudades.conectar(a, l, 2);
        ciudades.conectar(a, m, 3);
        ciudades.conectar(m, a, 3);
        ciudades.conectar(a, c, 2);
        ciudades.conectar(c, a, 2);
        ciudades.conectar(c, n, 2);
        ciudades.conectar(n, c, 2);
        ciudades.conectar(n, sa, 2);
        ciudades.conectar(sa, n, 2);
        ciudades.conectar(n, lo, 4);
        ciudades.conectar(lo, n, 4);

        Parcial11 P11 = new Parcial11();
        System.out.println("El tiempo maximo es " + P11.resolver(ciudades, "Suipacha", "La Plata", 2));
    }
}
