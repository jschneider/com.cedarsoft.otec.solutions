package com.cedarsoft.solution.live.composite;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public abstract class AbstractBugTrackerEntity implements BugTrackerEntity {
  @Nonnull
  protected final List<BugTrackerEntity> children = new ArrayList<BugTrackerEntity>();
  /**
   * The estimated time in minutes needed to fix the bug (in minutes)
   */
  protected int estimation;

  public void addComment( @Nonnull Comment comment ) {
    this.children.add( comment );
  }

  @Nonnull
  public List<BugTrackerEntity> getChildren() {
    return children;
  }

  @Override
  public int getEstimation() {
    return estimation;
  }

  @Override
  public int getTotalEstimation() {
    int sum = getEstimation();
    for ( BugTrackerEntity child : children ) {
      sum += child.getTotalEstimation();
    }
    return sum;
  }

  public void setEstimation( int estimation ) {
    this.estimation = estimation;
  }
}
