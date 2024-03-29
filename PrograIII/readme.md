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
### ***GenericList***
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

#### **NodoGenerico:** Esta clase representa un nodo de la lista generica. Solo tiene los getters y setters.

___
### ***BinaryTree***
#### **ArbolBinario:** Esta clase representa un arbol binario que acepta tipos genericos.
- **ArbolBinario(T dato):**Constructor que inicializa a la raiz con un valor.
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

#### **Adivinanza:** Esta clase es parte de un ejercicio.
- **secuenciaConMasPreguntas(ArbolBinario<String> abinario):** Devuelve una lista de Strings con el camino mas largo desde la raiz hasta una hoja (Solo una).
- **secuenciaConMasPreguntasVersion2(ArbolBinario<String> abinario):** Devuelve una lista de listas Strings con los camino mas largos desde la raiz hasta una hoja (si existe mas de uno con la mayor longitud).
### ***GeneralTree***
#### **ArbolGeneral:** Esta clase posee un tipo de arbol general generico.
- **ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos):** Constructor que inicializa los valores de la raiz y sus hijos.
- **ArbolGeneral(T dato):** Constructor que inicializa el valor de la raiz.
- **getDato():** Devuelve el dato almacenado por el nodo.
- **setDato():** Permite modificar el dato almacenado por el nodo.
- **getHijos():** Permite obtener la lista de hijos de un nodo.
- **setHijos():** Permite cambiar la lista de hijos de un nodo.
- **agregarHijo(ArbolGeneral<T> unHijo):** Agrega un hijo al final de la lista. 
- **esHoja():** Devuelve true si el nodo es una hoja, false en caso contrario. 
- **tieneHijos():** Devuelve true si el nodo tiene hijos, false en caso contrario.
- **esVacio():** Devuelve true si el arbol es vacio (se toma al arbol con raiz como el nodo que estamos recorriendo), false en caso contrario. 
- **eliminarHijo(ArbolGeneral<T> hijo):** Elimina un hijo pasado por parametros si el mismo es un hijo.
- **preOrden():** Recorre e imprime el arbol en preorden. 
- **altura():** Retorna la altura del arbol.
- **nivel(T dato):** Devuelve el nivel del nodo encontrado en caso afirmativo, en caso contrario devuelve false.
- **ancho():** Devuelve el ancho maximo de un arbol.
- **include(T dato):** Devuelve true si el dato recibido se encuentra en el arbol, false en caso contrario.
- **ImprimirPorNiveles():** Imprime el arbol por niveles.
___

