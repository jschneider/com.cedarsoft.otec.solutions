package com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceBuilder {
  private final List<LineItem> lineItems = new ArrayList<LineItem>();

  public void addLineItem( LineItem lineItem ) {
    this.lineItems.add( lineItem );
  }

  public Invoice build() {
    return new Invoice( lineItems );
  }
}
