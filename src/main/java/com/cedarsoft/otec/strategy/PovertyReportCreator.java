package com.cedarsoft.otec.strategy;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class PovertyReportCreator {
  @Nonnull
  private final List<Integer> incomes;

  private CalculationStrategy calculationStrategy = new MeanCalculationStrategy();

  public PovertyReportCreator(@Nonnull List<Integer> incomes) {
    this.incomes = new ArrayList<Integer>(incomes);
  }

  public CalculationStrategy getCalculationStrategy() {
    return calculationStrategy;
  }

  public void setCalculationStrategy(CalculationStrategy calculationStrategy) {
    this.calculationStrategy = calculationStrategy;
  }

  public double getAverage() {
    return calculationStrategy.calculateAverage(incomes);
  }
}
