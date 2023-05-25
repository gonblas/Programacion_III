package Practica2_B.Ejercicio_5;

import java.util.Scanner;

    public class Ejercicio5{
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Figura[] a = new Figura[3];
        a[0] = new Circulo("nashe", false, 0);
        a[1] = new Rectangulo("null", false, 2, 22);
        a[1] = new Cuadrado("null", false, 2);

        for (Figura i : a) {
            System.out.println(i.toString());
            System.out.println();
        }
        in.close();
    }
}