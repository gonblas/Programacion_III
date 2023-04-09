# ***Practica 2***: 
## *Conceptos Básicos y Herencia*
___

## ***Objetivos de la practica:***
Que el alumno repase los conceptos necesarios para arrancar bien con la cursada.

___
## ***Ejercicios de la practica***

### ***Parte A - Conceptos Básicos***

**1. Estructuras de Control (for, while) y recursión**


**1.1** *Cree una clase llamada **IteradorAB**. Al momento de crear la clase, verifique que la casilla de creación automática del método main se encuentre chequeada.*

**1.2** *Implemente el **método de instancia** llamado **iteracionConFor** que recibe 2 argumentos de tipo entero (llamados a y b, considere a < b) e imprime todos los números comprendidos entre a y b inclusive, usando el **for** como estructura de control. Es decir, dado a=2 y b=7 imprime 2 3 4 5 6 7.*

**1.3** *Implemente el **método de instancia** llamado **iteracionConWhile** que recibe 2 argumentos de tipo entero (llamados a y b, considere a < b) e imprime todos los números comprendidos entre a y b inclusive, usando el **while** como estructura de control.*

**1.4** *Implemente el **método de instancia** llamado **recursivo** que recibe 2 argumentos de tipo entero (llamados a y b, considere a < b) e imprime todos los números comprendidos entre a y b inclusive, usando **recursión**.*

**1.5** *Modifique los métodos para que sean **métodos de clase**.*
- **1.5.1** ¿Qué cambios tiene que realizar en la definición del método?
- **1.5.2** ¿Qué cambios tiene que realizar en la invocación a los métodos?

**1.6** *El siguiente programa utiliza diferentes instrucciones de procesamiento de datos (instrucciones aritméticas y lógicas). Analice y ejecute el comportamiento de ellas en el MSX88.*

**2. Arreglos**

**2.1** *Cree una clase llamada **Multiplos**.*

**2.2** *Escriba un **método de clase** llamado **getMultiplos** que dado un número entero **n** como parámetro, devuelve un arreglo de **n** posiciones cuyo contenido son los primeros n primeros múltiplos mayores a 1. Ejemplo:*

*getMultiplos(5) devuelve [5; 10; 15; 20; 25];*

*getMultiplos(4) devuelve [4; 8; 12; 16];*

**2.3** *Pruebe que su método funciona correctamente con distintos valores de **n** (indique manualmente los valores de n, **NO** los lea de teclado)*

**3. Creación de instancias (operador new)**

**3.1** *Cree una clase llamada **Tablet***

**3.2** *Agregue las siguientes **variables de instancia privadas** a la clase Tablet:*
- *marca (String)*
- *sistemaOperativo (String)*
- *modelo (String)*
- *costo (double)*
- *pulgadas (float)*

**3.3** *Genere los métodos “getter” y “setter” que permitan asignar valores a las variables de instancia y devolverlos.*

**3.4** *Escriba un método de instancia llamado **devolverDatos()** en la clase Tablet que **devuelve** información de la instancia sobre la cual es invocado. Para el caso de una instancia de Tablet se espera que devuelva todos los valores de sus variables de instancia “concatenados”.*

**3.5** *Cree una clase llamada TestTablet que contenga el método **main**. Dentro del método **main** cree un **arreglo de Tablet** de 3 posiciones.*

**3.6** *Cree 3 instancias de Tablet con distintos valores y agreguelos a cada una de las posiciones del arreglo.*

**3.7** *Recorra el arreglo usando una estructura de control iterativa **for o foreach** e imprima la información de las Tablets, enviando a cada tablet el mensaje **devolverDatos()**.*


**4. Lectura por teclado:** *Agregue al programa del ejercicio 2 la posibilidad de probar con distintos valores de n ingresándolos por teclado, mediante el uso de las clases Scanner y System. La clase Scanner permite leer de forma sencilla valores de entrada.*

___
### ***Parte B - Herencia***

**1.** *Cree un proyecto llamado **DispositivosMoviles** y escriba la siguiente jerarquía de clases en JAVA.*

**a.** *En las clases **Tablet** y **SmartPhone** sobreescriba el método **public boolean equals(Object)** heredado de la clase Object. El método equals permite comparar 2 instancias (defina ud. cuando 2 objetos se consideran iguales).*

**b.** *Sobreescriba también en ambas clases el método **public String toString()** heredado de la clase **Object**, de manera que retorne los datos de esos objetos de manera **legible**.*

