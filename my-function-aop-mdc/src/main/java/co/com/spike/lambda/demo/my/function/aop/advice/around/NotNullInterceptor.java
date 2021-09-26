package co.com.spike.lambda.demo.my.function.aop.advice.around;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.type.MutableArgumentValue;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.inject.Singleton;

@Singleton //Es opcional, un nuevo interceptor debería ser creado por cada instancia.
@InterceptorBean(NotNull.class) //Indica con que anotación esta asociado el interceptor.
public class NotNullInterceptor implements MethodInterceptor<Object, Object> {

  @Nullable
  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {
    Optional<Map.Entry<String, MutableArgumentValue<?>>> nullParam = context.getParameters()
      .entrySet()
      .stream()
      .filter(entry -> {
        MutableArgumentValue<?> argumentValue = entry.getValue();
        return Objects.isNull(argumentValue.getValue());
      })
      .findFirst();
    if (nullParam.isPresent()) {
      throw new IllegalArgumentException("Null parameter [" + nullParam.get().getKey() + "] not allowed");
    }
    return context.proceed();
  }
}
