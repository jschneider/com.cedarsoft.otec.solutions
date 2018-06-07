package com.cedarsoft.otec.decorator;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Mod4Decorator implements Counter {
  private final Counter decorated;

  public Mod4Decorator(Counter decorated) {
    this.decorated = decorated;
  }

  @Override
  public int nextValue() {
    int value = decorated.nextValue();

    if (value % 4 == 0) {
      System.out.println(value +" ist durch 4 teilbar");
    }

    return value;
  }
}
