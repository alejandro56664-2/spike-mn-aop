# spike-mn-aop
Spike para el uso de AOP en Micronaut para el manejo de logs transaccionales en funciones lambda.

## Contenido

- [Motivación](#motivación)
- [Mapeo del contexto en los logs](#mapeo-del-contexto-en-los-logs)
- [Introducción AOP](#introducción-AOP)
- [Recursos para el desarrollador](#recursos-para-el-desarrollador)
- [Conclusión](#conclusión)
- [Referencias](#referencias)

---
## Motivación

Se requiere estandarizar el mecanismo de registros de auditoría para funciones lambda creadas usando
Micronaut utilizando una estrategia que no sobrecargue a los desarrolladores y permitiéndoles enfocarse 
en actividades que den valor al negocio.

Puede encontrar una presentación sobre mejores prácticas de logs en Java y MS [aquí](https://drive.google.com/file/d/1LCs9GN4KL1g4ol9u2Mk4HJsguuu5sFkc/view?usp=sharing).

## Mapeo del contexto en los logs

En la función ```my-function-aop-mdc``` se muestra un ejemplo para usar MDC con SLF4J.

- La arquitectura de SLF4J la podemos observar a continuación:

![diagrama de secuencia](https://logback.qos.ch/manual/images/chapters/architecture/underTheHoodSequence2.gif)
_Tomado de: https://logback.qos.ch/manual/underTheHood.html_

En esta podemos observar las diferentes capas que tiene el componente SLF4J.

Un mecanismo importante consiste en el MDC, el cual nos permite agregar gran cantidad de información de 
contexto, que puede ser muy útil a la hora de diagnosticar errores en ambientes productivos.

## Introducción AOP

La programación orientada a aspectos (AOP, por sus siglas en ingles) es un paradigma de programación
que busca incrementar la modularidad de las aplicaciones, permitiendo una clara separación de las preocupaciones
transversales (_cross-cutting concerns_) de la lógica de negocio principal.

### Aspecto

Un aspecto normalmente puede referirse a una capacidad que no está directamente relacionada
con la funcionalidad del sistema, pero tiene propiedades que impactan los atributos de calidad. 
En otras palabras, si en la programación orientada a objetos (OOP, por sus siglas en inglés) 
podemos definir la clase como unidad minima de modularidad, en AOP, esta unidad vendría siendo un _Aspecto_. 

### _Advice_

Se refiere al código adicional que resuelve la preocupación transversal. Representa el comportamiento adicional.

### _Join-point_

Se refiere a los puntos específicos del programa donde se va a "insertar" el _Advice_.

### _Point-cut_

Es el término dado a la especificación de los puntos de ejecución donde se inserta el _Advice_.
Detecta si un _join-point_ dado coincide con la especificación.

### _Weaving_

El lenguaje usado en este paradigma nos recuerda el mundo de la costura, por lo que 
podríamos hacer una analogía:

![aop analogía](./doc/assets/aop-analogy.png)

### AOP en Micronaut

Existen varias herramientas disponibles para realizar AOP con Java, entre las que se encuentran:
 - Aspectj
 - Spring AOP 
 - Micronaut AOP

Micronaut es un _framework_ que realiza inyección de dependencias sin hacer uso del mecanismo de _reflexión_ por lo 
al igual que las herramientas que provee para AOP. Por esta razón, se decide explorar a profundidad Micronaut AOP.

Los tipos de _Advice_ soportados por Micronaut son los siguientes:

- _Around Advice_: Se decora un método para agregar nuevo comportamiento.
- _Introduction Advice_: Introduce nuevo comportamiento a una clase existente. Ejemplo _Micronaut Data_,
en el cual se define una interfaz y el compilador agrega las implementaciones, introduciendo el nuevo comportamiento
  por el desarrollador.
  
- _Adapter Advice_: Permite introducir un nuevo _Bean_ que implemente un tipo SAM (_Single Abstract Method_), es decir,
una interfaz con un solo método.
  
En este spike se realizan pruebas de _Around Advice_ y _Introduction Advice_ y finalmente se realiza una implementación sencilla
de un Logger utilizando MDC.

## Recursos para el desarrollador

Actualmente existen una funcion:

- ```my-function-aop-mdc```: En esta función se revisa como crear un aspecto para el registro de logs con Micronaut, SLF4J y MDC.

El proyecto fue creado con el generador: [lambda-java-mn](https://github.com/alejandro56664-adl/spike-yeoman-aws-lambda)

### Build project

```bash
./gradlew clean build
```

### Run tests

```bash
./gradlew clean test
```

### Run my-function-aop-mdc local with SAM

Handler: co.com.spike.lambda.demo.my.function.aop.controller.LambdaController::execute

```bash
sam local invoke myfunctionaopmdc --event ./events/my-function-aop-mdc-generic.json
```

Pasos para realizar las pruebas:

1. Intente ejecutar la función localmente, activando y desactivando la bandera ```useMDC```.

2. Agregue las anotaciones ```@Logging``` en las clases ```LambdaServiceImpl``` y ```TransferServiceImpl```.

3. Puede ver el funcionamiento del mecanismo de AOP en Micronaut, ejecutando las pruebas del paquete ```Advice```.

Links de interés sobre Micronaut:

- [User Guide](https://docs.micronaut.io/2.5.5/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.5/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.5/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
- [Micronaut AWS Lambda Function documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambda)
- [AWS Lambda Handler](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)
---

## Conclusión

## Referencias

- https://docs.micronaut.io/latest/guide/index.html#aop
- https://micronaut.io/2019/10/07/micronaut-aop-awesome-flexibility-without-the-complexity/
- https://hinchman-amanda.medium.com/introduction-to-java-aspect-oriented-programming-a9769613131e

- https://www.baeldung.com/mdc-in-log4j-2-logback
- https://dzone.com/articles/mdc-better-way-of-logging-1
- https://logback.qos.ch/manual/mdc.html
