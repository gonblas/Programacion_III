package Practicas.Practica5.Practica5_B.Ejercicio1;

import PrograIII.GeneralTree.ArbolGeneral;
import PrograIII.GenericList.Cola;
import PrograIII.GenericList.ListaGenerica;

public class Empresa {
    private ArbolGeneral<Empleado> empleados;

    public Empresa(ArbolGeneral<Empleado> e) {
        empleados = e;
    }

    public ArbolGeneral<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(ArbolGeneral<Empleado> empleados) {
        this.empleados = empleados;
    }

    public int empleadosPorCategoria(int categoria) {
		ArbolGeneral<Empleado> a = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(empleados);
		cola.encolar(null);
        int lvl = 1, cant_empleados = 0; //Lvl empieza en 1 por el presidente
        while (!cola.esVacia()) {
            a = cola.desencolar();
            if (a != null) {
                cant_empleados++; //Cuento los empleados del nivel
                if (a.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = a.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else {
                if (!cola.esVacia()) {
                    cola.encolar(null);
                    if(lvl == categoria) //Devuelvo los empleados contados si el nivel es el pedido
                        return cant_empleados;
                    lvl++;
                    cant_empleados = 0;
                }
            }
        }
        return cant_empleados;
    }

    public int categoriaConMasEmpleados() {
        ArbolGeneral<Empleado> a = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(empleados);
		cola.encolar(null);
        int max = 0, cant_empleados = 0;

        while (!cola.esVacia()) {
            a = cola.desencolar();
            if (a != null) {
                cant_empleados++;
                if (a.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = a.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else {
                if (!cola.esVacia()) {
                    cola.encolar(null);
                    if (cant_empleados > max) {
                        max = cant_empleados;
                    }
                    cant_empleados = 0;
                }
            }
        }
        return cant_empleados;
    }
    
    public int cantidadTotalDeEmpleados() {
        ArbolGeneral<Empleado> a = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(empleados);
        int cant_empleados = 0;
        while (!cola.esVacia()) {
            a = cola.desencolar();
            if (a != null) {
                cant_empleados++;
                if (a.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = a.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            }
        }
        return cant_empleados;
    }
    
    public void reemplazarPresidente() {
        ArbolGeneral<Empleado> arbol = this.empleados; //Creo un arbol para recorrer
        while (arbol != null) { //Recorro mientras el arbol no sea null, solo sirve para cuando la raiz es null
            ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol.getHijos();
            hijos.comenzar();
            ArbolGeneral<Empleado> e = hijos.proximo();
            while (!hijos.fin()) { //Recorro la lista de hijos
                ArbolGeneral<Empleado> e2 = hijos.proximo();
                if (e.getDato().getAntiguedad() < e2.getDato().getAntiguedad()) { //Determino el hijo de mayor antiguedad
                    e = e2; //Guardo en e el de mayor antiguedad
                }
            }
            e.getDato().setCategoria(e.getDato().getCategoria()-1); //decremento al empleado que subira de categoria
            arbol.setDato(e.getDato()); //Sobreescribo las datos con los del empleado que subira de categoria
            if (e.esHoja()) { //Si es una hoja elimino, sino, sigo reemplazando
                arbol.eliminarHijo(e);
                break;
            }
            arbol = e; //Establezco que el nuevo a reemplazar es el que ascendio
        }
    }
}
