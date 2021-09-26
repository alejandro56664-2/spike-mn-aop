package co.com.spike.lambda.demo.my.function.aop.service.impl;

import co.com.spike.lambda.demo.my.function.aop.config.ConfigRetriever;
import co.com.spike.lambda.demo.my.function.aop.model.Configuration;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LambdaServiceImplTest {

  @Mock ConfigRetriever configRetriever;

  @InjectMocks private static LambdaServiceImpl service;

  @BeforeEach
  void beforeEach(){
    when(configRetriever.getConfiguration()).thenReturn(Optional.of(Configuration.builder().build()));
  }

  //TODO: Procure agregar siempre pruebas que agreguen valor para el negocio.
  @Test
  @DisplayName("Debería realizar la transferencia, ya que la cantidad (amount) es mayor que 0")
  void shouldTransferSuccessfullyTest() {
    // Se sugiere usar el patrón AAA para la escritura de pruebas.
    //Arrange
    Long amount = 100L;

    //Act
    boolean result = service.transfer(amount);

    //Assert
    assertTrue(result);
  }
  @Test
  @DisplayName("Debería fallar la transferencia, ya que la cantidad (amount) es menor que 0")
  void shouldTransferFailedTest() {
    //Arrange
    Long amount = -100L;

    //Act
    boolean result = service.transfer(amount);

    //Assert
    assertFalse(result);
  }
}
