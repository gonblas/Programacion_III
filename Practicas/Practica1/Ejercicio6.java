package Practicas.Practica1;

import java.util.Scanner;

    public class Ejercicio6{
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            
            double fahrenheit;
            System.out.println("Ingrese una temperatura en grados Fahrenheit: ");
            fahrenheit = in.nextDouble();
            System.out.println("Temperatura en grados Celcius: " + calcularCelcius(fahrenheit));
            in.close();
        }
    
    public static double calcularCelcius(double F) {
        return ((F-32)*5.0/9);
    }
}
