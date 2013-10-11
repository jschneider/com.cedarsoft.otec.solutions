package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface Article extends HasValue {
  String getDescription();

  boolean isReducedSalesTax();
}