# ***Practica 5***: 
## *Arboles generales*
___

## ***Objetivos de la practica:***
Que el alumno comprenda el uso de los arboles generales con objetos utilizando sus conocimientos previos sobre arboles binarios en Java.

___
## ***Ejercicios de la practica***

### ***Parte A - Árbol general***

**1.** *Revise la implementación de árboles generales provista por la cátedra. La clase **Lista** es la utilizada en la práctica 3, vamos a utilizar la representación **lista de hijos**.*

**a** *Implemente el método **altura():** int que devuelve la altura del árbol, es decir, la longitud del camino más largo desde el nodo raíz hasta una hoja. **Pista:** el mensaje altura debe chequear si el árbol es una sola hoja o no. Si el árbol es una sola hoja, se devuelve 0. Si no, se utiliza el mensaje getHijos() para obtener la lista de hijos (recuerde que devuelve una lista de **árboles hijos**). Luego, debe iterar por cada uno de los hijos, delegando el mensaje **altura()** hasta llegar a una hoja, donde evaluará si se alcanzó una altura máxima. A medida que se avanza en profundidad sobre el árbol, se va sumando 1.***

**b.** *Implemente el método **include(T dato): boolean** que devuelve **true** si dato se encuentra en el árbol, y **false** en caso contrario*

**c.** *Implemente el método **nivel(T dato): int** que devuelve el nivel donde se encontró el dato en el árbol. El nivel de un nodo es la longitud del único camino de la raíz al nodo. **Pista:** si el nodo raíz posee el mismo dato que pasado como parámetro, se retorna 0. En caso contrario, se debe buscar en cuáles de los subárboles hijos se encuentra el dato*

**d.** *Implemente el método **ancho(): int** que devuelve la amplitud (ancho) de un árbol, es decir la cantidad de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos. **Pista:** realice un recorrido por niveles. Encole inicialmente la raíz del árbol y luego una marca null (o un nodo vacío ó el número de nivel) para indicar el fin de nivel. Mientras la cola no se vacía, itere. En cada iteración extraiga el tope de la cola, y con la operación getHijos() encole los mismos. Cuando encuentra la marca de fin de nivel cuente si los elementos del nivel es mayor a la máxima cantidad que poseía.*

___
### ***Parte B -  Árboles binarios***

**1.** *Considere la siguiente representación de la relación entre una empresa y sus empleados:*

|                      Empresa                    |
|:-----------------------------------------------:|
|          -empleados: Collecion<Empleado>        |
|+empleadosPorCategorias(): ListaGenerica<Integer>|
|         +categoriaConMasEmpleados(): int        |
|         +cantidadTotalDeEmpleados(): int        |
|             +reemplazarPresidente()             |

|           Empleado        |
|:-------------------------:|
|      -nombre: String      |
|      -antiguedad: int     |
|      -categoria: int      |
|   +getNombre(): String    |
|   +getAntiguedad(): int   |
|   +getCategoria(): int    |
|        +setNombre()       |
|     +setAntiguedad()      |
|      +setCategoria()      |



*Si bien en el diagrama se muestra que la Empresa posee una colección de empleados, en realidad la relación entre empleados es de tipo jerárquica:*

*Categoría 1: Presidente*

*Categoría 2: Gerentes*

*Categoría 3: Sub-gerentes*

*Categoría 4: Empleados que no tienen nadie a cargo*

**a.** *Indique qué estructura de datos (en lugar de **Collection**) le permite representar esta organización jerárquica en la empresa.*

**b.** *Realice la implementación de la empresa y sus empleados e implemente las siguientes operaciones:*

- ***empleadosPorCategoria(int categoria): int** Dado un número de categoría devuelve la cantidad de empleados de dicha categoría.*
- ***categoriaConMasEmpleados():int** determina la categoría que cuenta con la mayor cantidad de empleados.*
- ***cantidadTotalDeEmpleados():int** determina la cantidad total de empleados.*
- ***reemplazarPresidente():** sea la situación en donde el presidente deja su función, reemplazarlo por la persona más antigua de sus subordinados, quién a su vez es reemplazada de la misma forma. **Pista:** Debe tomar los hijos de la raíz, y buscar el de mayor antigüedad de los hijos. Sin modificar la estructura, pase el mayor de los hijos a la raíz, y se envía el mensaje al hijo promovido. Cuando el hijo promovido no tenga hijos, se lo debe eliminar.*

**2. Red de Agua Potable.** 

*La red de agua potable comienza en un caño maestro y el mismo se va dividiendo sucesivamente hasta llegar a cada una de las casas. Por ejemplo, si por el caño maestro ingresan 1000 litros, a medida que el caño se divide, el caudal se divide en partes iguales en cada una de las divisiones. Es decir, si el caño maestro se divide en 4 partes, cada división tiene un caudal de 250 litros. Luego, si una de esas divisiones se vuelve a dividir en 3 partes, cada una tendrá un caudal de 83,3. La situación descripta se puede modelar de la siguiente forma a través del siguiente árbol general:*

![](https://ibb.co/hCBxz9L)

*Usted debe implementar un método en la clase **RedDeAguaPotable**, que reciba una “**configuración**” con la forma de la red de agua potable y **n litros** que son los que ingresan por el caño maestro; el método calcula y devuelve cuál es el mínimo caudal que recibe una hoja.*

**3. TRIEs == re-trie-val trees** 

*Definición de un TRIE*

- *Es una estructura de datos que permite representar conjuntos de cadenas de caracteres.*
- *Cada nodo de T, excepto la raíz, está etiquetado con un símbolo del alfabeto*
- *Los hijos de un nodo interno de T están ordenados según el ordenamiento en el alfabeto*
- *Cada hoja marca el final de una cadena*

*Una aplicación frecuente de los TRIES es el almacenamiento de diccionarios, como los que se encuentran en los teléfonos móviles.*

**a.** *Implemente un TRIE con la siguiente operación:*

```Java
    public void agregarPalabra(String palabra)
```

*Dada una palabra ingresada como parámetro, el método **agregarPalabra** deberá agregar cada uno de los caracteres que la conforman de manera de representar dicha palabra en el TRIE*

**b.** *Agregue a la implementación del TRIE la siguiente operación:*

```Java
    public List<StringBuilder> palabrasQueEmpiezanCon(String prefijo)
```

*Devuelve una lista con todas las posibles palabras que comienzan con la cadena de caracteres ingresada como parámetro*

___