### ***Graph***
#### **Arista:** Interfaz de la arista de un grafo.
- **verticeDestino():** Retorna el vértice destino de la arista.
- **peso():** Retorna el peso de la arista.
#### **AristaImpl:** Clase que representa la arista de un grafo. Al implementar la interfaz **Arista** implementa todos sus metodos.
- **AristaImpl(Vertice<T> dest, int p):** Constructor que inicializa las variables de instancia de una arista.
#### **Grafo:** Interfaz que representa un grafo.
- **agregarVertice(Vertice<T> v):** Agrega un vértice al Grafo. Verifica que el vértice
no exista en el Grafo.
- **eliminarVertice(Vertice<T> v):** Elimina el vértice del Grafo. En caso que el vértice tenga conexiones con otros vértices, se eliminan todas sus conexiones.
- **conectar(Vertice<T> origen, Vertice<T> destino):** Conecta el vértice origen con el vértice destino sin peso. Verifica que ambos vértices existan, caso contrario no realiza ninguna conexión
- **conectar(Vertice<T> origen, Vertice<T> destino, int peso):** Conecta el vértice origen con el vértice destino con peso. Verifica que ambos vértices existan, caso contrario no realiza ninguna conexión.
- **desConectar(Vertice<T> origen, Vertice<T> destino):** Desconecta el vértice origen con el destino. Verifica que ambos vértices y la conexión origen->destino existan, caso contrario no realiza ninguna desconexión. En caso de existir la conexión destino -> origen, ésta permanece sin cambios.
- **esAdyacente(Vertice<T> origen, Vertice<T> destino):** Retorna true si origen es adyacente a destino. False en caso contrario.
- **esVacio():** Retorna true en caso que el grafo no contenga ningún vértice. False en caso contrario.
- **listaDeVertices():** Retorna la lista con todos los vértices del grafo.
- **peso(Vertice<T> origen, Vertice<T> destino):** Retorna el peso de la conexión origen -->destino . Si no existiera la conexión retorna 0.
- **listaDeAdyacentes(Vertice<T> v):**  Retorna la lista de adyacentes de un vértice.
- **vertice(int posicion):** Retorna el vértice dada su posición.
#### **GrafoImplListAdy:** Clase que representa un objeto de tipo grafo implementado con listas de adyacencia. Al implementar la interfaz **Grafo** implementa todos sus metodos.
#### **GrafoImplMatrizAdy:** Clase que representa un objeto de tipo grafo implementado con una matriz de adyacencia. Al implementar la interfaz **Grafo** implementa todos sus metodos.
#### **Vertice:** Interfaz que representa un vertice de un grafo.
- **dato():** Retorna el dato del vértice.
- **setDato(T unDato):** Setea el dato del vértice.
- **posicion():** Retorna la posición del vértice.
#### **VerticeImplListAdy:** Clase que representa un vertice de un grafo implementado mediante listas de adyacencia. Al implementar la interfaz **Vertice** implementa todos sus metodos.
- **VerticeImplListAdy(T d):** Constructor. Asigna un valor para el vertice y asigna memoria para la lista de adyacencia.
- **conectar(Vertice<T> v):** Dado un vertice recibido como parametro lo conecta sin tener en cuenta el peso (peso 1).
- **conectar(Vertice<T> v, int peso):** Dado un vertice recibido como parametro lo conecta teniendo en cuenta el peso.
- **desconectar(Vertice<T> v):** Dado un vertice recibido como parametro lo desconecta de aquel que recibe el mensaje.
- **obtenerAdyacentes():** Retorna una lista con los vertices adyacentes.
- **esAdyacente(Vertice<T> v):** Retorna true si el vertice recibido por parametro es adyacente a aquel que recibe el mensaje, false en caso contrario.
- **peso(Vertice<T> v):** Retorna el peso de la arista que conecta al vertice que recibe el mensaje con el vertice recibido por parametro.
- **obtenerArista(Vertice<T> v):** Retorna una arista que conecta al vertice que recibe el mensaje con el vertice recibido por parametro.
- **setPosicion(int pos):** Dada una posicion recibida por parametros establece el nuevo valor de la posicion del vertice.
#### **VerticeImplMatrizAdy:** Clase que representa un vertice de un grafo implementado mediante una matriz de adyacencia. Al implementar la interfaz **Vertice** implementa todos sus metodos.
- **VerticeImplMatrizAdy(T d):** Constructor. Asigna un valor para el vertice.
- **conectar(Vertice<T> v):** Dado un vertice recibido como parametro lo conecta sin tener en cuenta el peso (peso 1).
- **conectar(Vertice<T> v, int peso):** Dado un vertice recibido como parametro lo conecta teniendo en cuenta el peso.
- **desconectar(Vertice<T> v):** Dado un vertice recibido como parametro lo desconecta de aquel que recibe el mensaje.
- **obtenerAdyacentes():** Retorna una lista con los vertices adyacentes.
- **esAdyacente(Vertice<T> v):** Retorna true si el vertice recibido por parametro es adyacente a aquel que recibe el mensaje, false en caso contrario.
- **peso(Vertice<T> v):** Retorna el peso de la arista que conecta al vertice que recibe el mensaje con el vertice recibido por parametro.
- **obtenerArista(Vertice<T> v):** Retorna una arista que conecta al vertice que recibe el mensaje con el vertice recibido por parametro.
- **setPosicion(int pos):** Dada una posicion recibida por parametros establece el nuevo valor de la posicion del vertice.

#### **Recorridos:** Clase con los recorridos basicos de un grafo.
- **dfs(Grafo<T> grafo):** Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.
- **bfs(Grafo<T> grafo):** Retorna una lista de vértices con el recorrido en amplitud del grafo recibido como parámetro.
___