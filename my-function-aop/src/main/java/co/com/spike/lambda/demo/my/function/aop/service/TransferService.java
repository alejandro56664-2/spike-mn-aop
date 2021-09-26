package co.com.spike.lambda.demo.my.function.aop.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TransferService {
  /**
   * Por Ejecuta una transferencia
   * @param amount
   * @return valor booleano: true, si fue exitosa, false, si no se pudo realizar
   */
  public abstract Boolean transfer(Long amount);


  /**
   *
   * @param amount
   */
  public void beforeTransfer(Long amount) {
    log.info("Preparando transferencia: $ {}", amount);
  }

  /**
   *
   * @param amount
   * @param outcome
   */
  public void afterTransfer(Long amount, Boolean outcome) {
    log.info("La transferencia de: $ {} fue exitosa? {}", amount, outcome);
  }
}
