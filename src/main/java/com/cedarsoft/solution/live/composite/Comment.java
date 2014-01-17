package com.cedarsoft.solution.live.composite;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Comment extends AbstractBugTrackerEntity {
  @Nonnull
  private final String comment;

  public Comment( @Nonnull String comment ) {
    this.comment = comment;
  }

  @Nonnull
  public String getComment() {
    return comment;
  }

  @Override
  public int getEstimation() {
    return 0;
  }
}
