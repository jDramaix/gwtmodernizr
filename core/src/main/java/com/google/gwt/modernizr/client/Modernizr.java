package com.google.gwt.modernizr.client;

import static com.google.gwt.modernizr.client.tests.Canvas.Canvas;
import static com.google.gwt.modernizr.client.tests.CanvasText.CanvasText;
import static com.google.gwt.modernizr.client.tests.Flexbox.Flexbox;
import static com.google.gwt.modernizr.client.tests.Geolocation.Geolocation;
import static com.google.gwt.modernizr.client.tests.HashChange.HashChange;
import static com.google.gwt.modernizr.client.tests.IndexedDB.IndexedDB;
import static com.google.gwt.modernizr.client.tests.Postmessage.Postmessage;
import static com.google.gwt.modernizr.client.tests.WebSqlDatabase.WebSqlDatabase;
import static com.google.gwt.modernizr.client.tests.Webgl.Webgl;
import static com.google.gwt.modernizr.client.tests.History.History;
import static com.google.gwt.modernizr.client.tests.DragAndDrop.DragAndDrop;
import static com.google.gwt.modernizr.client.tests.WebSockets.WebSockets;
import static com.google.gwt.modernizr.client.tests.Rgba.Rgba;
import static com.google.gwt.modernizr.client.tests.Hsla.Hsla;
import static com.google.gwt.modernizr.client.tests.MultipleBackground.MultipleBackground;

import com.google.gwt.modernizr.client.tests.ModernizrTest;
import com.google.gwt.modernizr.client.utils.AudioElement;

import java.util.HashMap;
import java.util.Map;

public class Modernizr {

  private static final Map<Class<? extends ModernizrTest>, ModernizrTest> tests = new HashMap<Class<? extends ModernizrTest>, ModernizrTest>();

  public static enum AudioFormat {
    OGG("audio/ogg; codecs=\"vorbis\""), MP3("audio/mpeg;"), WAV(
        "audio/wav; codecs=\"1\""), M4A("audio/x-m4a;"), AAC("audio/aac;");

    private String type;

    private AudioFormat(String type) {
      this.type = type;
    }

    public String getType() {
      return type;
    }
  }

  public static enum VideoFormat {
    OGG("video/ogg; codecs=\"theora\""), H264(
        "video/mp4; codecs=\"avc1.42E01E\""), WEBM(
        "video/webm; codecs=\"vp8, vorbis\"");

    private String type;

    private VideoFormat(String type) {
      this.type = type;
    }

    public String getType() {
      return type;
    }
  }

  public static boolean audio() {
    return audio(null);
  }

  public static boolean audio(AudioFormat format) {
    AudioElement element = AudioElement.create();
    boolean isSupported = element.getPropertyBoolean("canPlayType");

    if (format == null || !isSupported) {
      return isSupported;
    }

    String formatSupported = element.canPlayType(format.getType());

    return formatSupported != null && !"".equals(formatSupported)
        && !"no".equals(formatSupported);

  }

  public static boolean video() {
    return video(null);
  }

  public static boolean video(VideoFormat format) {
    AudioElement element = AudioElement.create();
    boolean isSupported = element.getPropertyBoolean("canPlayType");

    if (format == null || !isSupported) {
      return isSupported;
    }

    String formatSupported = element.canPlayType(format.getType());

    return formatSupported != null && !"".equals(formatSupported)
        && !"no".equals(formatSupported);

  }

  public static boolean canvas() {
    return test(Canvas);
  }

  public static boolean canvasText() {
    return test(CanvasText);
  }

  public static boolean webgl() {
    return test(Webgl);
  }

  public static boolean flexbox() {
    return test(Flexbox);
  }

  public static boolean geolocation() {
    return test(Geolocation);
  }

  public static boolean postMessage() {
    return test(Postmessage);
  }

  public static boolean webSqlDatabase() {
    return test(WebSqlDatabase);
  }

  public static boolean indexedDB() {
    return test(IndexedDB);
  }

  public static boolean hashChange() {
    return test(HashChange);
  }

  public static boolean history() {
    return test(History);
  }

  public static boolean dragAndDrop() {
    return test(DragAndDrop);
  }

  public static boolean webSockets() {
    return test(WebSockets);
  }
  
  public static boolean rgba() {
    return test(Rgba);
  }
  
  public static boolean hsla() {
    return test(Hsla);
  }
  
  public static boolean multipleBackgroung() {
    return test(MultipleBackground);
  }
  

  public static void addTest(ModernizrTest test) {
    tests.put(test.getClass(), test);
  }

  public static <T extends ModernizrTest> boolean test(Class<T> test) {

    assert tests.containsKey(test) : "No test associated with class :" + test;

    return tests.get(test).getResult();
  }
}
