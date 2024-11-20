# Algoritmos_de_ordenamiento
### Radix sort:
1. Recibe un arreglo de numeros unidimensional
2. Busca en el arreglo el numero con mayor numero de digitos
   - dependiendo del numero de digitos es el numero de veces que va a iterar
Ejemplo: numero con mayor cantidad de digitos "4567", entonces el algoritmo va a iterar 4 veces
3. En este caso iteraremos 4 veces, en el caso de que algun numero tenga menos de 4 numeros esas posiciones se rellenaran con 0 y lo tomaremos como digitos del numero
4. En cada iteracion vamos a tomar el digito de cada numero del arreglo y lo vamos a ordenar en "Cubetas" del 0 al 9
Por ejemplo, el primer numero del arreglo y analizamos su primer digito, en este caso usaremos el primer digito del numero 200
debido a que su primer digito es el 0 lo ubicaremos en la posicion 0 (Cubeta 0), y asi con cada numero (posicion) del arreglo en su respectiva "Cubeta"
luego que acabe de ordenar el arreglo en las "Cubetas" sacaremos en el orden como quedaron los numeros en las cubetas y los agregaremos EN ESE ORDEN de nuevo al arreglo.
5. Tomamos el arreglo con el nuevo orden y repetiremos el paso 4 pero en este caso con el 2do digito del numero
6. Iteraremos la cantidad de veces que definimos anteriormente hasta que se cumpla la cantidad de iteraciones.


 ### Ejercicio
1. Implementar el algoritmo Radix sort para un arreglo unidimensional en el sistema octal
2. Medir la complejidad del algoritmo implementado
3. Describir la funcion del algoritmo
4. Realizar la grafica para la funcion    
