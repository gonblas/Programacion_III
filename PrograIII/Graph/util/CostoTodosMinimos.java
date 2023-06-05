package PrograIII.Graph.util;

public class CostoTodosMinimos implements Comparable<CostoTodosMinimos>{
    private int min;
    private int previo;
    private int caminos;

    public CostoTodosMinimos() {
        this.min = Integer.MAX_VALUE;
        this.previo = 0;
        this.caminos = 0;
    }

    public int getMin() {
        return min;
    }

    public int getPrevio() {
        return previo;
    }

    public int getCaminos() {
        return caminos;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setPrevio(int previo) {
        this.previo = previo;
    }

    public void setCaminos(int caminos) {
        this.caminos = caminos;
    }
    
    @Override
    public String toString() {
        return ("Costo minimo: " + min + ".\nVertice previo: " + previo + "·\nCaminos: " + caminos);
    }

    @Override
    public int compareTo(CostoTodosMinimos otro) {
        return Integer.compare(min, otro.getMin());
    }
}
