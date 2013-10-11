package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Article implements HasValue {
  private final String description;
  private final Money price;

  private final boolean reducedSalesTax;

  public Article( String description, Money price ) {
    this( description, price, false );
  }

  public Article( String description, Money price, boolean reducedSalesTax ) {
    this.description = description;
    this.price = price;
    this.reducedSalesTax = reducedSalesTax;
  }

  public String getDescription() {
    return description;
  }

  public boolean isReducedSalesTax() {
    return reducedSalesTax;
  }

  public Money getPrice() {
    return price;
  }

  @Override
  public Money getValue() {
    return price;
  }
}
