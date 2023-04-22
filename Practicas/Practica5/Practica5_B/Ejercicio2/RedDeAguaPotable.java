package Practicas.Practica5.Practica5_B.Ejercicio2;

import PrograIII.GeneralTree.ArbolGeneral;
import PrograIII.ListGeneric.ListaGenerica;


public class RedDeAguaPotable {
    public static void main(String[] args) {
        ArbolGeneral<Double> a = new ArbolGeneral<Double>(1.1);
        a.agregarHijo(new ArbolGeneral<Double>(2.0));
        a.agregarHijo(new ArbolGeneral<Double>(3.0));
        a.agregarHijo(new ArbolGeneral<Double>(4.0));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(5.0));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(6.0));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(7.0));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(8.0));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(9.0));
        //Los valores asignados son random ya que solo importa la configuracion

        System.out.println("El caudal minimo de una hoja es: " + minimoCaudal(a, 2000));
    }
    
    public static double minimoCaudal(ArbolGeneral<Double> a, double n) {
        double min = Integer.MAX_VALUE;
        if (a.esHoja()) {
            return n;
        }
        ListaGenerica<ArbolGeneral<Double>> hijos = a.getHijos();
        hijos.comenzar();
        double caudal = n / hijos.tamanio();
        while (!hijos.fin()) {
            double aux = minimoCaudal(hijos.proximo(), caudal);
            if (aux < min) {
                min = aux;
            }
        }
        return min;
    }
}