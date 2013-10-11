package com.cedarsoft.otec.live.aufgabe;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface BrickVisitor {
  void visit( Cube2by2 cube2by2 );

  void visit( Cuboid2by2 cuboid2by2 );
}