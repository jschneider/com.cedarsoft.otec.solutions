package com.cedarsoft.otec.live.aufgabe;

import java.awt.Color;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Cube2by2 extends AbstractBrick {
  public Cube2by2( Color color ) {
    super( color );
  }

  @Override
  public String getDescription() {
    return "88";
  }

  @Override
  public void accept( BrickVisitor visitor ) {
    visitor.visit( this );
  }
}
