package com.cedarsoft.otec;

import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Invoice extends HasValueParent {
  private final InvoiceHeader header;
  private final SalesTaxCalculator salesTaxCalculator;

  public Invoice( InvoiceHeader header, List<LineItem> lineItems, SalesTaxCalculator salesTaxCalculator ) {
    super( lineItems );
    this.header = header;
    this.salesTaxCalculator = salesTaxCalculator;
  }

  public SalesTaxCalculator getSalesTaxCalculator() {
    return salesTaxCalculator;
  }

  public InvoiceHeader getHeader() {
    return header;
  }

  public List<HasValue> getLineItems() {
    return getChildren();
  }

  public Money getNetSum() {
    return getValue();
  }

  public Money getSalesTax() {
    return salesTaxCalculator.calculate( this );
  }

  public Money getGrossSum() {
    return getNetSum().add( getSalesTax() );
  }
}
