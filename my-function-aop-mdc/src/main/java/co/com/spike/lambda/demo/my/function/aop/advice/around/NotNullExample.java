package co.com.spike.lambda.demo.my.function.aop.advice.around;

import javax.inject.Singleton;

@Singleton
public class NotNullExample {

  @NotNull
  void doWork(String taskName) {
    System.out.println("Doing job: " + taskName);
  }
}
