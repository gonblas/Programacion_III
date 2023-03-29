package Practicas.Practica3.Practica3_B;

import PrograIII.ListGeneric.Pila;

public class Ejercicio4 {
    public static void main(String[] args) {
        String cadena = "()";
        if (testBalanceo(cadena))
            System.out.println("La cadena es armoniosa.");
        else
            System.out.println("La cadena no es armoniosa.");
    }

    public static boolean testBalanceo(String cadena) {
        Pila<Character> p = new Pila<>();
        int len = cadena.length(), i=0;
        while (i<len) {
            char car = cadena.charAt(i);
            if ((car == '{') || (car == '[') || (car == '('))
                p.apilar(car);
            else if ((car == '}') || (car == ']') || (car == ')')) {
                if (p.esVacia()) {
                    return false;
                }
                char ult = p.desapilar();
                if ((car == '}' && ult != '{') || (car == ']' && ult != '[') || (car == ')' && ult != '(')) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
