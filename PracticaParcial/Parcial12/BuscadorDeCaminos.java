package PracticaParcial.Parcial12;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class BuscadorDeCaminos {
    public ListaGenerica<String> caminoDistanciaMaxima(Grafo<String> ciudades, String origen, String destino, int distanciaMaxima){
    ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
    if(ciudades == null || ciudades.esVacio() || distanciaMaxima < 0)
        return result;
    ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
    vertices.comenzar();
    Vertice<String> vOrigen = null, vDestino = null;
    while((!vertices.fin() && (vOrigen == null || vDestino == null))){
        Vertice<String> V = vertices.proximo();
        if(V.dato().equals(origen))
            vOrigen = V;
        if(V.dato().equals(destino))
            vDestino = V;
    }
    
    if(vOrigen != null && vDestino != null){
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
        resolverRecursivo(vOrigen, vDestino, ciudades, marca, result, distanciaMaxima);
    }
    return result;
}


private boolean resolverRecursivo(Vertice<String> vOrigen, Vertice<String> vDestino, Grafo<String> ciudades, boolean[] marca, ListaGenerica<String> result, int distanciaMaxima){
    marca[vOrigen.posicion()] = true;
    
    if(vOrigen == vDestino){
        result.agregarFinal(vOrigen.dato());
        return true;
    }
    else{
        ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while(!ady.fin()){
            Arista<String> A = ady.proximo();
            if(!marca[A.verticeDestino().posicion()] && A.peso()<= distanciaMaxima){
                if (resolverRecursivo(A.verticeDestino(), vDestino, ciudades, marca, result, distanciaMaxima)) {
                    result.agregarInicio(vOrigen.dato());
                    return true;
                }
            }
        }
    }
    
    marca[vOrigen.posicion()] = false;
    return false;
}
}
