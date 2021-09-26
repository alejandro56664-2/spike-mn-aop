package co.com.spike.lambda.demo.my.function.mdc.controller;

import co.com.spike.lambda.demo.my.function.mdc.model.request.Request;
import co.com.spike.lambda.demo.my.function.mdc.model.response.Response;
import co.com.spike.lambda.demo.my.function.mdc.service.TransferService;
import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Introspected
@Slf4j
public class LambdaController extends MicronautRequestHandler<Request, Response> {
  @Inject
  TransferService lambdaService;

  @Value("${micronaut.application.useMDC}")
  boolean useMDC;

  @Override
  public Response execute(final Request input) {
    if(useMDC){
      return transferWithMDC(input);
    } else {
      return transfer(input);
    }
  }

  protected Response transferWithMDC(final Request input){
    MDC.put("transaction.id", input.getTransactionId());
    MDC.put("transaction.sender", input.getSender());
    Response response = transfer(input);
    MDC.clear();
    return response;
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
