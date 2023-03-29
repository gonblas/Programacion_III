package PrograIII.ListGeneric;

public class Pila<T> {
    private ListaGenericaEnlazada<T> pila;
    
    public void apilar(T elem) {
        if(this.esVacia())
            pila = new ListaGenericaEnlazada<T>();
        pila.agregarInicio(elem);
    }

    public T desapilar() {
        if (!this.esVacia()) {
            T dato = pila.elemento(0);
            pila.eliminarEn(0);
            if(pila.tamanio()==0)
                pila = null;
            return dato;
        }
        
        return null;
    }
    
    public T tope() {
        if (!this.esVacia()) {
            T dato = pila.elemento(0);
            return dato;
        }
        return null;
    }
    
    public boolean esVacia() {
        return this.pila == null;
    }
}
