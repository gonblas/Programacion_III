import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial5<T> {
    public ListaGenerica<ListaGenerica<T>> resolver(Grafo<T> grafo){
    ListaGenerica<ListaGenerica<T>> result = new ListaGenericaEnlazada<ListaGenerica<T>>();
    if(grafo == null || grafo.esVacio())
        return result;
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    ListaGenerica<T> actual = new ListaGenericaEnlazada<T>();
    while(!vertices.fin()){
        resolverRecursivo(vertices.proximo(), grafo, marca, actual, result, 10);
    }
    return result;
}

private void resolverRecursivo(Vertice<T> vOrigen, Grafo<T> grafo, boolean[] marca, ListaGenerica<T> actual, ListaGenerica<ListaGenerica<T>> result, int peso){
    marca[vOrigen.posicion()] = true;
    actual.agregarFinal(vOrigen.dato());
    if(peso == 0){
        result.agregarFinal(actual.clonar());
    }
    else{
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while(!ady.fin()){
            Arista<T> A = ady.proximo();
            if(!marca[A.verticeDestino().posicion()] && peso - A.peso() >= 0){
                resolverRecursivo(A.verticeDestino(), grafo, marca, actual, result, peso - A.peso());
            }
        }
    }
    
    actual.eliminarEn(actual.tamanio()-1);
    marca[vOrigen.posicion()] = false;
}
}
