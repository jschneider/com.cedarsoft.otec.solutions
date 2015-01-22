package com.cedarsoft.otec.live;

import org.junit.*;

public class HackingVisitorTest {
  @Test
  public void testIt() throws Exception {
    FritzBox fritzBox = new FritzBox();
    AsusRouter asusRouter = new AsusRouter();
    DLinkRouter dLinkRouter = new DLinkRouter();

    HackingVisitor hackingVisitor = new HackingVisitor();

    fritzBox.accept(hackingVisitor);
    asusRouter.accept(hackingVisitor);
    dLinkRouter.accept(hackingVisitor);
  }
}