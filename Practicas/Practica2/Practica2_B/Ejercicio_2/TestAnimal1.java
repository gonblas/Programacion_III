package Practica2_B.Ejercicio_2;

public class TestAnimal1 {
    public static void main(String[] args) {
    Animal donGato = new Gato();
    donGato.saludo();
    Animal benji = new Perro();
    benji.saludo();
    Animal lassie = new PerroGrande();
    lassie.saludo();
    }
}