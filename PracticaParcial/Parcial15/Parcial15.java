package PracticaParcial.Parcial15;

import PracticaParcial.Parcial13.Ciudad;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial15 {
    public ListaGenerica<String> resolver(Grafo<Ciudad> ciudades, String origen, String destino){
        ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
    if(ciudades == null || ciudades.esVacio())
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
        boolean[] recorrido = new boolean[ciudades.listaDeVertices().tamanio()];
        resolverRecursivo(vOrigen, vDestino, ciudades, marca, recorrido, result);
    }
    return result;
}

private boolean resolverRecursivo(Vertice<Ciudad> vOrigen, Vertice<Ciudad> vDestino, Grafo<Ciudad> ciudades, boolean[] marca, boolean[] recorrido, ListaGenerica<String> result){
    marca[vOrigen.posicion()] = true;
    if(!recorrido[vOrigen.posicion()])
        result.agregarFinal(vOrigen.dato().getNombre());
    boolean flag = false;  //Si se encontro el camino o no
    
    if(vOrigen == vDestino){
        if (!recorrido[vOrigen.posicion()]) {
            recorrido[vOrigen.posicion()] = true;
        }
        flag = true;
    }
    else{
        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while(!ady.fin()){
            Arista<Ciudad> A = ady.proximo();
            Vertice<Ciudad> W = A.verticeDestino();
            if (!marca[W.posicion()] && A.peso() != 0 && W.dato().getFase() > 1) {
                if (resolverRecursivo(W, vDestino, ciudades, marca, recorrido, result)) {
                    recorrido[vOrigen.posicion()] = true;
                    flag = true;
                }
            }
        }
    }
    marca[vOrigen.posicion()] = false;
    if(!flag){
        result.eliminarEn(result.tamanio()-1);
    }
    return flag;
}
}
