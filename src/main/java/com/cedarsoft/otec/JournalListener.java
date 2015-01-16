package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface JournalListener {
  /**
   * Is called whenever a new child is added to the journal
   */
  void childAdded(Journal source, HasValue child);
}
