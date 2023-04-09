# ***Practica 4***: 
## *Arboles binarios*
___

## ***Objetivos de la practica:***
Que el alumno comprenda el uso de los arboles binarios con objetos utilizando sus conocimientos previos sobre arboles binarios.

___
## ***Ejercicios de la practica***

### ***Parte A - Árboles binarios***

**1.** *1. Analice la implementación en JAVA de la clase ArbolBinario brindada por la cátedra*

**a** *Realice el diagrama del siguiente árbol. En particular indique **cómo quedan representados los nodos que son HOJA. ¿Cómo se representa el hijo izquierdo y el hijo derecho de una HOJA?***

```Java
    ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
    ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
    hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
    hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
    ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
    hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
    hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
    arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
    arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
```

**2.** *Implemente en la clase ArbolBinario los métodos correspondientes a los 3 tipos de recorrido en profundidad: **PreOrder, InOrder y PostOrder**.*

**a.** *La firma del método deberá ser la siguiente:*
```Java
    public ListaDeEnterosEnlazada ordenar();
```


**3.** *Agregue a la clase Arbol Binario los siguientes métodos*

**a.** ***contarHojas():int** Devuelve la cantidad de hojas del árbol receptor.*

**b.** ***frontera():ListaGenerica<T>** Se define **frontera** de un árbol binario, a las hojas de un árbol binario recorridos de izquierda a derecha.*

>**Nota:** *analice los 3 tipos de recorridos en profundidad de un ArbolBinario y elija el que corresponde.*

**c.** ***esLleno(): boolean**. Devuelve true si el árbol es lleno. Un árbol binario es lleno si tiene todas las hojas en el mismo nivel y además tiene todas las hojas posibles (es decir todos los nodos intermedios tienen dos hijos).*

**d.** ***esCompleto(): boolean**. Devuelve true si el árbol es completo. Un árbol binario de altura h es completo si es lleno hasta el nivel (h-1) y el nivel h se completa de izquierda a derecha.*

**4. JUnit (prueba de la implementación de los ejercicios anteriores)** 
**a.** *Descargue del sitio [Librerias JUnit]((https://github.com/junit-team/junit4/releases) "JUnit 4.13.2") el achivo .jar (librería recomendada version 4.7) correspondiente a JUnit ó descarguelo de la página de la cátedra.*
**b.** *Incluya dicha librería en su proyecto (cree una carpeta lib de modo que la librería quede dentro de su proyecto).*
**c.** *Ejecute la clase ArbolBinarioTest y verifique que los Test se ejecutan exitosamente.*

___
### ***Parte B -  Árboles binarios***

**1. sumaMaximaVertical.** *Se quiere saber cuál es la suma de mayor valor, recorriendo el árbol desde la raíz hacia las hojas.*

*Escriba una clase llamada **Utiles** y escriba
el método **sumaMaximaVertical**, que recibe un árbol binario y devuelve la suma máxima desde la raíz hacia las hojas.*

**2. sumaMaximaHorizontal.** *Siguiendo una idea semejante al ejercicio 1 de esta práctica, devuelva la suma máxima considerando que los valores a sumar deben pertenecer al mismo nivel.*

**3. Adivinanza.** *Considere una serie de preguntas y respuestas representadas bajo la forma de un árbol binario.*

**a.** ***Su tarea es la siguiente:** implemente una clase Adivinanza, que contenga un método con la siguiente firma:*

```Java
    public ListaEnlazadaGenerica<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario)
```
*Es decir, dado un árbol binario de preguntas y respuestas, devuelve el camino más largo desde la raíz hasta las hojas. Si hay dos caminos con la misma longitud, puede devolver cualquiera de ellos.*

**4. Trayectoria pesada:**  *En la clase Utiles implemente el método **trayectoriaPesada(ab: Arbol Binario): Lista** que retorna el valor de la trayectoria pesada de **cada una de las hojas** del árbol binario ab Se define **el valor de la trayectoria pesada** de una hoja de un árbol binario como la suma del contenido de todos los nodos desde la raíz a la hoja multiplicada por el nivel en el que se encuentra. *

**5. Adivinanza revisado.**  *Escriba un método llamado **secuenciaConMasPreguntasVersion2** (que es una modificación sobre el método **secuenciaConMasPreguntas**), donde se asume que SI pueden existir varios caminos de igual longitud, en ese caso debe devolver todos los caminos.***
___