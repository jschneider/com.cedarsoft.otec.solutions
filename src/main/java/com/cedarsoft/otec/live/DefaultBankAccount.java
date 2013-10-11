package com.cedarsoft.otec.live;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultBankAccount implements BankAccount {
  private final List<Transaction> transactions = new ArrayList<Transaction>();

  @Override
  public void addTransaction( Transaction transaction ) {
    this.transactions.add( transaction );
  }

  public List<Transaction> getTransactions() {
    return Collections.unmodifiableList( transactions );
  }

  @Override
  public int calculateSaldo() {
    int sum = 0;
    for ( Transaction transaction : transactions ) {
      sum += transaction.getCents();
    }
    return sum;
  }

  public static class Transaction {
    private final int cents;
    private final String description;

    public Transaction( int cents, String description ) {
      this.cents = cents;
      this.description = description;
    }

    public int getCents() {
      return cents;
    }

    public String getDescription() {
      return description;
    }
  }

}
