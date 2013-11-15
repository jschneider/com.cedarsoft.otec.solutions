package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ReplaceCommand implements Command {
  private final Receiver receiver;
  private final int id;

  private final AddressBook addressBook;
  private Receiver old;

  public ReplaceCommand( int id, Receiver receiver, AddressBook addressBook ) {
    this.id = id;
    this.receiver = receiver;
    this.addressBook = addressBook;
  }

  @Override
  public void execute() {
    old = addressBook.delete( id );
    addressBook.store( id, receiver );
  }

  @Override
  public void undo() {
    addressBook.delete( id );
    addressBook.store( id, old );
  }
}
