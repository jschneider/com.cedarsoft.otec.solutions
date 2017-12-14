package com.cedarsoft.otec.decorator;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class VideoCache implements VideoDownloader {
  private final VideoDownloader delegate;

  public VideoCache(VideoDownloader delegate) {
    this.delegate = delegate;
  }

  private int lastVideoId;
  private String lastVideo;

  @Override
  public String downloadVideo(int videoId) {
    if (lastVideoId == videoId) {
      return lastVideo;
    }

    lastVideo = delegate.downloadVideo(videoId);
    lastVideoId = videoId;
    return lastVideo;
  }
}
