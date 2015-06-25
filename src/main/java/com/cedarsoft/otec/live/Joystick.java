package com.cedarsoft.otec.live;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a joystick which has 4 buttons
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Joystick {
  private final Command aCommand;
  private final Command bCommand;
  private final Command xCommand;
  private final Command yCommand;

  private final List<Command> executedCommands = new ArrayList<Command>();

  public Joystick( Command aCommand, Command bCommand, Command xCommand, Command yCommand ) {
    this.aCommand = aCommand;
    this.bCommand = bCommand;
    this.xCommand = xCommand;
    this.yCommand = yCommand;
  }

  public void buttonAXPressed() {
    System.out.println( "Joystick.buttonAXPressed" );
    aCommand.execute();
    executedCommands.add( aCommand );
  }

  public void buttonBXPressed() {
    System.out.println( "Joystick.buttonBXPressed" );
    bCommand.execute();
    executedCommands.add( bCommand );
  }

  public void buttonXPressed() {
    System.out.println( "Joystick.buttonXPressed" );
    xCommand.execute();
    executedCommands.add( xCommand );
  }

  public void buttonYXPressed() {
    System.out.println( "Joystick.buttonYXPressed" );
    yCommand.execute();
    executedCommands.add( yCommand );
  }
}
