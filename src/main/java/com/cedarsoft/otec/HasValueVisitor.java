package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface HasValueVisitor {
  void visit( Journal journal );

  void visit( Invoice invoice );

  void visit( LineItem lineItem );

  void visit( Article article );
}