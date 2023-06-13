package PracticaParcial.Parcial7;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class Parcial7Test {
    public static void main(String[] args) {
        Vertice<Persona> v1 = new VerticeImplListAdy<Persona>(new Persona("Jose", false, false, "Diag. 80 y 3"));
        Vertice<Persona> v2 = new VerticeImplListAdy<Persona>(new Persona("Mario", true, false, "13 y 22"));
        Vertice<Persona> v3 = new VerticeImplListAdy<Persona>(new Persona("Gabriel", true, true, "65 y 26"));
        Vertice<Persona> v4 = new VerticeImplListAdy<Persona>(new Persona("Nestor", false, false, "3 y 34"));
        Vertice<Persona> v5 = new VerticeImplListAdy<Persona>(new Persona("Homero", true, false, "34 y 115"));
        Vertice<Persona> v6 = new VerticeImplListAdy<Persona>(new Persona("Gelda", true, false, "6 Y 32"));
        Vertice<Persona> v7 = new VerticeImplListAdy<Persona>(new Persona("Agustin", false, false, "9 y 31"));
        Vertice<Persona> v8 = new VerticeImplListAdy<Persona>(new Persona("Carolina", true, false, "2 y 26"));
        Vertice<Persona> v9 = new VerticeImplListAdy<Persona>(new Persona("Marcelo", true, true, "34 e/ 116 y 117"));
        Vertice<Persona> v10 = new VerticeImplListAdy<Persona>(new Persona("Roberto", true, false, "En la calle"));
        Vertice<Persona> v11 = new VerticeImplListAdy<Persona>(new Persona("Stefania", false, false, "22 e/ 48 y 49"));


        Grafo<Persona> personas = new GrafoImplListAdy<Persona>();
        personas.agregarVertice(v1);
        personas.agregarVertice(v2);
        personas.agregarVertice(v3);
        personas.agregarVertice(v4);
        personas.agregarVertice(v5);
        personas.agregarVertice(v6);
        personas.agregarVertice(v7);
        personas.agregarVertice(v8);
        personas.agregarVertice(v9);
        personas.agregarVertice(v10);
        personas.agregarVertice(v11);

        personas.conectar(v1, v2, 1); 
        personas.conectar(v2, v1, 1);

        personas.conectar(v1, v3, 1); 
        personas.conectar(v3, v1, 1);

        personas.conectar(v1, v4, 1); 
        personas.conectar(v4, v1, 1);

        personas.conectar(v3, v5, 1); 
        personas.conectar(v5, v3, 1);

        personas.conectar(v4, v5, 1); 
        personas.conectar(v5, v4, 1);

        personas.conectar(v7, v5, 1); 
        personas.conectar(v5, v7, 1);

        personas.conectar(v4, v6, 1); 
        personas.conectar(v6, v4, 1);

        personas.conectar(v9, v6, 1); 
        personas.conectar(v6, v9, 1);

        personas.conectar(v9, v10, 1); 
        personas.conectar(v10, v9, 1);

        personas.conectar(v9, v8, 1); 
        personas.conectar(v8, v9, 1);

        personas.conectar(v9, v11, 1); 
        personas.conectar(v11, v9, 1);

        personas.conectar(v7, v11, 1); 
        personas.conectar(v11, v7, 1);

        Parcial7 P7 = new Parcial7();
        ListaGenerica<Persona> l = P7.resolver(personas, v1.dato(), 3);
        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo().getNombre());
        }
        //RTA: -> Mario -> Homero -> Gelda
        System.out.println();
    }
}
