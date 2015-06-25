package com.cedarsoft.otec.live;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class JoystickTest {
  @Test
  public void testButtonPresses() throws Exception {
    Joystick joystick = new Joystick();

    joystick.buttonAXPressed();
    joystick.buttonBXPressed();
    joystick.buttonXPressed();
    joystick.buttonYXPressed();

  }
}