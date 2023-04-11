package Practicas.Practica5.Practica5_A;
import PrograIII.GeneralTree.ArbolGeneral;

public class Test {
    public static void main(String[] args){
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(1);
        //hace un arbol random
        a.agregarHijo(new ArbolGeneral<Integer>(2));
        a.agregarHijo(new ArbolGeneral<Integer>(3));
        a.agregarHijo(new ArbolGeneral<Integer>(4));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(6));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(7));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(8));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(9));

        // System.out.println("Altura del arbol: " + a.altura()); //3
        // System.out.println("Include: " + a.include(6)); //true
        // System.out.println("Nivel: " + a.nivel(8)); //2
        System.out.println("Ancho: " + a.ancho()); //3
    }
}