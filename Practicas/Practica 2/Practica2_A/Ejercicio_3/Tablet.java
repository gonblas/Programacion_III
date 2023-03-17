package Ejercicio_3;

public class Tablet {
    private String marca;
    private String os;
    private String modelo;
    private double costo;
    private float pulgadas;

    public Tablet(String marca, String os, String modelo, double costo, float pulgadas) {
        this.marca = marca;
        this.os = os;
        this.modelo = modelo;
        this.costo = costo;
        this.pulgadas = pulgadas;
    }

    public Tablet() {
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

    public double getCosto() {
        return costo;
    }

    public float getPulgadas() {
        return pulgadas;
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

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "\n Marca: " + marca + "\n Sistema Operativo: " + os + "\n Modelo: " + modelo + "\n Costo: " + costo + "\n Pulgadas: " + pulgadas;
    }
}
