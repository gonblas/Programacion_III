package Practica2_B.Ejercicio_1;

public class Tablet extends Mobile {
    private int pulgadas;

    public Tablet(String marca, String os, String modelo, int costo, int pulgadas) {
        super(marca, os, modelo, costo);
        this.pulgadas = pulgadas;
    }

    public Tablet() {

    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public boolean equals(Mobile m) {
        if (m != null && m instanceof Tablet) {
            Tablet sp = (Tablet) m;
            if (sp.getMarca() == getMarca() && sp.getOs() == getOs() && sp.getModelo() == getModelo()
                    && sp.getCosto() == getCosto() && sp.getPulgadas() == pulgadas)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPulgadas: " + pulgadas;
    }
}
