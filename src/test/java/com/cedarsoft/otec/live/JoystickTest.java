package com.cedarsoft.otec.live;

import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class JoystickTest {
  @Test
  public void testButtonPresses() throws Exception {
    Joystick joystick = new Joystick(
      new JumpCommand(),
      new MoveCommand(),
      new ShootCommand(),
      new MoveCommand()
    );

    joystick.buttonAPressed();
    joystick.buttonBPressed();
    joystick.buttonXPressed();
    joystick.buttonYPressed();


    System.out.println( "Executed commands" );
    for ( Command command : joystick.getExecutedCommands() ) {
      System.out.println( command );
    }

  }
}