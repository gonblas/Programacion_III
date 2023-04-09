# ***Progra III*** 

## ***¿Que se encuentra en esta carpeta?***
Se encuentran todas las clases provistas por la catedra de Programacion III para poder realizar las practicas semanales. Ademas, se encuentran las clases pedidas en las practicas, las mismas tambien son utiles para toda la cursada, por lo tanto, han sido incluidas.

___
## ***Tipos De Clases***
### ***ListInt***
#### ***ListaDeEnteros:** Lista de numero enteros.*
- **comenzar():** Permite posicionarse al principio de la lista.
- **proximo():** Permite avanzar al proximo elemento de lista devolviendo antes el elemento de la actual posicion.
- **fin():** Devuelve true si nos encontramos en el último elemento de la lista, false en caso contrario.
- **elemento(int pos):** Devuelve el elemento que se encuentra en la posicion pos.
- **agregarEn(Integer elem, int pos):** Agrega un elemento en la posicion **pos** indicada. Si hubiera un elemento en dicha posicion, el mismo se reubicará a continuación del elemento que
vamos a agregar. Si pudo eliminarlo devuelve true, false en caso contrario.
- **agregarInicio(Integer elem):** Agrega un elemento al principio de la lista. Si pudo agregarlo devuelve true, false en caso contrario.
- **agregarFinal(Integer elem):** Agrega un elemento al final de la lista. Si pudo agregarlo devuelve true, false en caso contrario.
- **eliminar(Integer elem):** Elimina la primer ocurrencia del elemento elem indicado. Si pudo eliminarlo devuelve true, false en caso contrario.
- **eliminarEn(int pos):** Elimina el elemento ubicado en la posicion pos. Si pudo eliminarlo devuelve true, false en caso contrario.
- **incluye(Integer elem):** Devuleve true si la lista contiene al elemento elem, false en caso contrario.
- **esVacia():** Devuelve true si la lista no contiene elementos, false en caso contrario.
- **tamanio():** devuelve un numero que representa la cantidad de elementos que contiene la lista.

#### ***ListaDeEnterosConArreglos:** Lista de numero enteros con arreglos, implementa los metodos de ListaDeEnteros pues hereda del mismo.*
- **toString():** Devuelve un String con todos los elementos de la lista.

#### ***ListaDeEnterosEnlazada:** Lista de numero enteros enlazada, implementa los metodos de ListaDeEnteros pues hereda del mismo.*
- **toString():** Devuelve un String con todos los elementos de la lista.
- **ordenar():** Ordena la lista.
- **cambiarOrdenado(ListaDeEnterosEnlazada):** Devuelve una lista enlazada ordenada con los elementos de la lista que recibe el mensaje y la pasada como argumento. Ambas deben estar ordenadas previamente.

#### ***NodoEntero:** Esta clase representa un nodo de la lista de enteros. Solo tiene los getters y setters.
___
### ***ListGeneric***
#### **ListaGenerica:** Lista de un tipo de dato generico.
- **comenzar():** Permite posicionarse al principio de la lista.
- **proximo():** Permite avanzar al proximo elemento de lista devolviendo antes el elemento de la actual posicion.
- **fin():** Devuelve true si nos encontramos en el último elemento de la lista, false en caso contrario.
- **elemento(int pos):** Devuelve el elemento que se encuentra en la posicion pos.
- **agregarEn(Integer elem, int pos):** Agrega un elemento en la posicion **pos** indicada. Si hubiera un elemento en dicha posicion, el mismo se reubicará a continuación del elemento que
vamos a agregar. Si pudo eliminarlo devuelve true, false en caso contrario.
- **agregarInicio(Integer elem):** Agrega un elemento al principio de la lista. Si pudo agregarlo devuelve true, false en caso contrario.
- **agregarFinal(Integer elem):** Agrega un elemento al final de la lista. Si pudo agregarlo devuelve true, false en caso contrario.
- **eliminar(Integer elem):** Elimina la primer ocurrencia del elemento elem indicado. Si pudo eliminarlo devuelve true, false en caso contrario.
- **eliminarEn(int pos):** Elimina el elemento ubicado en la posicion pos. Si pudo eliminarlo devuelve true, false en caso contrario.
- **incluye(Integer elem):** Devuleve true si la lista contiene al elemento elem, false en caso contrario.
- **esVacia():** Devuelve true si la lista no contiene elementos, false en caso contrario.
- **tamanio():** devuelve un numero que representa la cantidad de elementos que contiene la lista.

