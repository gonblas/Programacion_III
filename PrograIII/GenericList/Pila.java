package PrograIII.GenericList;

public class Pila<T> {
    private ListaGenericaEnlazada<T> pila;

    public Pila() {
        pila = new ListaGenericaEnlazada<>();
    }
    
    public void apilar(T elem) {
        pila.agregarInicio(elem);
    }

    public T desapilar() {
        T dato = pila.elemento(0);
        pila.eliminarEn(0);
        return dato;
    }
    
    public T tope() {
        T dato = pila.elemento(0);
    return dato;
    }
    
    public boolean esVacia() {
        return pila.esVacia();
    }
}
