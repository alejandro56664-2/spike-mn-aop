# spike-mn-aop
Spike para el uso de AOP en Micronaut para el manejo de logs transaccionales en funciones lambda.

## Contenido

- [Motivación](#motivación)
- [Mapeo del contexto en los logs](#mapeo-del-contexto-en-los-logs)
- [Introducción AOP](#introducción-AOP)
- [PowerTools](#powertools)
- [Recursos para el desarrollador](#recursos-para-el-desarrollador)
- [Conclusión](#conclusión)
- [Referencias](#referencias)

---
## Motivación

## Mapeo del contexto en los logs

## Introducción AOP

## PowerTools

## Recursos para el desarrollador

Actualmente existen dos funciones:

- my-function-mdc 
- my-function-powertools

Cada una sirve de ejemplo para las tecnologías en cuestión.
El proyecto fue creado con el generador: [lambda-java-mn](https://github.com/alejandro56664-adl/spike-yeoman-aws-lambda)
### Build project

```bash
./gradlew clean build
```

### Run tests

```bash
./gradlew clean test
```

### Run my-function-mdc local with SAM

Handler: co.com.spike.lambda.demo.my.function.mdc.controller.LambdaController::execute

```bash
sam local invoke myfunctionmdc --event ./events/my-function-mdc-generic.json
```

### Run my-function-powertools local with SAM

Handler: co.com.spike.lambda.demo.my.function.powertools.controller.LambdaController::execute

```bash
sam local invoke myfunctionpowertools --event ./events/my-function-powertools-generic.json
```

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
- https://www.baeldung.com/mdc-in-log4j-2-logback
- https://dzone.com/articles/mdc-better-way-of-logging-1
- https://logback.qos.ch/manual/mdc.html
- https://awslabs.github.io/aws-lambda-powertools-java/core/logging/

