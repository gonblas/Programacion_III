package Ejercicio_4;

import java.util.Scanner;

public class Multiplos2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese tamaño del array: ");
        int n = in.nextInt();

        int[] mult = getMultiplos(n);

        for (int i = 0; i < n; i++)
            System.out.print(mult[i] + " ");
        System.out.println();
        in.close();
    }


    public static int[] getMultiplos(int n){
        int[] mult = new int[n];
        for(int i = 0, j = 5; i < n; i++, j+=5)
            mult[i] = j;
        return mult;
    }
}

