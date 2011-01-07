package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
import com.google.gwt.modernizr.client.utils.AudioElement;

public class Audio extends AbstractModernizrTest {

  public static class AudioFormatTest extends Audio {
    private AudioFormat audioFormat;

    public AudioFormatTest(AudioFormat format) {
      this.audioFormat = format;
    }
    
    @Override
    protected boolean runTest() {
      boolean isAudioSupported = super.runTest();
      if (isAudioSupported) {
        AudioElement element = AudioElement.create();
        for (String type : audioFormat.getTypes()) {
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
