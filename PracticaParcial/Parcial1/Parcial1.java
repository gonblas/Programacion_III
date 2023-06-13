package PracticaParcial.Parcial1;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial1 {
    public ListaGenerica<Ciudad> resolver(Grafo<Ciudad> ciudades, String origen, String destino) {
        ListaGenerica<Ciudad> camino = new ListaGenericaEnlazada<Ciudad>();
        if (ciudades == null || ciudades.esVacio()) {
            return camino; //Devuelvo lista vacia si el grafo no tiene ciudades
        }
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
        Vertice<Ciudad> vOrigen = null, vDestino = null;
        ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
        vertices.comenzar();
        while ((!vertices.fin()) && ((vOrigen == null) || (vDestino == null))) {
            Vertice<Ciudad> V = vertices.proximo();
            if (V.dato().getNombre().equals(origen))
                vOrigen = V;
            if (V.dato().getNombre().equals(destino))
                vDestino = V;
        }

        if (vOrigen != null && vDestino != null) {
            resolverRecursivo(vOrigen, vDestino, ciudades, marca, camino);
        }

        return camino;
    }
    
    private void resolverRecursivo(Vertice<Ciudad> vOrigen, Vertice<Ciudad> vDestino, Grafo<Ciudad> ciudades, boolean[] marca, ListaGenerica<Ciudad> camino) {
        marca[vOrigen.posicion()] = true;
        if (vOrigen.dato().getFase() == 1) {
            return;
        }
        if (vOrigen == vDestino) {
            camino.agregarFinal(vDestino.dato());
            return;
        }
        
        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while (!ady.fin()) {
            Vertice<Ciudad> vAdyacente = ady.proximo().verticeDestino();
            if (!marca[vAdyacente.posicion()]) {
                resolverRecursivo(vAdyacente, vDestino, ciudades, marca, camino);
                if (!camino.esVacia()) {
                    camino.agregarInicio(vOrigen.dato());
                    return;
                }
            }
        }
    }
}
