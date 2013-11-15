package com.cedarsoft.otec;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class AddressBook {
  private final Map<Integer, Receiver> receivers = new HashMap<Integer, Receiver>();

  public Receiver getEntry( int id ) {
    Receiver found = receivers.get( id );
    if ( found == null ) {
      throw new IllegalArgumentException( "No entry found for id <" + id + ">" );
    }
    return found;
  }

  public void store( int id, Receiver receiver ) {
    receivers.put( id, receiver );
  }

  public Receiver delete( int id ) {
    return receivers.remove( id );
  }

  public int getSize() {
    return receivers.size();
  }
}
