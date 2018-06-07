package com.cedarsoft.otec.decorator;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Mod3And4Decorator implements Counter {
  private final Counter decorated;

  public Mod3And4Decorator(Counter decorated) {
    this.decorated = decorated;
  }

  @Override
  public int nextValue() {
    int value = decorated.nextValue();

    if (value % 3 == 0 && value % 4 == 0) {
      return -1;
    }

    return value;
  }
}
