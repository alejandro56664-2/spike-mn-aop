package co.com.spike.lambda.demo.my.function.aop.controller;

import co.com.spike.lambda.demo.my.function.aop.model.request.Request;
import co.com.spike.lambda.demo.my.function.aop.model.response.Response;
import co.com.spike.lambda.demo.my.function.aop.service.TransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LambdaControllerTest {

  @InjectMocks private static LambdaController lambdaController;

  @Mock static TransferService lambdaService;

  @Test
  void executeTest() {
    Response output = lambdaController.execute(Request.builder().build());
    Assertions.assertNotNull(output);
  }
}
