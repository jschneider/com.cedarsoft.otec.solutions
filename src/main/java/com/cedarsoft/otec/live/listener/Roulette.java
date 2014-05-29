package com.cedarsoft.otec.live.listener;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Roulette {
  @Nonnull
  private final List<Listener> listeners = new CopyOnWriteArrayList<Listener>();

  public void addListener( @Nonnull Listener listener ) {
    this.listeners.add( listener );
  }

  public void removeListener( @Nonnull Listener listener ) {
    this.listeners.remove( listener );
  }

  public int nextSpin() {
    int number = ( int ) ( Math.random() * 37 );

    for ( Listener listener : listeners ) {
      listener.spinned( this, number );
    }

    return number;
  }
}
