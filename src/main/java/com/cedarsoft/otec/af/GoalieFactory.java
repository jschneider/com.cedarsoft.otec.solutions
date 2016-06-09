package com.cedarsoft.otec.af;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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
  public Trunks createTrunk() {
    return new Trunks(Color.GREEN);
  }

  @Override
  public List<Object> createAccessories() {
    List<Object> accessories = new ArrayList<>();
    accessories.add(new Gloves());
    return accessories;
  }
}
