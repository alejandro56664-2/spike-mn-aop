package co.com.spike.lambda.demo.my.function.aop.advice.introduction;

import java.time.LocalDateTime;

@Stub
public interface StubExample {

  @Stub("10")
  int getNumber();

  LocalDateTime getDate();
}
