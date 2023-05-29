package Practicas.Practica7.Ejercicio6;

import PrograIII.Graph.Grafo;
import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.ListaGenericaEnlazada;
import PrograIII.Graph.Vertice;
import PrograIII.Graph.Arista;



public class Mapa {
    private Grafo<String> grafo;

    Mapa(Grafo<String> grafo) {
        this.grafo = grafo;
    }
    
    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (grafo.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) //Si la ciudad1 se encuentra en el grafo
            devolverCamino(i, grafo, marca, l, ciudad2);
        return l;
    }
    
    private boolean devolverCamino(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l, String ciudad2){
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(ciudad2)) { //Agrego si encuentro la ciudad2
            l.agregarFinal(v.dato());
            return true;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                if (devolverCamino(j, grafo, marca, l, ciudad2)) { //Si se encontro el camino
                    l.agregarInicio(v.dato());
                    return true;
                }
            }
        }
        return false;
    }
    
    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (grafo.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) //Si la ciudad se encuentra en el grafo
            devolverCaminoExceptuando(i, grafo, marca, l, ciudades, ciudad2);
        return l;
    }

    private boolean devolverCaminoExceptuando(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l, ListaGenerica<String> ciudades, String ciudad2){
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (ciudades.incluye(v.dato())) //No recorro si paso por una ciudad prohibida
            return false;

        if (v.dato().equals(ciudad2)) { //Agrego si encuentro la ciudad2
            l.agregarFinal(v.dato());
            return true;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                if (devolverCaminoExceptuando(j, grafo, marca, l, ciudades, ciudad2)) { //Si se encontro el camino
                    l.agregarInicio(v.dato());
                    return true;
                }
            }
        }
        return false;
    }
    
    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (grafo.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) //Si la ciudad se encuentra en el grafo
            caminoMasCorto(i, grafo, ciudad2, marca, l, result);
        return result;
    }

    private void caminoMasCorto(int i, Grafo<String> grafo, String ciudad2, boolean[] marca, ListaGenerica<String> l, ListaGenerica<String> result) {
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        marca[i] = true;
        l.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if ((result.tamanio() == 0) || (l.tamanio() < result.tamanio())) { //Si se refiere a camino mas corto como menor cant. de ciudades
                Copia(result, l);
            }
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                int j = ady.proximo().verticeDestino().posicion();
                if (!marca[j]) {
                    caminoMasCorto(j, grafo, ciudad2, marca, l, result);
                    marca[j] = false;
                    l.eliminarEn(l.tamanio()-1);
                }
            }
        }
    }
    
    private void Copia(ListaGenerica<String> result, ListaGenerica<String> l) {
        for(int i = result.tamanio(); i >= 0;i--) 
        result.eliminarEn(i);
        l.comenzar();
        while (!l.fin()) {
            result.agregarFinal(l.proximo());
        }
    }
    

    //Posiblemente este mal
    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> result = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (grafo.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) //Si la ciudad se encuentra en el grafo
            caminoSinCargarCombustible(i, grafo, ciudad2, marca, l, result, tanqueAuto);
        return result;
    }

    private void caminoSinCargarCombustible(int i, Grafo<String> grafo, String ciudad2, boolean[] marca, ListaGenerica<String> l, ListaGenerica<String> result, int tanqueAuto) {
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        marca[i] = true;
        l.agregarFinal(v.dato());
        if(tanqueAuto<0)
            return;
        if (v.dato().equals(ciudad2)) {
            if ((result.tamanio() == 0) || (l.tamanio() < result.tamanio())) { 
                Copia(result, l);
            }
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> a = ady.proximo();         
                int j = a.verticeDestino().posicion();
                if (!marca[j]) {
                    caminoSinCargarCombustible(j, grafo, ciudad2, marca, l, result, tanqueAuto-a.peso());
                    marca[j] = false;
                    l.eliminarEn(l.tamanio()-1);
                }
            }
        }
    }
    

    //Esta mal (anda bien pero O(∞))
    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int
    tanqueAuto) {
        Resultado<String> aux = new Resultado<String>(new ListaGenericaEnlazada<>(), 0);
        Resultado<String> result = new Resultado<String>(new ListaGenericaEnlazada<>(), 0);
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (grafo.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) //Si la ciudad1 se encuentra en el grafo
            caminoConMenorCargaDeCombustible(i, grafo, ciudad2, marca, aux, result, tanqueAuto, tanqueAuto);
        return result.getList();
    }

    private void caminoConMenorCargaDeCombustible(int i, Grafo<String> grafo, String ciudad2, boolean[] marca, Resultado<String> aux, Resultado<String> result, int tanqueAuto, int tanqueAct) {
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        marca[i] = true;
        aux.getList().agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if (aux.getCant() < result.getCant()) {
                result.copyList(aux.getList());
                result.setCant(aux.getCant());
            }
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> a = ady.proximo();         
                int j = a.verticeDestino().posicion();
                if (!marca[j]) {
                    if (tanqueAct - a.peso() < 0) {
                        aux.setCant(aux.getCant() + 1);
                        caminoConMenorCargaDeCombustible(j, grafo, ciudad2, marca, aux, result, tanqueAuto, tanqueAuto-a.peso());
                    }
                    else
                        caminoConMenorCargaDeCombustible(j, grafo, ciudad2, marca, aux, result, tanqueAuto, tanqueAct-a.peso());
                    marca[j] = false;
                    aux.getList().eliminarEn(aux.getList().tamanio()-1);
                }
            }
        }
    }
}
