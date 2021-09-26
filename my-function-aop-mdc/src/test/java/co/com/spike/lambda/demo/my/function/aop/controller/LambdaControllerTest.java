package co.com.spike.lambda.demo.my.function.aop.controller;

import static org.mockito.Mockito.*;

import co.com.spike.lambda.demo.my.function.aop.model.request.Request;
import co.com.spike.lambda.demo.my.function.aop.model.response.Response;
import co.com.spike.lambda.demo.my.function.aop.service.impl.LambdaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LambdaControllerTest {

  @Mock static LambdaServiceImpl lambdaService;

  @InjectMocks private static LambdaController lambdaController;

  @Test
  void executeTest() {
    //Arrange
    when(lambdaService.transfer(any(Request.class))).thenReturn(Response.success(""));

    //Act
    Response output = lambdaController.execute(Request.builder().build());

    //Assert
    Assertions.assertNotNull(output);
  }
}
