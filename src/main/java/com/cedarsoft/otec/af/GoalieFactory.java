package com.cedarsoft.otec.af;

import java.awt.Color;

/**
 * Creates a goalie
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class GoalieFactory extends AbstractPlayerFactory {
  @Override
  public Jersey createJersey(int number) {
    return new JerseyWithPadding(Color.GREEN, number);
  }

  @Override
  public Trunks createTrunks() {
    return new Trunks(Color.GREEN);
  }

}
