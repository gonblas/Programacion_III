package PracticaParcial.Parcial9;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class BuscadorDeCaminos {
    private Grafo<String> bosque;

    public BuscadorDeCaminos(Grafo<String> bosque) {
        this.bosque = bosque;
    }

    public BuscadorDeCaminos() {
        this.bosque = null;
    }

    public ListaGenerica<ListaGenerica<String>> recorridosMasSeguros(String casaCaperucita, String casaAbuela){
    ListaGenerica<ListaGenerica<String>> result = new ListaGenericaEnlazada<ListaGenerica<String>>();
    if(bosque == null || bosque.esVacio())
        return result;
    ListaGenerica<Vertice<String>> vertices = bosque.listaDeVertices();
    vertices.comenzar();
    Vertice<String> vOrigen = null, vDestino = null;
    while((!vertices.fin())&&(vOrigen == null || vDestino == null)){
        Vertice<String> V = vertices.proximo();
        if(V.dato().equals(casaCaperucita))
            vOrigen = V;
        if(V.dato().equals(casaAbuela))
            vDestino = V;
    }
    
    if(vOrigen != null && vDestino != null){
        boolean[] marca = new boolean[bosque.listaDeVertices().tamanio()];
        ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();
        resolverRecursivo(vOrigen, vDestino, marca, actual, result);
    }
    return result;
}

private void resolverRecursivo(Vertice<String> vOrigen, Vertice<String> vDestino, boolean[] marca, ListaGenerica<String> actual, ListaGenerica<ListaGenerica<String>> result){
    marca[vOrigen.posicion()] = true;
    actual.agregarFinal(vOrigen.dato());
    
    if(vOrigen == vDestino){
        result.agregarFinal(actual.clonar());
    }
    else{
        ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while(!ady.fin()){
            Arista<String> A = ady.proximo();
            if(!marca[A.verticeDestino().posicion()] && A.peso() < 5)
                resolverRecursivo(A.verticeDestino(), vDestino, marca, actual, result);
        }
    }

    actual.eliminarEn(actual.tamanio()-1);
    marca[vOrigen.posicion()] = false;
}
}
