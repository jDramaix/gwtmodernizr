package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.Modernizr.VideoFormat;
import com.google.gwt.modernizr.client.utils.VideoElement;

public class Video extends AbstractModernizrTest {

  public static class VideoFormatTest extends Video {

    private VideoFormat format;
    
    public VideoFormatTest(VideoFormat format) {
      this.format = format;
    }
    
    @Override
    protected boolean runTest() {
      
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
