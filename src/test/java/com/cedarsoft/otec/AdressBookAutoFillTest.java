package com.cedarsoft.otec;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class AdressBookAutoFillTest {
  @Test
  public void testIt() throws Exception {
    Article articleA = new DefaultArticle( "Artikel A", new Money( 507 ) );
    Article articleB = new DefaultArticle( "Artikel B", new Money( 407 ) );
    Article articleC = new DefaultArticle( "Artikel C", new Money( 307 ) );


    final AddressBook addressBook = new AddressBook();
    Journal journal = new Journal( "daJournal" );

    DefaultInvoiceHeaderFactory headerFactory = new DefaultInvoiceHeaderFactory();


    //Store the receivers into the address book
    journal.addListener(new JournalListener() {
      private final StoreToAddressBookVisitor storeToAddressBookVisitor = new StoreToAddressBookVisitor(addressBook);
      @Override
      public void childAdded(Journal source, HasValue child) {
        child.accept(storeToAddressBookVisitor);
      }
    });


    journal.addChild( new InvoiceBuilder()
                        .setHeader( headerFactory.createHeader( new Receiver( "Markus Mustermann", "Dofstraße 7" ) ) )
                        .setSalesTaxCalculator( new FlatSalesTaxCalculator( 0.19 ) )
                        .addLineItem( new LineItem( 5, articleA ) )
                        .addLineItem( new LineItem( 7, articleB )
                        ).build() );

    journal.addChild( new InvoiceBuilder()
                        .setHeader( headerFactory.createHeader( new Receiver( "Paula Panther", "Musterstraße 11" ) ) )
                        .setSalesTaxCalculator( new FlatSalesTaxCalculator( 0.19 ) )
                        .addLineItem( new LineItem( 1, articleC ) )
                        .addLineItem( new LineItem( 400, articleB )
                        ).build() );


    assertThat(addressBook.getSize()).isEqualTo(2);
    assertThat(addressBook.getEntry(1).getName()).isEqualTo("Markus Mustermann");
    assertThat(addressBook.getEntry(2).getName()).isEqualTo("Paula Panther");
  }

  private static class StoreToAddressBookVisitor implements HasValueVisitor {
    private final AddressBook addressBook;
    //Im echten Leben, würde diese ID natürlich automatisch vergeben werden.
    private int index = 0;

    StoreToAddressBookVisitor(AddressBook addressBook) {
      this.addressBook = addressBook;
    }

    @Override
    public void visit(Journal journal) {
    }

    @Override
    public void visit(Invoice invoice) {
      index++;
      addressBook.store(index, invoice.getHeader().getReceiver());
    }

    @Override
    public void visit(LineItem lineItem) {
    }

    @Override
    public void visit(Article article) {
    }
  }
}
