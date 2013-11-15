package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InsertCommand implements Command {
  private final Receiver receiver;
  private final int id;

  private final AddressBook addressBook;

  public InsertCommand( int id, Receiver receiver, AddressBook addressBook ) {
    this.id = id;
    this.receiver = receiver;
    this.addressBook = addressBook;
  }

  @Override
  public void execute() {
    addressBook.store( id, receiver );
  }

  @Override
  public void undo() {
    addressBook.delete( id );
  }
}
