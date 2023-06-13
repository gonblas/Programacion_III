package PracticaParcial.Parcial3;

import PracticaParcial.Parcial1.Ciudad;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial3 {
    public ListaGenerica<ListaGenerica<Ciudad>> resolver(Grafo<Ciudad> ciudades, String origen, String destino, String pasandoPor){
        ListaGenerica<ListaGenerica<Ciudad>> result = new ListaGenericaEnlazada<ListaGenerica<Ciudad>>();
        if((ciudades == null) || (ciudades.esVacio()))
            return result;
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
        ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
        Vertice<Ciudad> vOrigen = null, vDestino = null, vPasandoPor = null;
        vertices.comenzar();
        while((!vertices.fin())&&(vOrigen == null || vDestino == null || vPasandoPor == null)){
            Vertice<Ciudad> V = vertices.proximo();
            if(V.dato().getNombre().equals(origen))
                vOrigen = V;
            if(V.dato().getNombre().equals(destino))
                vDestino = V;
            if(V.dato().getNombre().equals(pasandoPor))
                vPasandoPor = V;
        }
        
        if(vOrigen != null && vDestino != null && vPasandoPor != null){
            ListaGenerica<Ciudad> actual = new ListaGenericaEnlazada<Ciudad>();
            resolverRecursivo(vOrigen, vDestino, vPasandoPor.dato(), ciudades, marca, actual, result);
        }
        return result;
    }
    
    private void resolverRecursivo(Vertice<Ciudad> vOrigen, Vertice<Ciudad> vDestino, Ciudad pasandoPor, Grafo<Ciudad> ciudades, boolean[] marca, ListaGenerica<Ciudad> actual, ListaGenerica<ListaGenerica<Ciudad>> result){
        marca[vOrigen.posicion()] = true;
        actual.agregarFinal(vOrigen.dato());
        if(vOrigen == vDestino && actual.incluye(pasandoPor)){
            result.agregarFinal(actual.clonar());
        }
        else {
            ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vOrigen);
            ady.comenzar();
            while(!ady.fin()){
                Arista<Ciudad> A = ady.proximo();
                if(!marca[A.verticeDestino().posicion()] && A.peso() == 1){ //peso=1 -> Habilitado
                    resolverRecursivo(A.verticeDestino(), vDestino, pasandoPor, ciudades, marca, actual, result);
                }
            }
        }
        marca[vOrigen.posicion()] = false;
        actual.eliminarEn(actual.tamanio()-1);
    }
}
