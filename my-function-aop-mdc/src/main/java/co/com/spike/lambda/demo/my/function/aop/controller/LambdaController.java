package co.com.spike.lambda.demo.my.function.aop.controller;


import co.com.spike.lambda.demo.my.function.aop.model.request.Request;
import co.com.spike.lambda.demo.my.function.aop.model.response.Response;
import co.com.spike.lambda.demo.my.function.aop.service.impl.LambdaServiceImpl;
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
  LambdaServiceImpl lambdaService;

  @Value("${micronaut.application.useMDC}")
  boolean useMDC;

  @Override
  public Response execute(final Request input) {
    if(useMDC){
      MDC.put("transaction.id", input.getTransactionId());
      MDC.put("transaction.sender", input.getSender());
    }
    return lambdaService.transfer(input);
  }
}
