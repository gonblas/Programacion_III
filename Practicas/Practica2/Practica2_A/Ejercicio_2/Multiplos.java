package Ejercicio_2;

public class Multiplos{
    public static void main(String[] args) {

        int[] mult = getMultiplos(10);

        for (int i = 0; i < 10; i++)
            System.out.print(mult[i] + " ");
        System.out.println();

    }


    public static int[] getMultiplos(int n){
        
        int[] mult = new int[n];
        for(int i = 0, j = 5; i < n; i++, j+=5)
            mult[i] = j;
    
        return mult;
    }
}

