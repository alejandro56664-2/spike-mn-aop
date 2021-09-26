package co.com.spike.lambda.demo.my.function.aop.service.impl;

import co.com.spike.lambda.demo.my.function.aop.advice.logging.Logging;
import co.com.spike.lambda.demo.my.function.aop.config.ConfigRetriever;
import co.com.spike.lambda.demo.my.function.aop.model.request.Request;
import co.com.spike.lambda.demo.my.function.aop.model.response.Response;
import co.com.spike.lambda.demo.my.function.aop.service.TransferService;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class LambdaServiceImpl {

  @Inject TransferService lambdaService;

  //@Logging
  public Response transfer(final Request input){
    Boolean resultTransfer = lambdaService.transfer(input.getAmount());
    if (Boolean.TRUE.equals(resultTransfer)){
      return Response.success("transferencia exitosa");
    } else {
      return Response.failed("transferencia falló, la cantidad a transferir no es valida");
    }
  }


}
