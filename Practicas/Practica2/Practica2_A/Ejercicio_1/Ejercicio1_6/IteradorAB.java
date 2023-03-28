package Practicas.Practica2.Practica2_A.Ejercicio_1.Ejercicio1_6;

public class IteradorAB {
    
    public void iterarConFor(int a, int b) {
        for (int i = b; i <= a; i++)
            System.out.print(i + " ");
        System.out.println();
    }

    public void iterarConWhile(int a, int b) {
        while (b <= a) {
            System.out.print(b + " ");
            b++;
        }
        System.out.println();
    }

    public void recursivo(int a, int b) {
        if(a==b)
            System.out.print(a + " ");
        else{
            recursivo(a-1,b);
            System.out.print(a + " ");
        }
    }


    public static void main(String[] args) {
        IteradorAB messi = new IteradorAB();
        messi.iterarConFor(10, 1);
        messi.iterarConWhile(15, 1);
        messi.recursivo(20, 1);
        System.out.println();
    }
}