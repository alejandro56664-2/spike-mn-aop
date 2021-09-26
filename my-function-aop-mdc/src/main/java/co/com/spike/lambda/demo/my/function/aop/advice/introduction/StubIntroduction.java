package co.com.spike.lambda.demo.my.function.aop.advice.introduction;

import io.micronaut.aop.*;
import io.micronaut.core.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
@InterceptorBean(Stub.class)
public class StubIntroduction implements MethodInterceptor<Object,Object> {

  @Nullable
  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {
    return context.getValue(
      Stub.class,
      context.getReturnType().getType()
    ).orElse(null);
  }
}
