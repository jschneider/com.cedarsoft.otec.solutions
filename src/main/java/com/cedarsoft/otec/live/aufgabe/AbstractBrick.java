package com.cedarsoft.otec.live.aufgabe;

import java.awt.Color;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public abstract class AbstractBrick implements Brick {
  private final Color color;

  protected AbstractBrick( Color color ) {
    this.color = color;
  }

  @Override
  public Color getColor() {
    return color;
  }
}
