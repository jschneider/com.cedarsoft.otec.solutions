package com.cedarsoft.otec.decorator;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface VideoDownloader {
  /**
   * Downloads the video
   */
  String downloadVideo(int videoId);
}