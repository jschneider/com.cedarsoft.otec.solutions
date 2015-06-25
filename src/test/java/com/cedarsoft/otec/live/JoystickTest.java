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

    joystick.buttonAXPressed();
    joystick.buttonBXPressed();
    joystick.buttonXPressed();
    joystick.buttonYXPressed();

  }
}