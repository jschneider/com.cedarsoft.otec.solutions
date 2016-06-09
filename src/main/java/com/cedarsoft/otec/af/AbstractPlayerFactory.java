package com.cedarsoft.otec.af;

import java.util.List;

/**
 * Abstract factory for soccer players
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public abstract class AbstractPlayerFactory {
  public abstract Jersey createJersey(int number);

  public abstract Trunks createTrunk();
}
