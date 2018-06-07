package com.cedarsoft.otec.decorator;

/**
 * Returns the number from 1...n
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultCounter implements Counter {
  private int current = 0;

  @Override
  public int nextValue() {
    current++;
    return current;
  }
}
