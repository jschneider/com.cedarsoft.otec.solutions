package com.cedarsoft.otec.strategy;

import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class MedianCalculationStrategy implements CalculationStrategy {
  @Override
  public double calculateAverage(List<Integer> incomes) {
    int index = incomes.size() / 2;
    return incomes.get(index);
  }
}
