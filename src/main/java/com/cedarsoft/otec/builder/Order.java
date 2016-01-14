package com.cedarsoft.otec.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Order {
  private final double price;

  private final List<String> burgers;
  private final List<String> drinks;

  public Order(double price, List<String> burgers, List<String> drinks) {
    this.price = price;
    this.burgers = burgers;
    this.drinks = drinks;
  }

  private Order(Builder builder) {
    price = builder.price;
    burgers = builder.burgers;
    drinks = builder.drinks;
  }

  public double getPrice() {
    return price;
  }

  public List<String> getBurgers() {
    return burgers;
  }

  public List<String> getDrinks() {
    return drinks;
  }

  public static final class Builder {
    private double price;
    private List<String> burgers = new ArrayList<String>();
    private List<String> drinks = new ArrayList<String>();

    public Builder price(double val) {
      price = val;
      return this;
    }

    public void addBurger(String burger) {
      burgers.add(burger);
    }

    public void addDring(String drink) {
      drinks.add(drink);
    }

    public Order build() {
      if (burgers.isEmpty() && drinks.isEmpty()) {
        throw new IllegalStateException("Need at least one burger or one drink");
      }

      if (price == 0) {
        throw new IllegalStateException("Need a price");
      }

      return new Order(price, burgers, drinks);
    }
  }
}
