package com.cedarsoft.solution.live.composite;

import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class BugTrackerTest {
  @Test
  public void testIt() {
    BugTracker bugTracker = new BugTracker();

    Bug bug = new Bug( "bug1", 132 );

    bugTracker.addIssue( bug );

    assertThat( bugTracker.getChildren() ).hasSize( 1 );
    assertThat( bugTracker.getTotalEstimation() ).isEqualTo( 132 );

    bug.addComment( new Comment( "asdfasdf" ) );
    bug.addComment( new Comment( "asdfasdf2" ) );

    assertThat( bug.getTotalEstimation() ).isEqualTo( 132 );
    assertThat( bugTracker.getTotalEstimation() ).isEqualTo( 132 );

    bugTracker.addIssue( new Bug( "bug2", 11 ) );
    assertThat( bugTracker.getTotalEstimation() ).isEqualTo( 143 );
  }
}
