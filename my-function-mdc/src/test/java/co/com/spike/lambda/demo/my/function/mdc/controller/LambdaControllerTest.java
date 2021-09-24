package co.com.spike.lambda.demo.my.function.mdc.controller;

import co.com.spike.lambda.demo.my.function.mdc.model.request.Request;
import co.com.spike.lambda.demo.my.function.mdc.model.response.Response;
import co.com.spike.lambda.demo.my.function.mdc.service.ILambdaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LambdaControllerTest {

  @InjectMocks private static LambdaController lambdaController;

  @Mock static ILambdaService lambdaService;

  @Test
  void executeTest() {
    Response output = lambdaController.execute(Request.builder().build());
    Assertions.assertNull(output);
  }
}
