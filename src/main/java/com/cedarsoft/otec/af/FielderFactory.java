package com.cedarsoft.otec.af;

import java.awt.Color;

/**
 * Creates a fielder
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class FielderFactory extends AbstractPlayerFactory {
  @Override
  public Jersey createJersey(int number) {
    return new Jersey(Color.WHITE, number);
  }

  @Override
  public Trunks createTrunks() {
    return new Trunks(Color.BLACK);
  }

}
