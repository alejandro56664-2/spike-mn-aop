package co.com.spike.lambda.demo.my.function.aop.model.response;

import io.micronaut.core.annotation.Introspected;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response {
  public static Response success(Object content){
    return new Response(content);
  }

  public static Response failed(String e){
    return new Response(e);
  }

  private Response(Object content){
    this.success = true;
    this.content = content;
  }

  private Response(String error){
    this.success = false;
    this.error = error;
  }

  Boolean success;
  Object content;
  String error;

}
