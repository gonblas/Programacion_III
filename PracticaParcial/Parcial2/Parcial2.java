package PracticaParcial.Parcial2;

import PracticaParcial.Parcial1.Ciudad;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial2 {
    public ListaGenerica<Ciudad> resolver(Grafo<Ciudad> ciudades, String origen, String destino,
            ListaGenerica<Ciudad> pasandoPor) {
        ListaGenerica<Ciudad> camino = new ListaGenericaEnlazada<Ciudad>();
        if (ciudades == null || ciudades.esVacio()) {
            return camino;
        }
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
        Vertice<Ciudad> vOrigen = null, vDestino = null;
        ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
        vertices.comenzar();
        while (!vertices.fin() && (vOrigen == null || vDestino == null)) {
            Vertice<Ciudad> vActual = vertices.proximo();
            if (vActual.dato().getNombre().equals(origen)) 
                vOrigen = vActual;
            if (vActual.dato().getNombre().equals(destino)) 
                vDestino = vActual;
        }

        if (vOrigen != null && vDestino != null) {
            ListaGenerica<Ciudad> aux = new ListaGenericaEnlazada<Ciudad>();
            Auxiliar resultado = new Auxiliar();
            resolverRecursivo(vOrigen, vDestino, ciudades, marca, pasandoPor, aux, resultado, 0);
            camino = resultado.getLista();
        }
        return camino;
    }
    
    private boolean resolverRecursivo(Vertice<Ciudad> vOrigen, Vertice<Ciudad> vDestino, Grafo<Ciudad> ciudades, boolean[] marca, ListaGenerica<Ciudad> pasandoPor, ListaGenerica<Ciudad> actual, Auxiliar resultado, int cant) {
        marca[vOrigen.posicion()] = true;
        if (actual.incluye(vOrigen.dato())) { //Si ya lo incluye no recorro
            return false;
        }
        actual.agregarFinal(vOrigen.dato());
        if(pasandoPor.incluye(vOrigen.dato()))
            cant++;

        if (vOrigen == vDestino) {
            if(cant == pasandoPor.tamanio()){
                resultado.setLista(actual.clonar());
                resultado.setCant(cant);
                return true;
            }
            if(cant > resultado.getCant()){ //Si pase por mas ciudades obligatorias
                resultado.setLista(actual.clonar());
                resultado.setCant(cant);
            }
        }
        else {
            ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vOrigen);
            ady.comenzar();
    
            while(!ady.fin()){
                Vertice<Ciudad> V = ady.proximo().verticeDestino();
                if (!marca[V.posicion()]) {
                    if(resolverRecursivo(V, vDestino, ciudades, marca, pasandoPor, actual, resultado, cant))
                        return true;
                }
            }
        }

        marca[vOrigen.posicion()] = false;
        actual.eliminarEn(actual.tamanio()-1);
        if(pasandoPor.incluye(vOrigen.dato()))
            cant--;
        return false;
    }
}