**c.** *Escriba una clase dispositivos.prog3.info.EjercicioTestSobreescritura y pruebe los métodos sobreescritos*

- **i.** *Defina dos objetos de tipo **SmartPhone**, setee el mismo valor en la variable de instancia **numero**. ¿Cuál es el resultado de invocar al método equals?.*

- **ii.** *Imprima el contenido de ambos objetos (use System.out.println y envíe directamente la instancia creada)*

**2. Jerarquía de animales**

**a.** *Cree un proyecto llamado **Animales**.*

**b.** *Escriba el siguiente código:*

```Java
public abstract class Animal {
    public abstract void saludo();
}
```

```Java
public class Gato extends Animal {
    @Override
    public void saludo() {
        System.out.println("Miau!");
    }
}
```

```Java
public class Perro extends Animal {
    @Override
    public void saludo() {
        System.out.println("Guau!");
    }
    public void saludo(Perro otro) {
        System.out.println("Guau! Guau!");
    }
}
```

```Java
public class PerroGrande extends Perro {
    @Override
    public void saludo() {
        System.out.println("Guauuuuuu!");
    }
    @Override
    public void saludo(Perro otro) {
        System.out.println("Guauuuuuu!
        Guauuuuuu!");
    }
    public boolean esMasBuenoQue(Animal
    otro){
        return true;
    }
}
```

```Java
public class TestAnimal1 {
    public static void main(String[] args) {
        Gato donGato = new Gato();
        donGato.saludo();
        Perro benji = new Perro();
        benji.saludo();
        PerroGrande lassie = new PerroGrande();
        lassie.saludo();
    }
}
```

**c.** *Indique qué obtuvo como salida luego de la ejecución de TestAnimal1.*

**d.** *Ahora escriba el siguiente código:*

```Java
public class TestAnimal2 {
    public static void main(String[] args) {
        Animal donGato = new Gato();
        donGato.saludo();
        Animal benji = new Perro();
        benji.saludo();
        Animal lassie = new PerroGrande();
        lassie.saludo();
    }
}
```
**e.** *Analice en el código la diferencia entre TestAnimal1 y TestAnimal2 e indique qué obtuvo como salida luego de la ejecución de TestAnimal2.*
- **i.** **Responda.**
*Considerando TestAnimal2, puede enviarle a lassie el mensaje “esMasBuenoQue(...)”? **JUSTIFIQUE***

**f.** *Escriba el siguiente código:*
```Java
public class TestAnimal3 {
    public static void main(String[] args) {
        Gato gato1 = new Gato();
        gato1.saludo();
        Perro perro1 = new Perro();
        perro1.saludo();
        PerroGrande perroGrande1 = new PerroGrande();
        perroGrande1.saludo();
        Animal animal1 = new Gato();
        animal1.saludo();
        Animal animal2 = new Perro();
        animal2.saludo();
        Animal animal3 = new PerroGrande();
        animal3.saludo();
        Perro perro2 = animal2;
        PerroGrande perroGrande2 = animal3;
        Perro perro3 = animal3;
        Gato gato2 = animal2;
        perro2.saludo(perro3);
        perro3.saludo(perro2);
        perro2.saludo(perroGrande2);
        perroGrande2.saludo(perro2);
        perroGrande2.saludo(perroGrande1);
    }
}
```
**g.** *Corrija los errores en compilación y **JUSTIFIQUE**. ¿cómo se llama el mecanismo aplicado?*

**h.** ***Responda:** ¿es posible crear una instancia de la clase Animal? **JUSTIFIQUE***

**3. Pasaje de parámetros.**

**3.1** *Analice el siguiente código **sin copiarlo**. A su criterio ¿qué imprime?*

```Java
public class SwapValores {
    public static void swap1 (int x, int y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }
    public static void swap2 (Integer x, Integer y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }
    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a,b);
        swap2(c,d);
        System.out.println("a=" + a + " b=" + b) ;
        System.out.println("c=" + c + " d=" + d) ;
    }
}
```

**3.2** *Ahora copie el código.*

**3.3** *Agregue un breakpoint en cada línea: y = tmp; ejecute en modo Debug y analice. ¿es correcta su respuesta?.*

**4.**  *Cree una clase llamada **PruebaRetorno** con un método llamado procesarArreglo. Éste método recibe como argumento un arreglo de enteros y debe devolver el máximo, el mínimo y el promedio del mismo. Proponga 2 implementaciones para la **forma de devolver** el resultado de procesarArreglo.*

>**Nota:** *el método no puede devolver un arreglo.*
___