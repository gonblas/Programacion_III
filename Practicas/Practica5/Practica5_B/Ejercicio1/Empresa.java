package Practicas.Practica5.Practica5_B.Ejercicio1;

import PrograIII.GeneralTree.ArbolGeneral;
import PrograIII.ListGeneric.ListaGenerica;
import PrograIII.ListGeneric.Cola;

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
                    if(lvl == categoria)
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
        int lvl = 1, max = 0, maxCat = -1, cant_empleados = 0;
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
                        maxCat = lvl;
                    }
                    lvl++;
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
        ArbolGeneral<Empleado> arbol = this.empleados;
        while (arbol != null) {
            ListaGenerica<ArbolGeneral<Empleado>> l = arbol.getHijos();
            l.comenzar();
            ArbolGeneral<Empleado> e = l.proximo();
            while (!l.fin()) {
                ArbolGeneral<Empleado> e2 = l.proximo();
                if (e.getDato().getAntiguedad() < e2.getDato().getAntiguedad()) {
                    e = e2;
                }
            }
            e.getDato().setCategoria(e.getDato().getCategoria()-1);
            arbol.setDato(e.getDato());
            if (e.esHoja()) {
                arbol.eliminarHijo(e);;
                break;
            }
            arbol = e;
        }
    }


}
