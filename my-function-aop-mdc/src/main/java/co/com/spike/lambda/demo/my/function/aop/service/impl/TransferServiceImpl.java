package co.com.spike.lambda.demo.my.function.aop.service.impl;

import co.com.spike.lambda.demo.my.function.aop.advice.logging.Logging;
import co.com.spike.lambda.demo.my.function.aop.config.ConfigRetriever;
import co.com.spike.lambda.demo.my.function.aop.service.TransferService;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Singleton
@Slf4j
public class TransferServiceImpl extends TransferService {

  @Inject ConfigRetriever configRetriever;

  @Override
  //@Logging
  public Boolean transfer(Long amount) {
    return configRetriever
      .getConfiguration()
      .map(c -> {
        //"lógica de negocio"
        // MDC.put("config", c.toString());
        beforeTransfer(amount);
        boolean outcome = amount > 0;
        afterTransfer(amount, outcome);
        return outcome;
      })
      .orElse(false);
  }


}
