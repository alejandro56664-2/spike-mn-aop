package co.com.spike.lambda.demo.my.function.powertools.model.response;
 
import io.micronaut.core.annotation.Introspected;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response {
  String message;
}
