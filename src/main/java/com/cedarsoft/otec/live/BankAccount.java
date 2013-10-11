package com.cedarsoft.otec.live;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface BankAccount {


  void addTransaction( DefaultBankAccount.Transaction transaction ) throws TransactionDeclinedException;

  int calculateSaldo();
}
