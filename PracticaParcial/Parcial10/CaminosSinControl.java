package PracticaParcial.Parcial10;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class CaminosSinControl {
    private Grafo<String> mapa;

    public CaminosSinControl(Grafo<String> mapa) {
        this.mapa = mapa;
    }
    
    public ListaGenerica<ListaGenerica<String>> devolverCaminos(String origen, String destino){
    ListaGenerica<ListaGenerica<String>> result = new ListaGenericaEnlazada<ListaGenerica<String>>();
    if(mapa == null || mapa.esVacio())
        return result;
    ListaGenerica<Vertice<String>> vertices = mapa.listaDeVertices();
    vertices.comenzar();
    Vertice<String> vOrigen = null, vDestino = null;
    vertices.comenzar();
    while((!vertices.fin()) && (vOrigen == null || vDestino == null)){
        Vertice<String> V = vertices.proximo();
        if(V.dato().equals(origen))
            vOrigen = V;
        if(V.dato().equals(destino))
            vDestino = V;
    }
    
    if(vOrigen != null && vDestino != null){
        ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[mapa.listaDeVertices().tamanio()];
        devolverCaminosRecursivo(vOrigen, vDestino, marca, actual, result);
    }
    return result;
}


private void devolverCaminosRecursivo(Vertice<String> vOrigen, Vertice<String> vDestino, boolean[] marca, ListaGenerica<String> actual, ListaGenerica<ListaGenerica<String>> result){
    marca[vOrigen.posicion()] = true;
    actual.agregarFinal(vOrigen.dato());
    
    if(vOrigen == vDestino){
        result.agregarFinal(actual.clonar());
    }
    else{
        ListaGenerica<Arista<String>> ady = mapa.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while(!ady.fin()){
            Arista<String> A = ady.proximo();
            if(!marca[A.verticeDestino().posicion()] && A.peso() == 0){
                devolverCaminosRecursivo(A.verticeDestino(), vDestino, marca, actual, result);
            }
        }
    }
    marca[vOrigen.posicion()] = false;
    actual.eliminarEn(actual.tamanio()-1);
}
}
