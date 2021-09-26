package co.com.spike.lambda.demo.my.function.aop.advice.logging;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

class LoggingTest {

  @Test
  void testLogging(){
    try (ApplicationContext applicationContext = ApplicationContext.run()) {
      LoggingExample loggingExample = applicationContext.getBean(LoggingExample.class);

      String result = loggingExample.doWork("tarea1");

      assertNotNull(result);
    }
  }

}
