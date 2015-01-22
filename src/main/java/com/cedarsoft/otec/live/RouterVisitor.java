package com.cedarsoft.otec.live;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface RouterVisitor {
  void visit(FritzBox fritzBox);

  void visit(DLinkRouter dLinkRouter);

  void visit(AsusRouter asusRouter);
}