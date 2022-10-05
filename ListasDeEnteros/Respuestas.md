### 1.4. ¿Qué diferencia encuentra entre las implementaciones de los puntos anteriores?

En cuanto a la implementación del código de las clases de test la única diferencia es que una solución está implementada con ListaDeEnterosConArreglos y la otra con ListaDeEnterosEnlazada, que al nosotros abstraernos de como se encuentran implementadas, utilizamos el mismo comportamiento o métodos en común que tienen ambas clases.

### 1.7. Analice las implementaciones de la clase ListaDeEnteros y sus subclases.

### a) ¿Podría darle comportamiento a algún método de la superclase ListaDeEnteros?

En ambas implementaciones el código del método tamanio() es el mismo en ambas clases, por lo tanto podría definirse en su clase padre.

### ¿Por qué la clase se define como abstracta? Note que una subclase implementa la lista usando un arreglo de tamaño fijo y la otra usando nodos enlazados.

Se define como clase abstracta porque es una clase que no se puede instanciar y sus subclases están obligadas a definir el compartamiento que se definio en ella pero no le interesa como se implementen, eso lo delega a cada subclase.

### b) Considerando los enlaces entre nodos, ¿qué diferencias existen entre agregar un nodo al principio de la lista, agregar un nodo en el medio y agregar un nodo al final?

Agregar al principio es reutilizar el método agregar en y pasarle una posición. Agregar en medio utilizarias el metodo agregarEn(tamanio()/2) lo que haría una actualización de los punteros de los nodos del medio. Agregar al final del arreglo, se instancia un nuevo nodo, se actualizan los punteros y se incrementa el tamaño de la lista.

### c) Una lista implementada con arreglos, ¿tiene su primer elemento en el índice del vector: 0, 1 o depende de la implementación?

Tiene su primer elemento en el indice 0, porque los arreglos en Java inician en 0.

## 2. Tipos genéricos

### 2.1. ¿Podría resolver los ejercicios del punto 1 utilizando lista génericas?

Sí, se puede utilizando la clase wrapper <Integer>
