package PracticaParcial.Parcial16;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial16 {

    public ListaGenerica<Integer> resolver(Grafo<Integer> jugadores, Integer origen, Integer destino){
    ListaGenerica<Integer> result = new ListaGenericaEnlazada<Integer>();
    if(jugadores == null || jugadores.esVacio())
        return result;
    
    ListaGenerica<Vertice<Integer>> vertices = jugadores.listaDeVertices();
    vertices.comenzar();
    Vertice<Integer> vOrigen = null, vDestino = null;
    while((!vertices.fin()&&(vOrigen == null || vDestino == null))){
        Vertice<Integer> V = vertices.proximo();
        if(V.dato() == origen)
            vOrigen = V;
        if(V.dato() == destino)
            vDestino = V;
    }
    
    if(vOrigen != null && vDestino != null){
        boolean[] marca = new boolean[jugadores.listaDeVertices().tamanio()];
        ListaGenerica<Integer> actual = new ListaGenericaEnlazada<Integer>();
        resolverRecursivo(vOrigen, vDestino, jugadores, marca, actual, 1, result);
    }
    return result;
}


private double resolverRecursivo(Vertice<Integer> vOrigen, Vertice<Integer> vDestino, Grafo<Integer> jugadores, boolean[] marca, ListaGenerica<Integer> actual, double probAct, ListaGenerica<Integer> result) {
    double probRes = -1;
    marca[vOrigen.posicion()] = true;
    actual.agregarFinal(vOrigen.dato());
    
    if(vOrigen == vDestino){
        if(probRes < probAct){
            probRes = probAct;
            copiarLista(actual, result);
        }
    }
    else{
        ListaGenerica<Arista<Integer>> ady = jugadores.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while(!ady.fin()){
            Arista<Integer> A = ady.proximo();
            if(!marca[A.verticeDestino().posicion()]){
                double aux = resolverRecursivo(A.verticeDestino(), vDestino, jugadores, marca, actual,
                        probAct * ((double) A.peso() / 100), result);
                if(aux > probRes)
                    probRes = aux;
            }
        }
    }
    
    marca[vOrigen.posicion()] = false;
    actual.eliminarEn(actual.tamanio() - 1);
    return probRes;
}


private void copiarLista(ListaGenerica<Integer> actual, ListaGenerica<Integer> result){
    result.comenzar();
    while(!result.fin()){
        result.eliminar(result.proximo());
    }
    
    actual.comenzar();
    while(!actual.fin()){
        result.agregarFinal(actual.proximo());
    }
}

}
