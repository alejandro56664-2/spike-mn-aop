package co.com.spike.lambda.demo.my.function.aop.advice.logging;


import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class LoggingExample {

  @Logging
  String doWork(String taskName) {
    log.info("hola");
    return "La tarea: " + taskName + " se ejecutó";
  }
}
