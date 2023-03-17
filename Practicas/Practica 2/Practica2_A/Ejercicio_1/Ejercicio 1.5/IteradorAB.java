public class IteradorAB{
    public static void main(String[] args) {
        iterarConFor(1, 10);
        System.out.println();
        iterarConWhile(1, 15);
        System.out.println();
        recursivo(1, 20);
        System.out.println();
    }

    public static void iterarConFor(int a, int b) {
        for (int i = a; i <= b; i++)
            System.out.print(i + " ");
    }

    public static void iterarConWhile(int a, int b) {
        while (a <= b) {
            System.out.print(a + " ");
            a++;
        }
    }

    public static void recursivo(int a, int b) {
        if(a==b)
            System.out.print(b + " ");
        else{
            recursivo(a,b-1);
            System.out.print(b + " ");
        }
    }
}