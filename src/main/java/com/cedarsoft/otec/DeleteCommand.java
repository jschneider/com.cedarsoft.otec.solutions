package com.cedarsoft.otec;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DeleteCommand implements Command {
  private final int id;
  private final AddressBook addressBook;
  private Receiver deleted;

  public DeleteCommand( int id, AddressBook addressBook ) {
    this.id = id;
    this.addressBook = addressBook;
  }

  @Override
  public void execute() {
    deleted = addressBook.delete( id );
  }

  @Override
  public void undo() {
    addressBook.store( id, deleted );
  }
}
