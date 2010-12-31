package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
import com.google.gwt.modernizr.client.Modernizr.VideoFormat;
import com.google.gwt.modernizr.client.tests.Audio.AbstractFormatAudioTest;
import com.google.gwt.modernizr.client.tests.Audio.M4aAudioFormat;
import com.google.gwt.modernizr.client.tests.Audio.Mp3AudioFormat;
import com.google.gwt.modernizr.client.tests.Audio.OggAudioFormat;
import com.google.gwt.modernizr.client.tests.Audio.WavAudioFormat;
import com.google.gwt.modernizr.client.utils.AudioElement;
import com.google.gwt.modernizr.client.utils.VideoElement;

public class Video extends AbstractModernizrTest {

  public static class AbstractFormatVideoTest extends Video {

    protected boolean runTest(VideoFormat format) {
      boolean isVideoSupported = super.runTest();
      if (isVideoSupported) {
        VideoElement element = VideoElement.create();
        for (String type : format.getTypes()) {
          String formatSupported = element.canPlayType(type);

          if (formatSupported != null && !"".equals(formatSupported)
              && !"no".equals(formatSupported)) {
            return true;
          }
        }
      }
      return false;
    }
  }

  public static class OggVideoFormat extends AbstractFormatVideoTest {

    public static final Class<OggVideoFormat> OggVideoFormat = OggVideoFormat.class;

    static {
      Modernizr.addTest(new OggVideoFormat());
    }

    @Override
    protected boolean runTest() {
      return runTest(VideoFormat.OGG);
    }
  }

  public static class H264AudioFormat extends AbstractFormatVideoTest {

    public static final Class<H264AudioFormat> H264AudioFormat = H264AudioFormat.class;

    static {
      Modernizr.addTest(new H264AudioFormat());
    }

    @Override
    protected boolean runTest() {
      return runTest(VideoFormat.H264);
    }
  }

  public static class WebmAudioFormat extends AbstractFormatVideoTest {

    public static final Class<WebmAudioFormat> WebmAudioFormat = WebmAudioFormat.class;

    static {
      Modernizr.addTest(new WebmAudioFormat());
    }

    @Override
    protected boolean runTest() {
      return runTest(VideoFormat.WEBM);
    }
  }


  public static final Class<Video> Video = Video.class;

  static {
    Modernizr.addTest(new Video());
  }

  @Override
  protected boolean runTest() {
    VideoElement element = VideoElement.create();
    return element.getPropertyBoolean("canPlayType");
  }

}
