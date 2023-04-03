package Pruebas.Listas;

import java.util.Scanner;
import PrograIII.ListGeneric.ListaGenericaEnlazada;

public class Ej1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaGenericaEnlazada<Persona> list = new ListaGenericaEnlazada<>();
        String name;
        int edad;
        long DNI;
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese un nombre: ");
            name = in.nextLine();
            System.out.println("Ingrese la edad de " + name + ": ");
            edad = in.nextInt();
            System.out.println("Ingrese el DNI de " + name + ": ");
            DNI = in.nextLong();
            in.nextLine();
            Persona p = new Persona(name, edad, DNI);
            list.agregarFinal(p);
        }
    }
}
