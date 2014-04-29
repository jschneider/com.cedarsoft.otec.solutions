package com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Invoice {
  private final List<LineItem> lineItems;

  public Invoice(List<LineItem> lineItems) {
    this.lineItems = new ArrayList<LineItem>(lineItems);
  }

  public List<LineItem> getLineItems() {
    return Collections.unmodifiableList( lineItems );
  }

  public Money getSum() {
    Money sum = new Money( 0 );

    for ( LineItem lineItem : lineItems ) {
      sum = sum.add( lineItem.getSum() );
    }
    return sum;
  }
}
