package com.cedarsoft.otec;

import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class BackdateHeaderFactoryTest {
  @Test
  public void testName() throws Exception {
    InvoiceHeaderFactory headerFactory = new BackdateInvoiceHeaderFactory();

    InvoiceBuilder invoiceBuilder = new InvoiceBuilder( );
    invoiceBuilder.setHeader( headerFactory.createHeader( new Receiver( "daName", "daAddress" ) ) );
    invoiceBuilder.addLineItem( new LineItem( 2, "Item1", new Money( 101 ) ) );
    invoiceBuilder.addLineItem( new LineItem( 3, "Item2", new Money( 301 ) ) );

    Invoice invoice = invoiceBuilder.build();
    assertEquals( 2, invoice.getLineItems().size() );
    assertEquals( 2 * 101 + 3 * 301, invoice.getSum().getCents() );


    //Check that the date is old
    assertThat( invoice.getHeader().getDate() )
      .isLessThan( System.currentTimeMillis() )
      .isLessThan( System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 10 + 1000 )
    ;

    assertTrue( "header date: <" + invoice.getHeader().getDate() + "> now: <" + System.currentTimeMillis() + ">", System.currentTimeMillis() - invoice.getHeader().getDate() < 1000 * 60 * 60 * 24 * 10 + 1000 );
  }
}
