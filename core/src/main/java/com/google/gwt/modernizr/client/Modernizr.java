package com.google.gwt.modernizr.client;

import static com.google.gwt.modernizr.client.tests.Canvas.Canvas;
import static com.google.gwt.modernizr.client.tests.CanvasText.CanvasText;
import static com.google.gwt.modernizr.client.tests.Flexbox.Flexbox;
import static com.google.gwt.modernizr.client.tests.Geolocation.Geolocation;
import static com.google.gwt.modernizr.client.tests.Webgl.Webgl;

import com.google.gwt.dom.client.Element;
import com.google.gwt.modernizr.client.tests.ModernizrTest;
import com.google.gwt.modernizr.client.utils.AudioElement;
import com.google.gwt.user.client.DOM;

import java.util.HashMap;
import java.util.Map;

public class Modernizr {
  
  private static final  Map<Class<? extends ModernizrTest>, ModernizrTest> tests = new HashMap<Class<? extends ModernizrTest>, ModernizrTest>();
  
  public static enum AudioFormat{
    OGG("audio/ogg; codecs=\"vorbis\""),
    MP3("audio/mpeg;"),
    WAV("audio/wav; codecs=\"1\""),
    M4A("audio/x-m4a;"),
    AAC("audio/aac;"); 
    
    
    private String type;
    
    private AudioFormat(String type) {
     this.type = type;
    }
    
    public String getType() {
      return type;
    }
  }
  
  public static enum VideoFormat{
    OGG("video/ogg; codecs=\"theora\""),
    H264("video/mp4; codecs=\"avc1.42E01E\""),
    WEBM("video/webm; codecs=\"vp8, vorbis\""); 
    
    
    private String type;
    
    private VideoFormat(String type) {
     this.type = type;
    }
    
    public String getType() {
      return type;
    }
  }

  private final static Map<String, String> testElementTagByEvent;

  static {
    testElementTagByEvent = new HashMap<String, String>();
    testElementTagByEvent.put("select", "input");
    testElementTagByEvent.put("change", "input");
    testElementTagByEvent.put("submit", "form");
    testElementTagByEvent.put("reset", "form");
    testElementTagByEvent.put("error", "img");
    testElementTagByEvent.put("load", "img");
    testElementTagByEvent.put("abort", "img");
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
    
    String formatSupported  = element.canPlayType(format.getType());
    
    return formatSupported != null && !"".equals(formatSupported) && !"no".equals(formatSupported);

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
    
    String formatSupported  = element.canPlayType(format.getType());
    
    return formatSupported != null && !"".equals(formatSupported) && !"no".equals(formatSupported);

  }
  
  public static boolean canvas(){
    return test(Canvas);
  }
  
  public static boolean canvasText(){
    return test(CanvasText);
  }
  
  public static boolean webgl(){
   
    return test(Webgl);
  }
  
  public static boolean flexbox(){
    
    return test(Flexbox);
  }

  public static boolean geolocation(){
    
    return test(Geolocation);
  }
 
  /**
   * isEventSupported determines if a given element supports the given event
   * function from http://yura.thinkweb2.com/isEventSupported/
   */
  private static boolean isEventSupported(String eventName, Element element) {
    Element testElement = element;
    if (testElement == null) {
      String testElementTag = testElementTagByEvent.get(eventName);
      testElement = DOM.createElement(testElementTag != null ? testElementTag
          : "div");
    }

    eventName = "on" + eventName;

    return _isEventSupported(eventName, testElement);
  }

  /**
   * function from http://yura.thinkweb2.com/isEventSupported/
   */
  private static native boolean _isEventSupported(String eventName,
      Element testElement)/*-{
    // When using `setAttribute`, IE skips "unload", WebKit skips "unload" and "resize", whereas `in` "catches" those
        var isSupported = (eventName in element);

        if (!isSupported) {
          // If it has no `setAttribute` (i.e. doesn't implement Node interface), try generic element
          if (!element.setAttribute) {
            element = document.createElement('div');
          }
          if (element.setAttribute && element.removeAttribute) {
            element.setAttribute(eventName, '');
            isSupported = typeof element[eventName] == 'function';

            // If property was created, "remove it" (by setting value to `undefined`)
            if (typeof element[eventName] != 'undefined') {
              element[eventName] = undefined;
            }
            element.removeAttribute(eventName);
          }
        }

        element = null;
        return isSupported;
  }-*/;

  public static void addTest(ModernizrTest test) {
    tests.put(test.getClass(), test);    
  }

  public static <T extends ModernizrTest> boolean test(Class<T> test){
    
    assert tests.containsKey(test) : "No test associated with class :"+test;
    
    return tests.get(test).getResult();
  }
}
