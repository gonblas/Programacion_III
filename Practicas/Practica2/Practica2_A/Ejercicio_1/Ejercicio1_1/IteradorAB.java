package Ejercicio_1.Ejercicio1_1;


public class IteradorAB {
    
    public void iterarConFor(int a, int b) {
        for (int i = a; i <= b; i++)
            System.out.print(i + " ");
        System.out.println();
    }

    public void iterarConWhile(int a, int b) {
        while (a <= b) {
            System.out.print(a + " ");
            a++;
        }
        System.out.println();
    }

    public void recursivo(int a, int b) {
        if(a==b)
            System.out.print(b + " ");
        else{
            recursivo(a,b-1);
            System.out.print(b + " ");
        }
    }


    public static void main(String[] args) {
        IteradorAB messi = new IteradorAB();
        messi.iterarConFor(1, 10);
        messi.iterarConWhile(1, 15);
        messi.recursivo(1, 20);
        System.out.println();
    }
}