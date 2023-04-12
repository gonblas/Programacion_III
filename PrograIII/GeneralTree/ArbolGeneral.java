package PrograIII.GeneralTree;

import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.ListaGenericaEnlazada;
import PrograIII.ListGeneric.Cola;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}
	
	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {
		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {
		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public int altura() {
		int nivel = 0;
		int max = Integer.MIN_VALUE;
			if (!this.tieneHijos()) {
				return nivel;
			}
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			while (!hijos.fin()) {
				nivel = hijos.proximo().altura() + 1;
				if (nivel > max) {
					max = nivel;
				}
			}
		if (max > nivel)
			return max;
		return nivel;
	}

	public Integer nivel(T dato) {
		int lvl = -1; 
		if (this.getDato() == dato) {
			return lvl+1;
		}
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				lvl = hijos.proximo().nivel(dato);
				if (lvl != -1) {
					return lvl + 1;
				}
			}
		}
		return lvl;
	}

	public int ancho() {
		if(!this.tieneHijos())
			return 1;
		ArbolGeneral<T> a = null;
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int max = -1, aux = 0;
		while (!cola.esVacia()) {
			a = cola.desencolar();
			if (a != null) {
				ListaGenerica<ArbolGeneral<T>> hijos = a.getHijos();
				hijos.comenzar();
				aux += hijos.tamanio();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
			else{ if(!cola.esVacia()){
					if(aux > max){
						max = aux;
					}
					cola.encolar(null);
					aux = 0;
				}
			}
			}
			return max;
		}

	public boolean include(T dato) {
		boolean flag = false;
		if (this.getDato() == dato) {
			flag = true;
		}
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && !flag) {
				flag = hijos.proximo().include(dato);
				if (flag)
					return true;
			}
		}
		return flag;
	}

	public void ImprimirPorNiveles() {
        ArbolGeneral<T> arbol = null;
        Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
        cola.encolar(this);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol != null) {
                System.out.print(arbol.getDato() + " ");
                if (arbol.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> l = arbol.getHijos();
                    l.comenzar();
                    while (!l.fin()) {
                        cola.encolar(l.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                System.out.println();
                cola.encolar(null);
            }
        }
    }
}