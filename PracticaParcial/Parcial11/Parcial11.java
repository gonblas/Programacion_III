package PracticaParcial.Parcial11;

import PrograIII.GenericList.ListaGenerica;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial11 {
    public int resolver(Grafo<Ciudad> ciudades, String origen, String destino, int maxControles){
    if(ciudades == null || ciudades.esVacio() || maxControles < 0)
        return 0;
    
    ListaGenerica<Vertice<Ciudad>> vertices = ciudades.listaDeVertices();
    vertices.comenzar();
    Vertice<Ciudad> vOrigen = null, vDestino = null;
    while((!vertices.fin()) && (vOrigen == null || vDestino == null)){
        Vertice<Ciudad> V = vertices.proximo();
        if(V.dato().getNombre().equals(origen))
            vOrigen = V;
        if(V.dato().getNombre().equals(destino))
            vDestino = V;
    }
    
    if(vOrigen != null && vDestino != null){
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
        return resolverRecursivo(vOrigen, vDestino, ciudades, marca, maxControles, 0, -1);
    }
    return 0;
}

private int resolverRecursivo(Vertice<Ciudad> vOrigen, Vertice<Ciudad> vDestino, Grafo<Ciudad> ciudades, boolean[] marca, int maxControles, int tiempoAct, int tiempoMax){
    marca[vOrigen.posicion()] = true;
    tiempoAct += vOrigen.dato().getMaxDias();
    if(vOrigen.dato().getNombre().equals(vDestino.dato().getNombre())){
        if(tiempoAct > tiempoMax)
            tiempoMax = tiempoAct;
    }else{
        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(vOrigen);
        ady.comenzar();
        while(!ady.fin()){
            Arista<Ciudad> A = ady.proximo();
            if(!marca[A.verticeDestino().posicion()] && A.peso()<=maxControles){
                int aux = resolverRecursivo(A.verticeDestino(), vDestino, ciudades, marca, maxControles, tiempoAct, tiempoMax);
                if(aux > tiempoMax){
                    tiempoMax = aux; 
                }
            }
        }
    }
    
    marca[vOrigen.posicion()] = false;
    return tiempoMax;
}

}
