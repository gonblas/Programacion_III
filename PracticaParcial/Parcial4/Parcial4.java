package PracticaParcial.Parcial4;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial4 {
    public ListaGenerica<String>resolver(Grafo<Sitio> sitios, String casa, String municipalidad){
        ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
        if(sitios == null || sitios.esVacio())
            return result;
        boolean[] marca = new boolean[sitios.listaDeVertices().tamanio()];
        ListaGenerica<Vertice<Sitio>> vertices = sitios.listaDeVertices();
        Vertice<Sitio> vOrigen = null, vDestino = null;
        vertices.comenzar();
        while((!vertices.fin())&&(vOrigen == null || vDestino == null)){
            Vertice<Sitio> V = vertices.proximo();
            if(V.dato().getNombre().equals(casa))
                vOrigen = V;
            if(V.dato().getNombre().equals(municipalidad))
                vDestino = V;
        }
        
        if(vOrigen != null && vDestino != null){
            resolverRecursivo(vOrigen, vDestino, sitios, marca, result);
        }
        return result;
    }
    
    private boolean resolverRecursivo(Vertice<Sitio> vOrigen, Vertice<Sitio> vDestino, Grafo<Sitio> sitios, boolean[] marca, ListaGenerica<String> result){
        marca[vOrigen.posicion()] = true;
        
        if(vOrigen.dato().getMafia()){
            return false;
        }
        
        if(vOrigen == vDestino){
            result.agregarFinal(vDestino.dato().getNombre());
            return true;
        }
    
        ListaGenerica<Arista<Sitio>> ady = sitios.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Sitio> A = ady.proximo();
            if (!marca[A.verticeDestino().posicion()] && A.peso() == 0) { //Llamo recursivamente si no esta marcado y si no hay mafia
                if (resolverRecursivo(A.verticeDestino(), vDestino, sitios, marca, result)) {
                    result.agregarInicio(vOrigen.dato().getNombre());
                    return true;
                }
            }
        }
        return false;
    }
}
