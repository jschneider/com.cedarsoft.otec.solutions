package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class LineItem implements HasValue{
  private final int amount;
  private final Article article;

  public LineItem( int amount, Article article ) {
    this.article = article;
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  public Article getArticle() {
    return article;
  }

  @Override
  public Money getValue() {
    return article.getValue().multiply( amount );
  }

  public Money getSum() {
    return getValue();
  }
}
