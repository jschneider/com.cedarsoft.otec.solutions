package com.cedarsoft.otec.decorator;

/**
 * Calculator class is able to do very expensive calculations
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultVideoDownloader implements VideoDownloader {
  @Override
  public String downloadVideo(int videoId) {
    return "Video-Content for " + videoId + " requested @ " + System.nanoTime();
  }
}
