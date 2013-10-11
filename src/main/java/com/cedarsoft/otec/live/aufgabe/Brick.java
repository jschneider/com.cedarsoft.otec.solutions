package com.cedarsoft.otec.live.aufgabe;

import java.awt.Color;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface Brick {
  /**
   * Returns the color for this brick
   * @return the brick
   */
  Color getColor();

  /**
   * Returns the description
   * @return the description
   */
  String getDescription();

  void accept( BrickVisitor visitor );
}
