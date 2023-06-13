package PracticaParcial.Parcial13;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial13 {
    public ListaGenerica<Ciudad> resolver(Grafo<Ciudad> ciudades, String origen, String destino, int minFase){
    ListaGenerica<Ciudad> result = new ListaGenericaEnlazada<Ciudad>();
    if(ciudades == null || ciudades.esVacio() || minFase <= 0)
        return result;
    
    ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
    vertices.comenzar();
    Vertice<Ciudad> vOrigen = null, vDestino = null;
    while((!vertices.fin())&&(vOrigen == null || vDestino == null)){
        Vertice<Ciudad> V = vertices.proximo();
        if(V.dato().getNombre().equals(origen))
            vOrigen = V;
        if(V.dato().getNombre().equals(destino))
            vDestino = V;
    }
    
    if(vOrigen != null && vDestino != null){
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
        resolverRecursivo(vOrigen, vDestino, ciudades, marca, result, minFase);
    }
    return result;
}


private boolean resolverRecursivo(Vertice<Ciudad> vOrigen, Vertice<Ciudad> vDestino, Grafo<Ciudad> ciudades, boolean[] marca, ListaGenerica<Ciudad> result, int minFase){
    marca[vOrigen.posicion()] = true;
    
    if(vOrigen == vDestino){
        result.agregarFinal(vOrigen.dato());
        return true;
    }
    
    ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vOrigen);
    ady.comenzar();
    while(!ady.fin()){
        Arista<Ciudad> A = ady.proximo();
        Vertice<Ciudad> W = A.verticeDestino();
        if(!marca[W.posicion()] && A.peso() != 0){
            if(resolverRecursivo(W, vDestino, ciudades, marca, result, minFase)){
                result.agregarInicio(vOrigen.dato());
                return true;
            }
        }
    }
    return false;
}
}
