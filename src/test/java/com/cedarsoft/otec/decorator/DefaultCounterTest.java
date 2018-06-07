package com.cedarsoft.otec.decorator;

import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultCounterTest {
  @Test
  public void testCounter() throws Exception {
    {
      System.out.println("---------");

      Counter counter = new Mod3And4Decorator(new Mod4Decorator(new Mod3Decorator((new DefaultCounter()))));

      for (int i = 0; i < 100; i++) {
        System.out.println(counter.nextValue());
      }
    }
  }
}