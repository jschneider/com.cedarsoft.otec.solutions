package com.cedarsoft.otec.live;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class AsusRouter implements Router {
  @Override
  public void sendData(String data) {
    System.out.println("sending data <" + data + "> to AsusRouter");

    if (data.equals("asus-password")) {
      System.out.println("Asus Router hacked!");
    }
  }

  @Override
  public void accept(RouterVisitor visitor) {
    visitor.visit(this);
  }
}
