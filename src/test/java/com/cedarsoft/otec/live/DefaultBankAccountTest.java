package com.cedarsoft.otec.live;

import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultBankAccountTest {
  @Test
  public void testIt() throws Exception {
    BankAccount bankAccount = new DefaultBankAccount();

    assertThat( bankAccount.calculateSaldo() ).isEqualTo( 0 );
    bankAccount.addTransaction( new DefaultBankAccount.Transaction( 100, "einzahlung eines Euros" ) );
    assertThat( bankAccount.calculateSaldo() ).isEqualTo( 100 );
    bankAccount.addTransaction( new DefaultBankAccount.Transaction( -150, "auszahlung 1,50" ) );
    assertThat( bankAccount.calculateSaldo() ).isEqualTo( -50 );
  }


  @Test
  public void testOnlyPositive() throws Exception {
    BankAccount bankAccount = new OnlyPositiveBalanceAccount( new DefaultBankAccount() );

    assertThat( bankAccount.calculateSaldo() ).isEqualTo( 0 );
    bankAccount.addTransaction( new DefaultBankAccount.Transaction( 100, "einzahlung eines Euros" ) );
    assertThat( bankAccount.calculateSaldo() ).isEqualTo( 100 );

    try {
      bankAccount.addTransaction( new DefaultBankAccount.Transaction( -150, "auszahlung 1,50" ) );
      fail( "Where is the Exception" );
    } catch ( TransactionDeclinedException ignore ) {
    }
    bankAccount.addTransaction( new DefaultBankAccount.Transaction( -40, "auszahlung 0,40" ) );
    assertThat( bankAccount.calculateSaldo() ).isEqualTo( 60 );
  }
}
