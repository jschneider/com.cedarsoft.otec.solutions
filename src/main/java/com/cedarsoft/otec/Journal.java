package com.cedarsoft.otec;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Contains a list of invoices for one day
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Journal extends AbstractHasValueParent {
  private final String description;

  public Journal( String description ) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void addChild( HasValue hasValue ) {
    this.children.add( hasValue );
  }

  @Override
  public void accept( HasValueVisitor visitor ) {
    visitor.visit( this );
  }

  private final List<JournalListener> listeners = new CopyOnWriteArrayList<JournalListener>();

  public void addListener(JournalListener listener) {
    this.listeners.add(listener);
  }

  public void removeListener(JournalListener listener) {
    this.listeners.remove(listener);
  }
}
