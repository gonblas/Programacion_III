
import java.util.Scanner;

    public class prueba{
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            List l = new List();
            String name;

            for(int i = 0; i < 10; i++){
                System.out.print("Ingrese un nombre: ");
                name = in.nextLine();
                l.add(name);
            }
            for(int i = 0; i < 10; i++)
                System.out.println("Pos " + i + ": " + l.get(i));

        }
}