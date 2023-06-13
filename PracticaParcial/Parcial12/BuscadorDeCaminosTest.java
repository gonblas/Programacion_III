package PracticaParcial.Parcial12;

import PracticaParcial.Parcial1.Parcial1;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.VerticeImplListAdy;

public class BuscadorDeCaminosTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Rio Cuarto");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Villa Maria");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Villa Gral. Belgrano");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Villa Dolores");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Cruz del Eje");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Jesús María");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Tulumba");
        Vertice<String> v8 = new VerticeImplListAdy<String>("Córdoba");


        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);
        ciudades.agregarVertice(v8);


        ciudades.conectar(v1, v2, 70); //Rio Cuarto - Villa Maria
        ciudades.conectar(v2, v1, 70);

        ciudades.conectar(v1, v3, 50); //Rio Cuarto - Villa Gral. Belgrano
        ciudades.conectar(v3, v1, 50);

        ciudades.conectar(v1, v4, 90); //Rio Cuarto - Villa Dolores
        ciudades.conectar(v4, v1, 90);

        ciudades.conectar(v2, v5, 80); //Villa Maria - Cruz del Eje
        ciudades.conectar(v5, v2, 80);

        ciudades.conectar(v2, v6, 60); //Villa Maria - Jesús María
        ciudades.conectar(v6, v2, 60);

        ciudades.conectar(v3, v5, 85); //Villa Gral. Belgrano - Cruz del Eje
        ciudades.conectar(v5, v3, 85);

        ciudades.conectar(v3, v7, 90); //Villa Gral. Belgrano - Tulumba
        ciudades.conectar(v7, v3, 90);

        ciudades.conectar(v4, v7, 70); //Villa Dolores - Tulumba
        ciudades.conectar(v7, v4, 70);

        ciudades.conectar(v4, v6, 70); //Villa Dolores - Jesús María
        ciudades.conectar(v6, v4, 70);

        ciudades.conectar(v5, v8, 60); //Cruz del Eje - Córdoba
        ciudades.conectar(v8, v5, 60);

        ciudades.conectar(v6, v8, 90); //Jesus Maria - Córdoba
        ciudades.conectar(v8, v6, 90);

        ciudades.conectar(v7, v8, 75); //Tulumba - Córdoba
        ciudades.conectar(v8, v7, 75);

        BuscadorDeCaminos P12 = new BuscadorDeCaminos();
        ListaGenerica<String> l = P12.caminoDistanciaMaxima(ciudades, "Rio Cuarto", "Córdoba", 80);

        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo());
        }
        System.out.println();
        //  -> Rio Cuarto -> Villa Maria -> Cruz del Eje -> Córdoba: es una opcion
    }
}
