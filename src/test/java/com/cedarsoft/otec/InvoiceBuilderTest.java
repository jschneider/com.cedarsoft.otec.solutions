package com.cedarsoft.otec;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceBuilderTest {
  @Test
  public void testInvoiceBuilder() throws Exception {
    InvoiceBuilder invoiceBuilder = new InvoiceBuilder();
    invoiceBuilder.addLineItem( new LineItem( 2, "Item1", new Money( 101 ) ) );
    invoiceBuilder.addLineItem( new LineItem( 3, "Item2", new Money( 301 ) ) );

    Invoice invoice = invoiceBuilder.build();
    assertEquals( 2, invoice.getLineItems().size() );
    assertEquals( 2 * 101 + 3 * 301, invoice.getSum().getCents() );
  }
}
