package Practica2_B.Ejercicio_1;

public class SmartPhone extends Mobile {
    private int numero;

    public SmartPhone(String marca, String os, String modelo, int costo, int numero){
        super(marca, os, modelo, costo);
        this.numero = numero;
    }

    public SmartPhone() {
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Mobile m) {
        if (m != null && m instanceof SmartPhone) {
            SmartPhone sp = (SmartPhone) m;
            if(sp.getMarca() == getMarca()  && sp.getOs() == getOs() && sp.getModelo() == getModelo() && sp.getCosto() == getCosto() && sp.getNumero() == numero)
                return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nNumero: " + numero;
    }
    
}