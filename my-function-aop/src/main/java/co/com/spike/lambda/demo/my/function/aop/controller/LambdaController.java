package co.com.spike.lambda.demo.my.function.aop.controller;

import co.com.spike.lambda.demo.my.function.aop.model.request.Request;
import co.com.spike.lambda.demo.my.function.aop.model.response.Response;
import co.com.spike.lambda.demo.my.function.aop.service.TransferService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Introspected
@Slf4j
public class LambdaController extends MicronautRequestHandler<Request, Response> {
  @Inject
  TransferService lambdaService;

  @Override
  public Response execute(final Request input) {
    return transfer(input);
  }

  protected Response transfer(final Request input){
    Boolean resultTransfer = lambdaService.transfer(input.getAmount());
    if (Boolean.TRUE.equals(resultTransfer)){
      return Response.success("transferencia exitosa");
    } else {
      return Response.failed("transferencia falló, la cantidad a transferir no es valida");
    }
  }
}
