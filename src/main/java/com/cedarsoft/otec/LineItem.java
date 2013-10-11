package com.cedarsoft.otec;

import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class LineItem implements HasValueParent {
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

  @Override
  public List<HasValue> getChildren() {
    return Collections.<HasValue>singletonList( article );
  }

  @Override
  public void accept( HasValueVisitor visitor ) {
    visitor.visit( this );
  }
}
