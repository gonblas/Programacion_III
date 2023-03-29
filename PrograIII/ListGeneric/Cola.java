package PrograIII.ListGeneric;

public class Cola<T> {
    private ListaGenericaEnlazada<T> cola;

    public Cola() {
        cola = new ListaGenericaEnlazada<>();
    }

    public void encolar(T elem) {
        cola.agregarFinal(elem);
    }

    public T desencolar() {
        T dato = cola.elemento(0);
        cola.eliminarEn(0);
        return dato;
    }

    public T tope(){
        T dato = cola.elemento(0);
        return dato;
    }

    public boolean esVacia(){
        return cola.esVacia();
    }
}
