package com.cedarsoft.otec.decorator;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Mod3Decorator implements Counter {
  private final Counter decorated;

  public Mod3Decorator(Counter decorated) {
    this.decorated = decorated;
  }

  @Override
  public int nextValue() {
    int value = decorated.nextValue();

    if (value % 3 == 0) {
      System.out.println(value +" ist durch 3 teilbar");
    }

    return value;
  }
}
