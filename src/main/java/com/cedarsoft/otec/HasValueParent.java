package com.cedarsoft.otec;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class HasValueParent<T extends HasValue> implements HasValue {
  protected final List<T> children = new ArrayList<T>();

  public HasValueParent() {
  }

  public HasValueParent( Collection<? extends T> children ) {
    this.children.addAll( children );
  }

  public List<? extends T> getChildren() {
    //noinspection ReturnOfCollectionOrArrayField
    return children;
  }

  @Override
  public Money getValue() {
    Money sum = new Money( 0 );
    for ( HasValue child : children ) {
      sum = sum.add( child.getValue() );
    }
    return sum;
  }
}
