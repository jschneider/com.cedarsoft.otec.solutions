package com.cedarsoft.otec.decorator;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class VideoDownloaderTest {
  @Test
  public void testSimple() {
    DefaultVideoDownloader downloader = new DefaultVideoDownloader();
    String video0 = downloader.downloadVideo(7);
    String video1 = downloader.downloadVideo(7);

    assertNotEquals(video0, video1);
  }

  @Test
  public void testCached() {
    VideoDownloader downloader = new VideoCache(new DefaultVideoDownloader());

    String video0 = downloader.downloadVideo(7);
    String video1 = downloader.downloadVideo(7);

    assertEquals(video0, video1);
  }
}