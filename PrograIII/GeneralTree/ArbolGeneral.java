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
		if (!this.tieneHijos()) { //Retorno el nivel 
			return nivel;
		}
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) { //Recorro y llamo con los hijos
			nivel = hijos.proximo().altura() + 1; //Recibo el nivel de los hijos como 1 mayor al actual
			if (nivel > max) { //Maximos
				max = nivel;
			}
		}
		if (max > nivel) //Retorno el mayor
			return max;
		return nivel;
	}

	public Integer nivel(T dato) {
		int lvl = -1;
		if (this.getDato() == dato) {
			return lvl + 1;
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
		if (!this.tieneHijos())
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
				aux += hijos.tamanio(); //Tomo el tamaño de los hijos que sera el ancho del siguiente nivel
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else {
				if (!cola.esVacia()) {
					if (aux > max) { //Maximos
						max = aux;
					}
					cola.encolar(null);
					aux = 0;
				}
			}
		}
		return max;
	}

	// public boolean include(T dato) {
	// 	boolean flag = false;
	// 	if (this.getDato() == dato) { //Si el dato esta incluido
	// 		flag = true;
	// 	}
	// 	if (this.tieneHijos()) { //Llamo con los hijos
	// 		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
	// 		hijos.comenzar();
	// 		while (!hijos.fin() && !flag) { //Mientras no encontremos el dato y tenga hijos
	// 			flag = hijos.proximo().include(dato);
	// 			if (flag) //Si lo encontramos
	// 				return true;
	// 		}
	// 	}
	// 	return flag;
	// }

	public boolean include(T dato) {
		boolean flag = false;
		if (this.getDato() == dato) { //Si el dato esta incluido
			return true;
		}
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		while (!hijos.fin() && !flag) //Mientras no encontremos el dato y tenga hijos
			flag = hijos.proximo().include(dato);
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

	public void RecorridoPorNiveles() {
		ArbolGeneral<T> arbol = null; //Creo un arbol aux
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>(); //Creo una cola de arboles generales
		cola.encolar(this); //Encolo la raiz
		cola.encolar(null); //Indico que el nivel de la raiz finalizo
		while (!cola.esVacia()) { //Recorro mientras la cola no esta vacia
			arbol = cola.desencolar(); //Desencolo un nodo del actual nivel
			if (arbol != null) {
				//Proceso el nodo actual
				if (arbol.tieneHijos()) { //Encolo sus hijos
					ListaGenerica<ArbolGeneral<T>> l = arbol.getHijos();
					l.comenzar();
					while (!l.fin()) {
						cola.encolar(l.proximo());
					}
				}
			} else if (!cola.esVacia()) { //Si la cola no esta vacia
				//Realizo algun tipo de comparacion para establecer max o min, o terminar el recorrido
				cola.encolar(null); //Indico que finalizo un nivel
			}
		}
	}
}