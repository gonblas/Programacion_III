package Practica2_B.Ejercicio_4;

import java.util.Scanner;

    public class Ejercicio4{
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            int[] a = { 1, 10, 19, 87, 11 };
            System.out.println(q2(a));
            in.close();

        }
    
        public static String q1(int[] a) {
            int min = 10000, max = -10000;
            double p = 0;
            for (int i : a) {
                if (i < min) {
                    min = i;
                } else if (i > max) {
                    max = i;
                }
                p *= i;
            }
            return "\nMinimo: " + min + "\nMaximo: " + max + "\nPromedio: " + p / a.length;
        }
        
        public static Resultado q2(int[] a) {
            int min = 10000, max = -10000;
            float p = 0;
            for (int i : a) {
                if (i < min) {
                    min = i;
                } else if (i > max) {
                    max = i;
                }
                p *= i;
            }
            Resultado x = new Resultado(p/a.length, max, min);
            return x;
        }
}
