package Practica2_B.Ejercicio_1;
import java.util.Scanner;

    public class Ejercicio1{
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        SmartPhone obj1 = new SmartPhone("Hola", "123", "678", 10, 1);

        SmartPhone obj2 = new SmartPhone("Hola", "123", "678", 10, 1);

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());

        System.out.println(obj1.equals(obj2));
        
    }
}