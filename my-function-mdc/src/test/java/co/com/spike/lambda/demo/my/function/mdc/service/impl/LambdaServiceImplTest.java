package co.com.spike.lambda.demo.my.function.mdc.service.impl;

import co.com.spike.lambda.demo.my.function.mdc.config.ConfigRetriever;
import co.com.spike.lambda.demo.my.function.mdc.model.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LambdaServiceImplTest {

  @Mock ConfigRetriever configRetriever;

  @InjectMocks private static LambdaServiceImpl service;

  //TODO: Procure agregar siempre pruebas que agreguen valor para el negocio.
  @Test
  @DisplayName("Dummy Test")
  void executeTest() {
    // Se sugiere usar el patrón AAA para la escritura de pruebas.
    //Arrange
    String lisa = "Lisa Simpson";

    //Act
    Response result = service.get(lisa);

    //Assert
    assertNotNull(result);
    //Considere agregar más validaciones para el resultado.
  }
}
