package co.com.spike.lambda.demo.my.function.mdc.service.impl;

import co.com.spike.lambda.demo.my.function.mdc.model.response.Response;
import co.com.spike.lambda.demo.my.function.mdc.config.ConfigRetriever;
import co.com.spike.lambda.demo.my.function.mdc.service.ILambdaService;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class LambdaServiceImpl implements ILambdaService {

  @Inject ConfigRetriever configRetriever;

  @Override
  public Response get(String message) {
    configRetriever
        .getConfiguration()
        .ifPresent(c -> log.info("Configuración disponible: {}", c.toString()));

    return Response.builder().message("echo: " + message).build();
  }
}
