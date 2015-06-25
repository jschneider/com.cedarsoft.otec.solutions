package com.cedarsoft.otec.live;

/**
 * Represents a joystick which has 4 buttons
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Joystick {
  private final Command aCommand;
  private final Command bCommand;
  private final Command xCommand;
  private final Command yCommand;

  public Joystick( Command aCommand, Command bCommand, Command xCommand, Command yCommand ) {
    this.aCommand = aCommand;
    this.bCommand = bCommand;
    this.xCommand = xCommand;
    this.yCommand = yCommand;
  }

  public void buttonAXPressed() {
    System.out.println( "Joystick.buttonAXPressed" );
    aCommand.execute();
  }

  public void buttonBXPressed() {
    System.out.println( "Joystick.buttonBXPressed" );
    bCommand.execute();
  }

  public void buttonXPressed() {
    System.out.println( "Joystick.buttonXPressed" );
    xCommand.execute();
  }

  public void buttonYXPressed() {
    System.out.println( "Joystick.buttonYXPressed" );
    yCommand.execute();
  }
}
