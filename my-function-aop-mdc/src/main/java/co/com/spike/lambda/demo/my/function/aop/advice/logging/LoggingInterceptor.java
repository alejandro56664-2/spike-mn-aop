package co.com.spike.lambda.demo.my.function.aop.advice.logging;

import co.com.spike.lambda.demo.my.function.aop.model.request.Request;
import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.type.Argument;
import java.util.Arrays;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Singleton
@Slf4j
@InterceptorBean(Logging.class)
public class LoggingInterceptor implements MethodInterceptor<Object, Object> {

  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {

    Arrays.stream(context.getArguments())
      .filter(a -> a.getType() == Request.class)
      .map(Argument::getName)
      .findFirst()
      .map(n -> (Request) context.getParameterValueMap().get(n))
      .ifPresent(r -> {
        MDC.put("transaction.id", r.getTransactionId());
        MDC.put("transaction.sender", r.getSender());
      });

    MDC.put("methodIntercepted", context.getMethodName());
    Object result = context.proceed();
    log.info("Salida: {}", result);
    return result;
  }
}
