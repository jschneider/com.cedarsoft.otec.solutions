package com.cedarsoft.solution.live.composite;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class BugTracker extends AbstractBugTrackerEntity {
  public void addIssue( @Nonnull BugTrackerEntity bugTrackerEntity ) {
    this.children.add( bugTrackerEntity );
  }

  @Override
  public int getEstimation() {
    return 0;
  }
}
