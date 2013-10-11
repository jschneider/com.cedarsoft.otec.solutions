package com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceBuilder {
  private final List<LineItem> lineItems = new ArrayList<LineItem>();

  private final InvoiceHeaderFactory headerFactory;

  private Receiver receiver;

  public InvoiceBuilder( InvoiceHeaderFactory headerFactory ) {
    this.headerFactory = headerFactory;
  }

  public void addLineItem( LineItem lineItem ) {
    this.lineItems.add( lineItem );
  }

  public Receiver getReceiver() {
    return receiver;
  }

  public void setReceiver( Receiver receiver ) {
    this.receiver = receiver;
  }

  public Invoice build() {
    if ( receiver == null ) {
      throw new IllegalStateException( "No receiver set" );
    }

    return new Invoice( headerFactory.createHeader( receiver ), lineItems );
  }
}
