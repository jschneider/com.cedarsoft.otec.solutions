package com.cedarsoft.otec.builder;

import static org.junit.Assert.*;

import org.fest.assertions.Assertions;
import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class OrderTest {
  @Test
  public void builder() throws Exception {
    Order.Builder builder = new Order.Builder();
    builder.addBurger("Hamburger");
    builder.price(3.5);

    Order order = builder.build();

    Assertions.assertThat(order.getPrice()).isEqualTo(3.5);
    Assertions.assertThat(order.getBurgers()).containsExactly("Hamburger");
  }

  @Test(expected = IllegalStateException.class)
  public void noPrice() throws Exception {
    Order.Builder builder = new Order.Builder();
    builder.addBurger("a burger");

    builder.build();
  }

  @Test(expected = IllegalStateException.class)
  public void noBurgerOrDring() throws Exception {
    Order.Builder builder = new Order.Builder();
    builder.price(12.56);

    builder.build();
  }
}