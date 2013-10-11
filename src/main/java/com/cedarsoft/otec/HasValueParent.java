package com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class HasValueParent implements HasValue {
  protected final List<HasValue> children = new ArrayList<HasValue>();

  public HasValueParent() {
  }

  public HasValueParent( List<? extends HasValue> children ) {
    this.children.addAll( children );
  }

  public List<HasValue> getChildren() {
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
