package co.com.spike.lambda.demo.my.function.powertools.enums;
 
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParamKey {
  // TODO: por favor recuerde que debe tener las claves necesarias en el AWS System Manager.
  /**
   * Recuerde usar siempre el formato (en la enumeración) path.to.key a (en AWS SSM) path/to/key
   * También tenga presente que es una buena idea siempre usar el repo de parametros.
   */
  FUNCTION_NAME("my-function-powertools");

  private final String value;
}
