package PracticaParcial.Parcial15;

import PracticaParcial.Parcial13.Ciudad;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class Parcial15Test {
    public static void main(String args[]) {
    Vertice<Ciudad> sp = new VerticeImplListAdy<Ciudad>(new Ciudad("Suipacha", 3));
    Vertice<Ciudad> ck = new VerticeImplListAdy<Ciudad>(new Ciudad("Carlos Keen", 5));
    Vertice<Ciudad> m = new VerticeImplListAdy<Ciudad>(new Ciudad("Moreno", 4));
    Vertice<Ciudad> q = new VerticeImplListAdy<Ciudad>(new Ciudad("Quilmes", 3));
    Vertice<Ciudad> l = new VerticeImplListAdy<Ciudad>(new Ciudad("La Plata", 3));
    Vertice<Ciudad> a = new VerticeImplListAdy<Ciudad>(new Ciudad("Abasto", 4));
    Vertice<Ciudad> c = new VerticeImplListAdy<Ciudad>(new Ciudad("Ca単uelas", 2));
    Vertice<Ciudad> n = new VerticeImplListAdy<Ciudad>(new Ciudad("Navarro", 2));
    Vertice<Ciudad> sa = new VerticeImplListAdy<Ciudad>(new Ciudad("Saladillo", 2));
    Vertice<Ciudad> lo = new VerticeImplListAdy<Ciudad>(new Ciudad("Lobos", 1));
    Vertice<Ciudad> pi = new VerticeImplListAdy<Ciudad>(new Ciudad("Pinamar", 1));
    Vertice<Ciudad> al = new VerticeImplListAdy<Ciudad>(new Ciudad("Altamirano", 1));

    Vertice<Ciudad> b = new VerticeImplListAdy<Ciudad>(new Ciudad("Buenos Aires", 2));


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
    ciudades.agregarVertice(al);
    ciudades.agregarVertice(b);

    ciudades.conectar(sp, ck, 2); // Suipacha - Carlos Keen
    ciudades.conectar(ck, sp, 2);

    ciudades.conectar(sp, n, 2); // Suipacha - Navarro
    ciudades.conectar(n, sp, 2);

    ciudades.conectar(ck, m, 2); // Carlos Keen - Moreno
    ciudades.conectar(m, ck, 2);

    ciudades.conectar(m, q, 2); // Moreno - Quilmes
    ciudades.conectar(q, m, 2);

    ciudades.conectar(q, l, 2); // Quilmes - La Plata
    ciudades.conectar(l, q, 2);

    ciudades.conectar(l, a, 0); // La Plata - Abasto
    ciudades.conectar(a, l, 0);

    ciudades.conectar(a, m, 2); // Abasto - Moreno
    ciudades.conectar(m, a, 2);

    ciudades.conectar(al, l, 1); // Altamirano - La Plata
    ciudades.conectar(l, al, 1);

    ciudades.conectar(al, c, 1); // Altamirano - Ca単uelas
    ciudades.conectar(c, al, 1);

    ciudades.conectar(c, n, 2); // Ca単uelas - Navarro
    ciudades.conectar(n, c, 2);

    ciudades.conectar(n, sa, 2); // Navarro - Saladillo
    ciudades.conectar(sa, n, 2);

    ciudades.conectar(n, lo, 0); // Navarro - Lobos
    ciudades.conectar(lo, n, 0);

    ciudades.conectar(l, c, 2); // La Plata - Ca単uelas
    ciudades.conectar(c, l, 2);

    ciudades.conectar(m, b, 2); // La Plata - Buenos Aires
    ciudades.conectar(b, m, 2);
    
    ciudades.conectar(b, sp, 2); // Buenos Aires - Suipacha
    ciudades.conectar(sp, b, 2);
    
    Parcial15 P15 = new Parcial15();

    ListaGenerica<String> ciud = P15.resolver(ciudades, "La Plata", "Suipacha");

    System.out.println(ciud);
}
}
