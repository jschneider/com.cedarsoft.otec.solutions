package com.cedarsoft.otec.live.listener;

import junit.framework.TestCase;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class RouletteTest extends TestCase {
  public void testRandom() throws Exception {
    Roulette roulette = new Roulette();

    roulette.addListener( new Listener() {
      @Override
      public void spinned( Roulette roulette, int number ) {
        if ( number == 7 ) {
          System.out.println( "-----------" );
          System.out.println( "YEAH!!!! Hit number " + 7 );
          System.out.println( "-----------" );
        } else {
          System.out.println( "Lost at " + number );
        }
      }
    } );

    BiasedWheelDetector biasedWheelDetector = new BiasedWheelDetector();
    roulette.addListener( biasedWheelDetector );

    for ( int i = 0; i < 100; i++ ) {
      roulette.nextSpin();
    }

    System.out.println( "--------- RESULTS -----------" );

    int[] numbersHit = biasedWheelDetector.getNumbersHit();
    for ( int i = 0; i < numbersHit.length; i++ ) {
      int count = numbersHit[i];

      System.out.println( i + "\t" + count );
    }
  }

  private static class BiasedWheelDetector implements Listener {
    @Nonnull
    private final int[] numbersHit = new int[37];

    @Override
    public void spinned( Roulette roulette, int number ) {
      numbersHit[number]++;
    }

    @Nonnull
    public int[] getNumbersHit() {
      return numbersHit;
    }
  }
}