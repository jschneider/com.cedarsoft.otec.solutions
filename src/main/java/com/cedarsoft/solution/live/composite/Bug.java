package com.cedarsoft.solution.live.composite;

/**
 * Represents a bug
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Bug extends AbstractBugTrackerEntity {

  private String description;

  public Bug( String description, int estimation ) {
    this.description = description;
    this.estimation = estimation;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

}
