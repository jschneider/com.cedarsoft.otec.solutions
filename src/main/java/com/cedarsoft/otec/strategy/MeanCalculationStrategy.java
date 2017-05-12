package com.cedarsoft.otec.strategy;

import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class MeanCalculationStrategy implements CalculationStrategy {
  @Override
  public double calculateAverage(List<Integer> incomes) {
    double sum = 0.0;
    for (Integer income : incomes) {
      sum += income;
    }

    return sum / incomes.size();
  }
}
