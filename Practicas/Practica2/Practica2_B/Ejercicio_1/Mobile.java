package Practica2_B.Ejercicio_1;

public abstract class Mobile{
    private String marca;
    private String os;
    private String modelo;
    private int costo;

    public Mobile(String marca, String os, String modelo, int costo) {
        this.marca = marca;
        this.os = os;
        this.modelo = modelo;
        this.costo = costo;
    }

    public Mobile() {
        
    }

    public String getMarca() {
        return marca;
    }

    public String getOs() {
        return os;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCosto() {
        return costo;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public abstract boolean equals(Mobile m);
    
    @Override
    public String toString() {
        return "\nMarca: " + marca + "\nSistema operativo: " +  os + "\nModelo: " + modelo + "\nCosto: " + costo;
    }

    }
    