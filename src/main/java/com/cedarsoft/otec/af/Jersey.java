package com.cedarsoft.otec.af;

import java.awt.Color;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Jersey {
  private final Color color;
  private final int number;

  public Jersey(Color color, int number) {
    this.color = color;
    this.number = number;
  }

  public Color getColor() {
    return color;
  }

  public int getNumber() {
    return number;
  }
}
