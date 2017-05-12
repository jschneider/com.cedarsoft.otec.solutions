package com.cedarsoft.otec.strategy;

import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface CalculationStrategy {
  double calculateAverage(List<Integer> incomes);
}