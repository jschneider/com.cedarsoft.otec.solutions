package com.cedarsoft.otec;

import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class JournalTest {
  @Test
  public void testIt() throws Exception {
    Article articleA = new DefaultArticle( "Artikel A", new Money( 507 ) );
    Article articleB = new DefaultArticle( "Artikel B", new Money( 407 ) );
    Article articleC = new DefaultArticle( "Artikel C", new Money( 307 ) );


    Journal journal = new Journal( "daJournal" );

    DefaultInvoiceHeaderFactory headerFactory = new DefaultInvoiceHeaderFactory();

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


    assertThat( journal.getValue().asDouble() ).isEqualTo( 1684.91 );

    prettyPrint( journal );


    assertThat( new InvoiceFinder(articleA).findInvoices( journal ) ).hasSize( 1 ).contains( journal.getChildren().get( 0 ) );
    assertThat( new InvoiceFinder(articleB).findInvoices( journal ) ).hasSize( 2 ).contains( journal.getChildren().toArray() );

    //Only search a sub tree
    assertThat( new InvoiceFinder( articleB ).findInvoices( journal.getChildren().get( 0 ) ) ).hasSize( 1 ).contains( journal.getChildren().get( 0 ) );
  }

  private void prettyPrint( Journal journal ) {
    journal.accept( new PrettyPrinter() );
  }
}
