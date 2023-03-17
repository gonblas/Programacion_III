package Ejercicio_3;

public class Ejercicio3{
    public static void main(String[] args) {

        Tablet[] tablets = new Tablet[3];

        tablets[0] = new Tablet("Apple", "IOS", "Messi1", 100.10, 15.30f);
        tablets[1] = new Tablet("Samsung", "Android 8.0", "Messi2", 200.10, 25.30f);
        tablets[2] = new Tablet("Asus", "Android 10.4", "Messi3", 300.10, 35.30f);

        for(Tablet i : tablets)
            System.out.println(i.toString() + "\n");

    }
}
