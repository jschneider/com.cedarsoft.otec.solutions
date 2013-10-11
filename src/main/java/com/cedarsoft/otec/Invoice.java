package com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Invoice {
  private final List<LineItem> lineItems;

  private final  InvoiceHeader header;

  public Invoice( InvoiceHeader header, List<LineItem> lineItems ) {
    this.header = header;
    this.lineItems = new ArrayList<LineItem>(lineItems);
  }

  public InvoiceHeader getHeader() {
    return header;
  }

  public List<LineItem> getLineItems() {
    return Collections.unmodifiableList( lineItems );
  }

  public Money getNetSum() {
    Money sum = new Money( 0 );

    for ( LineItem lineItem : lineItems ) {
      sum = sum.add( lineItem.getSum() );
    }
    return sum;
  }
}
