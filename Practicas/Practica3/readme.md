# ***Practica 3***: 
## *Listas*
___

## ***Objetivos de la practica:***
Que el alumno comprenda el uso de las listas con objetos utilizando sus conocimientos previos sobre listas.

___
## ***Ejercicios de la practica***

### ***Parte A - Listas de Enteros***

**1. Teniendo en cuenta la implementación propuesta:**

**a** *Indique 2 motivos por los cuales la clase ListaDeEnteros se define como abstracta. Note que una subclase implementa la lista usando un arreglo de tamaño fijo y la otra usando nodos enlazados.*

**b** *La clase **ListaDeEnteros** está definida como clase **abstracta**. ¿Podría ud. agregar comportamiento en algún método de la clase **ListaDeEnteros**?*

**c** *Escriba una clase llamada **ListaDeEnterosEnlazadaTestBasico** (con método main) en el paquete prog3.listaenteros.test. Pruebe el comportamiento de la clase **ListaDeEnterosEnlazada** creando una instancia de la misma e invocando al método agregar (indique valores en el mismo código), luego recorra la lista e imprima los elementos de la misma*

**d** *Escriba un método **recursivo** que imprima los elementos de una lista en sentido inverso. La lista la recibe por parámetro.*

**e** *Observe la implementación interna de la clase **ListaDeEnterosEnlazada**, ¿qué diferencias existen entre agregar un nodo al principio de la lista, agregar un nodo en el medio y agregar un nodo al final, respecto de la cantidad de operaciones que debe realizarse?*

**2. Método “ordenar” de ListaDeEnterosEnlazada.** *Implemente un método de instancia llamado ordenar, que asumiendo que la lista contiene valores mayores a 0 y que todos sus elementos son diferentes, devuelve una nueva lista ordenada usando la siguiente estrategia: “seleccionar el menor elemento de la lista y colocarlo al final de la lista resultado”. Tenga en cuenta que la lista original NO debe modificarse.*

**a.** *La firma del método deberá ser la siguiente:*
```Java
    public ListaDeEnterosEnlazada ordenar();
```

**b.** *Escriba una clase llamada TestOrdenamientos y verifique el correcto funcionamiento del método ordenar.*

**c.** *Suponga que la lista a ordenar contiene N elementos. Indique ¿cuántos elementos recorrió de la lista original y en el peor de los casos, para generar la nueva lista resultante?*

**3. Método “combinarOrdenado” de ListaDeEnterosEnlazada.** *Implemente un método llamado combinarOrdenado que reciba 1 lista de elementos ordenada y devuelve una nueva lista también ordenada conteniendo los elementos de las 2 listas (la lista receptora del mensaje y la lista recibida por parámetro) . Como precondición, la lista que recibe el mensaje “combinarOrdenado” también estará ordenada.*

**a.** *La firma del método deberá ser la siguiente:***
```Java
    public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada listaParam);
```

**b.** *Escriba en la clase TestOrdenamientos escriba el código necesario para verificar el correcto funcionamiento del método combinarOrdenado.*

**c.** *Suponga que las listas a combinar tienen N y M elementos respectivamente. Indique ¿cuantos elementos recorrió para generar la nueva lista resultante?*

**4. MergeSort.** *La estrategia del MergeSort consiste en ordenar una lista dividiendo “el
problema” (la lista a ordenar) recursivamente hasta llegar a un punto en que no se puede dividir más. Luego, a medida que se vuelve de la recursión, se devuelven listas ya ordenadas y simplemente se combinan. Puede leer más acerca del mergesort en:*
  [MergeSort]((https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/overview-of-merge-sort) "MergeSort - Khan Academy")
- **i.** *Cree en el paquete prog3.util una clase llamada UtilitariosLista, e implemente el método **mergeSort.***

**5. JUnit (OPCIONAL)** 
- *Las librerías en el proyecto, fueron descargadas del sitio [Librerias JUnit]((https://github.com/junit-team/junit/releases) "JUnit 4.13.2") y corresponen a JUnit, un conjunto de clases que permiten escribir “pruebas”.*
- *En caso que no se encuentre incluída en su proyecto, incluya dicha librería (cree una carpeta lib de modo que la librería quede dentro de su proyecto).*
- *Ejecute la clase ListaDeEnterosEnlazadaJUnitTest y verifique que los Test se ejecutan exitosamente.*

___
### ***Parte B - Listas Genéricas***

**1. Lista Genérica.** *Continúe trabajando en su proyecto Programacion3. Analice la implementación brindada por la cátedra, en particular el uso del tipo genérico T.*

**2. Método “invertir” de ListaGenericaEnlazada.** *Implemente un método de instancia en la clase **ListaGenericaEnlazada** que devuelva una nueva lista pero con los elementos invertidos. La solución debe ser **recursiva**.*

**a.** *La firma del método deberá ser la siguiente:*
```Java
    public ListaGenericaEnlazada<T> invertir();
```

**b.** *Suponiendo que la lista original tiene N elementos, indique ¿cuantos elementos deberá recorrer para generar la nueva lista resultante?*

**3. Pila Genérica.**

**a.** *Cree una clase Pila de tipo genérico con la especificación que aparece a continuación. **Antes de implementar decida qué estructura de datos permitirá almacenar los datos de la Pila**.*
|         Pila        |
|:-------------------:|
|       +Pila()       |
|+apilar(elem:T): void|
|   +desapilar(): T   |
|      +tope(): T     |
|  +esVacía():boolean |

**b.** *Escriba una clase llamada **PilaTest**, donde demuestre el uso de su pila con elementos de tipo “**Character**”.*
- **i.** *Agregue a la pila los caracteres ‘a’, ‘b’, ‘c’, ’d’, ’e’.*
- **ii.** *Saque de la pila 4 elementos del tope.*
- **iii.** *Imprima en pantalla el elemento en el tope de la pila (debería imprimir ‘a’).*

**4. String de caracteres.**  *Considere que un string de caracteres {[]} está balanceado si cada símbolo de apertura se corresponde con un símbolo de cierre de manera “armoniosa”. Por ejemplo, "{( ) [ ( ) ] }" está balanceado, pero "( [ ) ]" no lo está.*

**a.** *Proponga una solución a la verificación del balanceo de un String e indique qué estructura de datos de las implementadas en esta práctica elegiría.”.*
>**Nota:** * puede usar el método **charAt(..)** de la clase String para recuperar cada caracter del String original.*

**b.** *Cree una clase llamada **TestBalanceo** e implemente un método cuyo objetivo es determinar si un String dado está balanceado o no. Para implementarlo, deberá recorrer el String caracter por caracter y **usar la estructura de datos elegida** en el punto a.*

**5. Cola Genérica.**  
**a.***Cree una clase Cola de tipo genérico con la especificación que aparece a continuación. **Antes de implementar decida qué estructura de datos permitirá almacenar los datos de la Cola.***
|         Cola         |
|:--------------------:|
|        +Cola()       |
|+encolar(elem:T): void|
|   +desencolar(): T   |
|      +tope(): T      |
|  +esVacía():boolean  |

___