package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultArticle implements Article {
  private final String description;
  private final Money price;

  private final boolean reducedSalesTax;

  public DefaultArticle( String description, Money price ) {
    this( description, price, false );
  }

  public DefaultArticle( String description, Money price, boolean reducedSalesTax ) {
    this.description = description;
    this.price = price;
    this.reducedSalesTax = reducedSalesTax;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public boolean isReducedSalesTax() {
    return reducedSalesTax;
  }

  @Override
  public Money getValue() {
    return price;
  }

  @Override
  public void accept( HasValueVisitor visitor ) {
    visitor.visit( this );
  }
}
