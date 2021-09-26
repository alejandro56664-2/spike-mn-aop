package co.com.spike.lambda.demo.my.function.aop.advice.around;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotNullTest {

  @Test
  void testNotNull(){
    try (ApplicationContext applicationContext = ApplicationContext.run()) {
      NotNullExample exampleBean = applicationContext.getBean(NotNullExample.class);

      //Assert & Act
      IllegalArgumentException ex =
      assertThrows(IllegalArgumentException.class, () -> {
        //Act
        exampleBean.doWork(null);
      });

      //Assert cont.
      assertEquals("Null parameter [taskName] not allowed", ex.getMessage());

    }
  }

}
