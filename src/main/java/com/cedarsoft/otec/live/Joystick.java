package com.cedarsoft.otec.live;

import java.util.ArrayList;
import java.util.Collections;
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

  public void buttonAPressed() {
    System.out.println( "Joystick.buttonAPressed" );
    aCommand.execute();
    executedCommands.add( aCommand );
  }

  public void buttonBPressed() {
    System.out.println( "Joystick.buttonBPressed" );
    bCommand.execute();
    executedCommands.add( bCommand );
  }

  public void buttonXPressed() {
    System.out.println( "Joystick.buttonXPressed" );
    xCommand.execute();
    executedCommands.add( xCommand );
  }

  public void buttonYPressed() {
    System.out.println( "Joystick.buttonYPressed" );
    yCommand.execute();
    executedCommands.add( yCommand );
  }

  public List<Command> getExecutedCommands() {
    return Collections.unmodifiableList( executedCommands );
  }
}
