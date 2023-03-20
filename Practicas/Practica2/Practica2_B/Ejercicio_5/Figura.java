package Practica2_B.Ejercicio_5;

public abstract class Figura {
  private String color;
  private boolean relleno;
  
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean getRelleno() {
    return relleno;
  }

  public void setRelleno(boolean relleno) {
    this.relleno = relleno;
  }
  
  public Figura(String color, boolean relleno) {
    this.color = color;
    this.relleno = relleno;
  }
  
  @Override
  public String toString() {
    return "Color: " + this.color + " \nRelleno: " + this.relleno;
  }

  public abstract double getArea();
  public abstract double getPerimetro();
}
