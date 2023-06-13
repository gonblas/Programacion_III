package PracticaParcial.Parcial7;

import PrograIII.GenericList.Cola;
import PrograIII.GenericList.ListaGenerica;
import PrograIII.GenericList.ListaGenericaEnlazada;
import PrograIII.Graph.Arista;
import PrograIII.Graph.Grafo;
import PrograIII.Graph.Vertice;

public class Parcial7 {

    public ListaGenerica<Persona> resolver(Grafo<Persona> grafo, Persona empleado, int gradoMax) {
        ListaGenerica<Persona> result = new ListaGenericaEnlazada<Persona>();
        if (grafo == null || grafo.esVacio() || gradoMax < 0 || empleado.getJubilado())
            return result;
        ListaGenerica<Vertice<Persona>> vertices = grafo.listaDeVertices();
        Vertice<Persona> vEmpleado = null;
        vertices.comenzar();
        while (!vertices.fin() && vEmpleado == null) {
            Vertice<Persona> V = vertices.proximo();
            if (V.dato().getNombre().equals(empleado.getNombre()) && V.dato().getDomicilio().equals(empleado.getDomicilio()))
                vEmpleado = V;
        }

        if (vEmpleado == null)
            return result;
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        Cola<Vertice<Persona>> cola = new Cola<Vertice<Persona>>();
        cola.encolar(vEmpleado);
        cola.encolar(null);
        int gradoAct = 0;
        while (!cola.esVacia()) {
            Vertice<Persona> vActual = cola.desencolar();
            if (vActual != null) {
                ListaGenerica<Arista<Persona>> ady = grafo.listaDeAdyacentes(vActual);
                ady.comenzar();
                while (!ady.fin()) {
                    Vertice<Persona> vAdy = ady.proximo().verticeDestino();
                    if (!marca[vAdy.posicion()]) {
                        marca[vAdy.posicion()] = true;
                        cola.encolar(vAdy);
                        if ((vAdy.dato().getJubilado()) && (!vAdy.dato().getCobro())) { //Si es jubilado y no cobro
                            result.agregarFinal(vAdy.dato());
                            if (result.tamanio() == 40)
                                return result;
                        }
                    }
                }
            } else {
                if (!cola.esVacia()) {
                    gradoAct++;
                    if (gradoAct+1 == gradoMax)
                        return result;
                    cola.encolar(null);
                }
            }
        }
        return result;
    }
}
