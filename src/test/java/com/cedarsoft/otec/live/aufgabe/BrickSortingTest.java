package com.cedarsoft.otec.live.aufgabe;

import org.fest.assertions.Condition;
import org.junit.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class BrickSortingTest {
  @Test
  public void testIt() throws Exception {
    List<Brick> bricks = new ArrayList<Brick>();
    bricks.add( new Cube2by2( Color.BLUE ) );
    bricks.add( new Cube2by2( Color.RED ) );
    bricks.add( new Cuboid2by2( Color.ORANGE ) );
    bricks.add( new Cuboid2by2( Color.MAGENTA ) );
    bricks.add( new Cuboid2by2( Color.YELLOW ) );

    assertThat( bricks ).hasSize( 5 );

    Sorter sorter = new Sorter();
    sorter.sort( bricks );


    assertThat( sorter.getCubes() ).hasSize( 2 );
    assertThat( sorter.getCubes() ).is( new Condition<List<?>>( "each element instance of Cube2by2" ) {
      @Override
      public boolean matches( List<?> value ) {
        for ( Object o : value ) {
          assertThat( o ).isInstanceOf( Cube2by2.class );
        }
        return true;
      }
    } );
    assertThat( sorter.getCuboids() ).is( new Condition<List<?>>( "each element instance of Cuboid2by2" ) {
      @Override
      public boolean matches( List<?> value ) {
        for ( Object o : value ) {
          assertThat( o ).isInstanceOf( Cuboid2by2.class );
        }
        return true;
      }
    } );
    assertThat( sorter.getCuboids() ).hasSize( 3 );
  }

  private static class Sorter implements BrickVisitor {
    private final List<Cube2by2> cubes = new ArrayList<Cube2by2>();
    private final List<Cuboid2by2> cuboids = new ArrayList<Cuboid2by2>();

    private List<Cube2by2> getCubes() {
      return cubes;
    }

    private List<Cuboid2by2> getCuboids() {
      return cuboids;
    }

    @Override
    public void visit( Cube2by2 cube2by2 ) {
      cubes.add( cube2by2 );
    }

    @Override
    public void visit( Cuboid2by2 cuboid2by2 ) {
      cuboids.add( cuboid2by2 );
    }

    public void sort( List<Brick> bricks ) {
      for ( Brick brick : bricks ) {
        brick.accept( this );
      }
    }
  }
}
