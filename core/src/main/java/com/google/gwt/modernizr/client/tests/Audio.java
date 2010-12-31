package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
import com.google.gwt.modernizr.client.utils.AudioElement;

public class Audio extends AbstractModernizrTest {

  public static class AbstractFormatAudioTest extends Audio {

    protected boolean runTest(AudioFormat format) {
      boolean isAudioSupported = super.runTest();
      if (isAudioSupported) {
        AudioElement element = AudioElement.create();
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

  public static class OggAudioFormat extends AbstractFormatAudioTest {

    public static final Class<OggAudioFormat> OggAudioFormat = OggAudioFormat.class;

    static {
      Modernizr.addTest(new OggAudioFormat());
    }

    @Override
    protected boolean runTest() {
      return runTest(AudioFormat.OGG);
    }
  }

  public static class Mp3AudioFormat extends AbstractFormatAudioTest {

    public static final Class<Mp3AudioFormat> Mp3AudioFormat = Mp3AudioFormat.class;

    static {
      Modernizr.addTest(new Mp3AudioFormat());
    }

    @Override
    protected boolean runTest() {
      return runTest(AudioFormat.MP3);
    }
  }

  public static class WavAudioFormat extends AbstractFormatAudioTest {

    public static final Class<WavAudioFormat> WavAudioFormat = WavAudioFormat.class;

    static {
      Modernizr.addTest(new WavAudioFormat());
    }

    @Override
    protected boolean runTest() {
      return runTest(AudioFormat.WAV);
    }
  }

  public static class M4aAudioFormat extends AbstractFormatAudioTest {

    public static final Class<M4aAudioFormat> M4aAudioFormat = M4aAudioFormat.class;

    static {
      Modernizr.addTest(new M4aAudioFormat());
    }

    @Override
    protected boolean runTest() {
      return runTest(AudioFormat.M4A);
    }
  }

  public static final Class<Audio> Audio = Audio.class;

  static {
    Modernizr.addTest(new Audio());
  }

  @Override
  protected boolean runTest() {
    AudioElement element = AudioElement.create();
    return element.getPropertyBoolean("canPlayType");
  }

}
