package com.cedarsoft.otec;

import com.google.common.base.Strings;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class PrettyPrinter implements HasValueVisitor {
  private int depth;

  @Override
  public void visit( Journal journal ) {
    System.out.println( indent() + "--------------------------" );
    System.out.println( indent() + journal.getDescription() );
    System.out.println( indent() + "--------------------------" );
    visitChildren( journal );
    System.out.println( indent() + "--------------------------" );
    System.out.println( indent() + journal.getValue() );
  }

  @Override
  public void visit( Invoice invoice ) {
    System.out.println( indent() + invoice.getHeader().getInvoiceId() + " - " + invoice.getHeader().getReceiver().getName() );
    visitChildren( invoice );
    depth++;
    System.out.println( indent() + "--------------------------" );
    System.out.println( indent() + "Net:   " + invoice.getNetSum() );
    System.out.println( indent() + "Tax:   " + invoice.getSalesTax() );
    System.out.println( indent() + "Gross: " + invoice.getGrossSum() );
    depth--;
  }

  @Override
  public void visit( LineItem lineItem ) {
    System.out.println( indent() + lineItem.getAmount() + " " + lineItem.getArticle().getDescription() + " à " + lineItem.getArticle().getPrice().format() );
  }

  @Override
  public void visit( Article article ) {
    //do nothing
  }

  private void visitChildren( AbstractHasValueParent parent ) {
    depth++;
    for ( HasValue child : parent.getChildren() ) {
      child.accept( this );
    }
    depth--;
  }

  private String indent() {
    return Strings.repeat( "\t", depth );
  }
}
