package PrograIII.ListGeneric;

public class Cola<T> {
    private ListaGenericaEnlazada<T> cola;

    public void encolar(T elem) {
        if (this.esVacia())
            cola = new ListaGenericaEnlazada<T>();
        cola.agregarFinal(elem);
    }

    public T desencolar() {
        if (!this.esVacia()) {
            T dato = cola.elemento(0);
            cola.eliminarEn(0);
            if(cola.tamanio()==0)
                cola = null;
            return dato;
        }
        return null;
    }

    public T tope(){
        if (!this.esVacia()) {
            T dato = cola.elemento(0);
            return dato;
        }
        return null;
    }

    public boolean esVacia(){
        return this.cola == null;
    }
}
