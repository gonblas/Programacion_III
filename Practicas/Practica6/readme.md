# ***Practica 6***: *Tiempo de Ejecución*


## ***Objetivos de la practica:***
Que el alumno comprenda el concepto de tiempo de ejecucion pudiendo aplicarlo para algoritmos iterativos y recursivos. Ademas, aprender el concepto de Big-O.

___
## ***Importante***

todas las referencias a logaritmos se refieren a logaritmo en base 2, por tanto, de ser necesario utilice el cambio de base para convertir los logaritmos a base 2 (explicado en [Cambio de base](http://es.wikipedia.org/wiki/Logaritmo#Cambio_de_base "Cambio de base")). Si quiero cambiar de base a en base b:
$$log_a(x) = log_b(x) / log_b(a) ⇔ 𝑎 ≠ 1, 𝑏 ≠ 1$$
___
## ***Ejercicios de la practica***

### ***Parte A - Tiempo de Ejecución***

**1.** *En este ejercicio puede utilizar el graficador de funciones que se encuentra online en
[Graficador](https://www.mathway.com/es/Graph "Graficador"). **La consigna del ejercicio es ordenar los tiempos de ejecución según sus velocidades de crecimiento**.*

**a.** *$T_1(n) = n * log_2(n)$*

**b.** *$T_2(n)= (1/3)n$*

**c.** *$T_3(n) = 2n + n^2$*

**d.** *$T_4(n) = (3/2)n$*

**e.** *$T_5(n) = (log_2(n))^2$*

**f.** *$T_6(n) = log_2(n)$*

**g.** *$T_7(n) = n + log_2(n)$*

**h.** *$T_8(n) = n^{1/2}$*

**i.** *$T_9(n) = 3^n$*

**2.** *Sean algoritmo1 y algoritmo2, 2 implementaciones distintas de una tarea cuyo resultado es el mismo. Se sabe además el tiempo de ejecución de estos algoritmos:*

***algoritmo1** tiene $𝑇_1(𝑛) = 10n$*

***algoritmo2** tiene $𝑇_2(𝑛) = 4n^2$*

**2.1.** ***Grafique** $𝑇_1(n)$ y $T_2(n)$ en el sistema de coordenadas cartesianas.*

**2.2.** ***Justifique analíticamente** cuando recomendaría usar el **algoritmo1** y cuando usar el **algoritmo2**.*

**3.** *Determinar si las siguientes sentencias son verdaderas o falsas, justificando la respuesta. Sudemostración debe hacer uso de la definición de Big-O.*

**3.1.** *$3n$ es de $O(2^n)$*

**3.2.** *$n/log_2(n)$ es de $O(log_2(n))$*

**3.3.** *$n+log2(n)$ es de $O(n)$*

**3.4.** 
$
\begin{cases}
    3n + 17, & \text{si } n < 100 \\ 
    317, & \text{si } 𝑛 >= 100 
\end{cases}
$
**tiene orden lineal.**

**3.5.** *$2^{2n}$ es de $O(2n)$*

**3.6.** *Si $p(n)$ es un polinomio de grado $k$, entonces $p(n)$ es $O(n^k)$. Para esta demostración,considere que si $p(n)=a_k n^k + ... + a_1n + a_0$,utilizar como constante a $M = |a_k| + ... + |a_1| + |a_0|$*

**3.7.** 
$
\begin{cases}
    n^2, & \text{si } n ≤ 100 \\ 
    n, & \text{si } n > 100 
\end{cases}
$
**tiene orden cuadratico.**

**3.8.** *$2^{n+1}$ es de $O(2^n)$*

**4.** *Para cada uno de los algoritmos presentados:*

**a.** *Expresar en función de n el tiempo de ejecución.*

**b.** *Establecer el orden de dicha función usando notación Big-O*

*En el caso de ser necesario tenga presente que:*

$$\sum_{i=1}^n i^4 = \frac{n(n+1)(6n³+9n²+n-1)}{30}$$

$$\sum_{i=1}^n i^2 = \frac{n(n+1)(2n+1)}{6}$$

**4.1.**
```Java
public static void uno (int n) {
    int i, j, k ;
    int [] [] a, b, c;
    a = new int [n] [n];
    b = new int [n] [n];
    c = new int [n] [n];
    for ( i=1; i<=n-1; i++) {
        for ( j=i+1; j<=n; j++) {
            for ( k=1; k<=j; k++) {
                c[i][j] = c[i][j]+ a[i][j]*b[i][j];
            }
        }
    }
}
```

**4.2.**
```Java
public static void dos (int n){
    int i, j, k, sum;
    sum = 0;
    for ( i=1; i<=n; i++) {
        for ( j=1; j <= i*i; j++) {
            for ( k=1; k<= j; k++) {
                sum = sum + 1;
            }
        }
    }
}
```
**5.** *Para cada uno de los algoritmos presentados calcule el $T(n)$.*

**5.1.**
```Java
int c = 1;
while ( c < n ) {
    algo_de_O(1)
    c = 2 * c;
}
```
**5.2.**
```Java
int c = n;
while ( c > 1 ) {
    algo_de_O(1)
    c = c / 2
} 
```
**5.3.**
```Java
int x=1;
for (int i = 1; i < n; i = i+4)
    for (int j = n; j > 1; j = |j/4|)
        for (int k = 1; k < n; k = k*2)
            x = x+1;
```

**6.** *En complejidad computacional, se dice que el orden de ejecución de un algoritmo es el orden de la cantidad de veces de la instrucción más utilizada del mismo.*

**6.1.** *Dado el siguiente algoritmo, determine el valor de la variable suma.*
```Java
private int suma(int n){
    int suma=1;
    for (int i=1;i<=n;i++)
        for (int j=1;j<=i;j++)
            suma = suma + 1;
    return suma;
}
```

**6.2.** *Determine el $T(n)$ del algoritmo previo.*

**6.3.** *Dado el siguiente algoritmo, determine el valor de la variable producto.*
```Java
private int producto(int n){
    int producto=1;
    for (int i=1;i<=n;i++)
        for (int j=1;j<=i;j++)
            producto= 2*producto
    return producto;
}
```
**7.** *Para cada uno de los siguientes fragmentos de código, determine en forma intuitiva el orden de ejecución:*

**7.1.**
```Java
for(int i = 0; i< n; i++)
    sum++;
```
**7.2.**
```Java
for(int i = 0; i< n; i+=2)
    sum++;
```
**7.3.**
```Java
for(int i = 0; i< n; i++)
    for(int j = 0; j< n; j++)
        sum++;
```
**7.4.**
```Java
for(int i = 0; i< n; i++)
    for(int j = 0; j< n*n; j++)
        sum++;
```

___
### ***Parte B -  Tiempo de Ejecución***

**1.** ***Cálculo del tiempo de ejecución en algoritmos recursivos***

**1.1.** *Exprese la función del tiempo de ejecución de cada uno de los siguientes algoritmos, resuélvala y calcule el orden.*

**1.2.** *Comparar el tiempo de ejecución del método ‘rec2’ con el del método ‘rec1’.*

**1.3.** *Implementar un algoritmo más eficiente que el del método rec3 (es decir que el $T(n)$ sea menor).*

```Java
public class Recurrencia {
    static public int rec2(int n){
        if(n <= 1)
            return 1;
        else
            return (2 * rec2(n-1));
    }
    static public int rec1(int n){
        if(n <= 1)
            return 1;
        else
            return (rec1(n-1) + rec1(n-1));
    }
    static public int rec3(int n){
        if(n == 0)
            return 0;
        else {
            if(n == 1 )
                return 1;
            else
                return (rec3(n-2) * rec3(n-2));
        }
    }
    static public int potencia_iter(int x, int n){
        int potencia;
        if(n == 0)
            potencia = 1;
        else {
            if(n == 1)
                potencia = x;
            else{
                potencia = x;
                for (int i = 2 ; i <= n ; i++) {
                    potencia *= x ;
                }
            }
        }
        return potencia;
    }
    static public int potencia_rec(int x, int n){
        if(n == 0)
            return 1;
        else{
            if( n == 1)
                return x;
            else{
                if ((n % 2) == 0)
                    return potencia_rec (x * x, n / 2 );
                else
                    return potencia_rec (x * x, n / 2) * x;
            }
        }
    }
}
```

**2.** *Dado el siguiente método, plantear y resolver la función de recurrencia:*

```Java
int funcion(int n) {
    int x = 0;
    if (n <= 1)
        return 1;
    else {
        for (int i = 1; i < n; i++) {
            x = 1;
            while (x < n) {
                x = x * 2;
            }
        }
        return funcion(n/2) + funcion(n/2);
    }
}
```

**3.** *Resolver las siguientes recurrencias*

**3.1.**
$$T(n) = 
\begin{cases}
    2, & \text{si } n = 1 \\
    T(n-1) + n, & \text{si } n >= 2
\end{cases}
$$

**3.2.**
$$T(n) = 
\begin{cases}
    2, & \text{si } n = 1 \\
    T(n-1) + \frac{n}{2}, & \text{si } n >= 2
\end{cases}
$$

**3.3.**
$$T(n) = 
\begin{cases}
    1, & \text{si } n = 1 \\
    4T(\frac{n}{2}) + n², & \text{si } n >= 2
\end{cases}
$$

**3.4.**
$$T(n) = 
\begin{cases}
    1, & \text{si } n = 1 \\
    8T(\frac{n}{2}) + n³, & \text{si } x >= 2
\end{cases}
$$
___