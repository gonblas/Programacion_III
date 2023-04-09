package PrograIII.BinaryTree;

import PrograIII.ListGeneric.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());
	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		int nivel = 0, nodos = 0;
		cola.encolar(null);

		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if(arbol.tieneHijoIzquierdo()){
					cola.encolar(arbol.getHijoIzquierdo());
					nodos++;
				}
				if(arbol.tieneHijoDerecho()){
					cola.encolar(arbol.getHijoDerecho());
					nodos++;
				}
			}
			else if(!cola.esVacia()){
				if (nodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					nodos = 0;
				}
				else
					return false;
			}
		}
		return true;
	}

	public boolean esCompleto() {
        // si el arbol es vacio o es hoja es completo
        if (this.esVacio()) {
            return true;
        }
        Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
        cola.encolar(this);
        boolean flag = false;
        ArbolBinario<T> arbol;
        while (!cola.esVacia()) {
            // desencolo el arbol
            arbol = cola.desencolar();
            // si hemos encotrado un nodo no lleno antes y el nodo actual no es hoja
            // el arbol no es completo
            if (flag && (!arbol.esHoja()))
                return false;

            // si el nodo actual no tiene hijo izquierdo y tiene hijo derecho
            // el arbol no es completo
            if (!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho())
                return false;

            // si el nodo actual tiene hijo izquierdo lo encolo
            if (arbol.tieneHijoIzquierdo())
                cola.encolar(arbol.getHijoIzquierdo());
            else
                flag = true;

            // si el nodo actual tiene hijo derecho lo encolo
            if (arbol.tieneHijoDerecho())
                cola.encolar(arbol.getHijoDerecho());
            else
                flag = true;

        }
        return true;
    }

	// imprime el arbol en preorden  
	public void printPreorden() {
		if (!this.esVacio()) {
		    System.out.print(this.getDato() + " ");
		if (this.tieneHijoIzquierdo()) 
			this.hijoIzquierdo.printPreorden();
		if (this.tieneHijoDerecho()) 
			this.hijoDerecho.printPreorden();
		}
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if (!this.esVacio()) {
			if (this.tieneHijoIzquierdo()) 
				this.hijoIzquierdo.printInorden();
			System.out.print(this.getDato() + " ");
			if (this.tieneHijoDerecho()) 
				this.hijoDerecho.printInorden();
		}
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if (!this.esVacio()) {
			if (this.tieneHijoIzquierdo()) {
				this.hijoIzquierdo.printPostorden();
			}
			if (this.tieneHijoDerecho()) {
				this.hijoDerecho.printPostorden();
			}
			System.out.print(this.getDato() + " ");
		}
	}


	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.print(arbol.getDato() + " ");
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			} else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
		System.out.println();
	}

	// public ListaGenerica<T> frontera() {
	// 	ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
	// 	if (!this.esHoja()) {
	// 		if (this.tieneHijoIzquierdo()) {
	// 			ListaGenerica<T> hijosIzquierdo = this.hijoIzquierdo.frontera();
	// 			hijosIzquierdo.comenzar();
	// 			while (!hijosIzquierdo.fin()) {
	// 				l.agregarFinal(hijosIzquierdo.proximo());
	// 			}
	// 		}
	// 		if (this.tieneHijoDerecho()) {
	// 			ListaGenerica<T> hijosDerecho = this.hijoDerecho.frontera();
	// 			hijosDerecho.comenzar();
	// 			while (!hijosDerecho.fin()) {
	// 				l.agregarFinal(hijosDerecho.proximo());
	// 			}
	// 		}
	// 	} else {
	// 		l.agregarFinal(dato);
	// 	}
	// 	return l;
	// }

	public ListaGenerica<T> frontera() {
		ListaGenericaEnlazada<T> l = new ListaGenericaEnlazada<T>();
		fronteraRecursivo(l);
		return l;
	}

	private void fronteraRecursivo(ListaGenericaEnlazada<T> l) {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().fronteraRecursivo(l);
		}
		if(this.esHoja()){
			l.agregarFinal(this.dato);
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().fronteraRecursivo(l);
		}
	}
	
	public int contarHojas() {
		int cont = 0;
		if (!this.esHoja()) {
			if (this.tieneHijoIzquierdo()) {
				cont += hijoIzquierdo.contarHojas();
			}
			if (this.tieneHijoDerecho()) {
				cont += hijoDerecho.contarHojas();
			}
		}
		else {
			return 1;
		}
		return cont;
	}

}
