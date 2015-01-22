package com.cedarsoft.otec.live;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class HackingVisitor implements RouterVisitor {
  @Override
  public void visit(FritzBox fritzBox) {
    fritzBox.sendData("fritz-password");
  }

  @Override
  public void visit(DLinkRouter dLinkRouter) {
    dLinkRouter.sendData("dlink-password");
  }

  @Override
  public void visit(AsusRouter asusRouter) {
    asusRouter.sendData("asus-password");
  }
}
