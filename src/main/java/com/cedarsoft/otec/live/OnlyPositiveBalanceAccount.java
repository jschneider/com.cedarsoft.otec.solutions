package com.cedarsoft.otec.live;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class OnlyPositiveBalanceAccount implements BankAccount {
  private final BankAccount delegate;

  public OnlyPositiveBalanceAccount( BankAccount delegate ) {
    this.delegate = delegate;
  }

  public BankAccount getDelegate() {
    return delegate;
  }

  @Override
  public void addTransaction( DefaultBankAccount.Transaction transaction ) throws TransactionDeclinedException {
    int saldo = delegate.calculateSaldo();
    if ( saldo + transaction.getCents() < 0 ) {
      throw new TransactionDeclinedException();
    }

    delegate.addTransaction( transaction );
  }

  @Override
  public int calculateSaldo() {
    return delegate.calculateSaldo();
  }


}