#### **ListaGenericaEnlazada:** Lista enlazada de un tipo de dato generico. Al heredar de una clase abstracta ListaGenerica implementa todos sus metodos.

#### **Pila:** Estructura de tipo LIFO implementada a partir de una lista enlazada.
- **apilar(T elem):** Apila un elemento generico a la pila.
- **desapilar():** Desapila un elemento generico de la pila y lo devuelve.
- **tope():** Devuelve el elemento del tope de la pila sin sacarlo de la misma.
- **esVacia():** Devuelve true si la pila esta vacia, false en caso contrario.

#### **Cola:** Estructura de tipo FIFO implementada a partir de una lista enlazada.
- **encolar(T elem):** Encola un elemento generico a la cola.
- **desencolar():** Desencola un elemento generico de la cola y lo devuelve.
- **tope():** Devuelve el elemento del tope de la cola sin sacarlo de la misma.
- **esVacia():** Devuelve true si la cola esta vacia, false en caso contrario.

#### ***NodoGenerico:** Esta clase representa un nodo de la lista generica. Solo tiene los getters y setters.

___
### ***BinaryTree***
#### ***ArbolBinario:** Esta clase representa un arbol binario que acepta tipos genericos.
- **ArbolBinario(T dato):*Constructor que inicializa a la raiz con un valor.
- **getDato():** Devuelve el dato que almacena el nodo del arbol.
- **setDato(T dato):** Para cambiar el dato de un nodo del arbol.
- **getHijoIzquierdo():** Devuelve el hijo izquierdo (Devuelve un arbol).
- **getHijoDerecho():** Devuelve el hijo derecho (Devuelve un arbol).
- **agregarHijoIzquierdo(ArbolBinario<T> hijo):** Agrega un hijo izquierdo.
- **agregarHijoDerecho(ArbolBinario<T> hijo):** Agrega un hijo derecho.
- **eliminarHijoIzquierdo():** Elimina el hijo izquierdo (lo pone en null).
- **eliminarHijoDerecho():** Elimina el hijo derecho (lo pone en null).
- **esVacio():** Devuelve true si el arbol esta vacio, false en caso contrario.
- **esHoja():** Devuelve true si el nodo es una hoja.
- **toString():** Devuelve un string con los datos que almacena (depende de si el dato tiene su propio toString implementado).
- **tieneHijoIzquierdo():** Devuelve true si el nodo tiene hijo izquierdo, false en caso contrario.
- **tieneHijoDerecho():** Devuelve true si el nodo tiene hijo derecho, false en caso contrario.
- **esLleno():** Devuelve true si el arbol es lleno, false en caso contrario.
- **esCompleto():** Devuelve true si el arbol es completo, false en caso contrario.
- **printPreorden():** Imprime el arbol en preorden.
- **printInorden():** Imprime el arbol en inorden.
- **printPostorden():** Imprime el arbol en postorden.
- **recorridoPorNiveles():** Imprime el arbol por niveles.
- **frontera():** Devuelve una lista con los nodos hojas.
- **contarHojas():** Devuelve la cantidad de hojas del arbol.

#### ***Adivinanza:** Esta clase es parte de un ejercicio.
- **secuenciaConMasPreguntas(ArbolBinario<String> abinario):** Devuelve una lista de Strings con el camino mas largo desde la raiz hasta una hoja (Solo una).
- **secuenciaConMasPreguntasVersion2(ArbolBinario<String> abinario):** Devuelve una lista de listas Strings con los camino mas largos desde la raiz hasta una hoja (si existe mas de uno con la mayor longitud).

___