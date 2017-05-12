package com.cedarsoft.otec.strategy;

import com.cedarsoft.otec.strategy.MeanCalculationStrategy;
import com.cedarsoft.otec.strategy.MedianCalculationStrategy;
import com.cedarsoft.otec.strategy.PovertyReportCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class PovertyReportCreatorDemo {
  public static void main(String[] args) {
    List<Integer> incomes = new ArrayList<Integer>();
    incomes.add(12000);
    incomes.add(18000);
    incomes.add(24000);
    incomes.add(48000);
    incomes.add(108000);

    PovertyReportCreator creator = new PovertyReportCreator(incomes);
    creator.setCalculationStrategy(new MeanCalculationStrategy());

    System.out.println("Mean: " + creator.getAverage());

    creator.setCalculationStrategy(new MedianCalculationStrategy());
    System.out.println("Median: " + creator.getAverage());
  }
}
