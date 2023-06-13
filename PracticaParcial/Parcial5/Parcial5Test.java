import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class Parcial5Test {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
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
        ciudades.conectar(v1, v2, 4);
        ciudades.conectar(v1, v3, 2);
        ciudades.conectar(v1, v4, 1);
        ciudades.conectar(v1, v5, 8);
        ciudades.conectar(v2, v5, 6);
        ciudades.conectar(v3, v5, 8);
        ciudades.conectar(v4, v5, 9);
        ciudades.conectar(v2, v6, 4);
        ciudades.conectar(v7, v5, 11);
        ciudades.conectar(v7, v6, 10);

        Parcial5<String> P5 = new Parcial5<String>();
        ListaGenerica<ListaGenerica<String>> l = P5.resolver(ciudades);
        l.comenzar();
        while (!l.fin()) {
            ListaGenerica<String> aux = l.proximo();
            aux.comenzar();
            while (!aux.fin()) {
                System.out.print(" -> " + aux.proximo());
            }
            System.out.println();
        }

        //  -> Buenos Aires -> Santiago -> Asuncion
        //  -> Buenos Aires -> Lima -> Asuncion
        //  -> Buenos Aires -> Montevideo -> Asuncion
        //  -> Caracas -> La Habana
    }
}
