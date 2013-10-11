package com.cedarsoft.otec;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class SecondHandArticle implements Article {
  private final Article article;

  private final double discount;

  public SecondHandArticle( @Nonnull Article article, double discount ) {
    this.article = article;
    this.discount = discount;
  }

  @Override
  public String getDescription() {
    return article.getDescription() + " (gebraucht)";
  }

  @Override
  public boolean isReducedSalesTax() {
    return article.isReducedSalesTax();
  }

  @Override
  public Money getValue() {
    return article.getValue().multiply( 1 - discount );
  }

  @Override
  public void accept( HasValueVisitor visitor ) {
    visitor.visit( article );
  }
}
