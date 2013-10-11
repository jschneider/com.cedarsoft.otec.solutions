package com.cedarsoft.otec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceFinder implements HasValueVisitor {

  private final List<Invoice> foundInvoices = new ArrayList<Invoice>();
  private final Article articleToFind;

  public InvoiceFinder( Article articleToFind ) {
    this.articleToFind = articleToFind;
  }

  public List<? extends Invoice> findInvoices( HasValue parent ) {
    foundInvoices.clear();
    parent.accept( this );
    return Collections.unmodifiableList( foundInvoices );
  }

  @Override
  public void visit( Journal journal ) {
    visitChildren( journal );
  }

  private Invoice currentInvoice;

  @Override
  public void visit( Invoice invoice ) {
    this.currentInvoice = invoice;
    visitChildren( invoice );
    this.currentInvoice = null;
  }

  @Override
  public void visit( LineItem lineItem ) {
    lineItem.getArticle().accept( this );
  }

  @Override
  public void visit( Article article ) {
    if ( article.equals( articleToFind ) ) {
      if ( currentInvoice != null ) {
        foundInvoices.add( currentInvoice );
      }
    }
  }

  private void visitChildren( AbstractHasValueParent parent ) {
    for ( HasValue child : parent.getChildren() ) {
      child.accept( this );
    }
  }
}
