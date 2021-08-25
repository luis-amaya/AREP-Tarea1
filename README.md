# Look Stock

Este proyecto consiste en una App que consulte el mercado de valores y de acciones negociadas en Bolsa.
Mediante el uso de un identificador de accion, por ejemplo "MSFT" para Microsoft se muestra el historico de la valoracion intra-día. Se hace uso del API gratuito de [Alpha Vantage] ( https://www.alphavantage.co/documentation)

## Comenzando 🚀

Se presentaran un conjunto de instrucciones para que este pueda tener un funcionamiento correcto en maquina local.

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

Para un optimo funcionamiento del proyecto en un ambiente de desarrollo se debe contar con los siguientes Apps instaladas y configuradas (en el caso de Java y Maven):

- [Java](https://www.java.com/es/download/ie_manual.jsp) : Lenguaje y entorno de desarrollo
- [Maven](https://maven.apache.org/) : Gestor de dependencias
- [Spark](https://sparkjava.com/download) : Micro-framework para desarrollo web
- [Git](https://git-scm.com/) : Software para control de versiones

### Instalación 🔧

Para esto se puede utilizar cualquier shell que prefiera.

1. ***Clonar el proyecto***
    ```
    git clone https://github.com/luis-amaya/AREP-Tarea1
    ```

2. ***Compilar el proyecto***
   ````
   mvn package
   ````
3. ***Ejecucion del Proyecto***
   ````
   java $JAVA_OPTS -cp target/classes:target/dependency/* edu.escuelaing.arep.App
   ````
4 ***Entorno Web***
    ````
    localhost:4567/html/aplication.html
    ````
## Ejecutando las pruebas ⚙️

Para ejecutar las pruebas utilizar:
````
mvn test
````
## Despliegue 📦

El despliegue se puede encontrar en [Heroku](https://look-stock.herokuapp.com/html/aplication.html)

## Construido con 🛠️
Proyecto construido con:

* [Spark](https://sparkjava.com/download) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias


## Documentacion 📖
Para generar la documentacion utilizar:
````
mvn javadoc: javadoc
````


## Autores ✒️

***Luis Gerardo Amaya Ortiz***

## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles


Plantilla de README por: [Villanuevand](https://github.com/Villanuevand) 
