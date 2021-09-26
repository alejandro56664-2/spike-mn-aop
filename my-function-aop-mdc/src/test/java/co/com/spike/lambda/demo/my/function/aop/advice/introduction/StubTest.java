package co.com.spike.lambda.demo.my.function.aop.advice.introduction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

class StubTest {

  @Test
  void testStub(){
    try (ApplicationContext applicationContext = ApplicationContext.run()) {
      StubExample stubExample = applicationContext.getBean(StubExample.class);

      assertEquals(10, stubExample.getNumber());
      assertNull(stubExample.getDate());
    }
  }

}
