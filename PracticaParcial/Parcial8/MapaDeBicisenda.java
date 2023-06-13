package PracticaParcial.Parcial8;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.GrafoImplListAdy;
import PrograIII.Graph.Vertice;

public class MapaDeBicisenda {
    private GrafoImplListAdy<String> grafo;

    public MapaDeBicisenda(Grafo<String> grafo) {
        this.grafo = (GrafoImplListAdy<String>) grafo;
    }

    public MapaDeBicisenda() {
        this.grafo = null;
    }

    public ListaGenerica<String> buscarCaminoEntreOrigenYDestino(String origen, String destino){
    ListaGenerica<String> result = new ListaGenericaEnlazada<>();
    if(grafo == null || grafo.esVacio())
        return result;
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    Vertice<String> vOrigen = null, vDestino = null;
    while((!vertices.fin() && (vOrigen==null || vDestino == null))){
        Vertice<String> V = vertices.proximo();
        if(V.dato().equals(origen))
            vOrigen = V;
        if(V.dato().equals(destino))
            vDestino = V;
    }
    
    if(vOrigen != null && vDestino != null){
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        buscarRecursivo(vOrigen, vDestino, marca, result);
    }
    return result;
}

private boolean buscarRecursivo(Vertice<String> vOrigen, Vertice<String> vDestino, boolean[] marca, ListaGenerica<String> result){
    marca[vOrigen.posicion()] = true;
    
    if (vOrigen == vDestino) {
        result.agregarFinal(vDestino.dato());
        return true;
    }
    
    ListaGenerica<Arista<String>> ady =  grafo.listaDeAdyacentes(vOrigen);
    ady.comenzar();
    while (!ady.fin()) {
        Vertice<String> W = ady.proximo().verticeDestino();
        if (!marca[W.posicion()]) {
            if (buscarRecursivo(W, vDestino, marca, result)) {
                result.agregarInicio(vOrigen.dato());
                return true;
            }
        }
    }
    return false;
}
}
