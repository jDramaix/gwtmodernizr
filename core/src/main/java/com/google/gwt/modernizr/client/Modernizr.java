package com.google.gwt.modernizr.client;

import static com.google.gwt.modernizr.client.tests.Canvas.Canvas;
import static com.google.gwt.modernizr.client.tests.CanvasText.CanvasText;
import static com.google.gwt.modernizr.client.tests.Webgl.Webgl;
import static com.google.gwt.modernizr.client.tests.Flexbox.Flexbox;

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

  
  /*public static boolean cssAnimations(){
    
  }*/
/*
  tests['cssanimations'] = function() {
        //  set_css_all( 'animation:"animate" 2s ease 2', 'position:relative' );
        return test_props_all( 'animationName' );
    };
    
    
    tests['csscolumns'] = function() {
        //  set_css_all( 'column-count:3' );
        return test_props_all( 'columnCount' );
    };
    
    
    tests['cssgradients'] = function() {
        /**
         * For CSS Gradients syntax, please see:
         * http://webkit.org/blog/175/introducing-css-gradients/
         * https://developer.mozilla.org/en/CSS/-moz-linear-gradient
         * https://developer.mozilla.org/en/CSS/-moz-radial-gradient
         * http://dev.w3.org/csswg/css3-images/#gradients-
         *
        
        var str1 = 'background-image:',
            str2 = 'gradient(linear,left top,right bottom,from(#9f9),to(white));',
            str3 = 'linear-gradient(left top,#9f9, white);';
        
        set_css(
            (str1 + prefixes.join(str2 + str1) + prefixes.join(str3 + str1)).slice(0,-str1.length)
        );
        
        return contains( m_style.backgroundImage, 'gradient' );
    };
    
    
    tests['cssreflections'] = function() {
        //  set_css_all( 'box-reflect:right 1px' );
        return test_props_all( 'boxReflect' );
    };
    
    
    tests['csstransforms'] = function() {
        //  set_css_all( 'transform:rotate(3deg)' );
        return !!test_props([ 'transformProperty', 'WebkitTransform', 'MozTransform', 'OTransform', 'msTransform' ]);
    };
    
    
    tests['csstransforms3d'] = function() {
        //  set_css_all( 'perspective:500' );
        
        var ret = !!test_props([ 'perspectiveProperty', 'WebkitPerspective', 'MozPerspective', 'OPerspective', 'msPerspective' ]);
        
        // Webkit’s 3D transforms are passed off to the browser's own graphics renderer.
        //   It works fine in Safari on Leopard and Snow Leopard, but not in Chrome (yet?).
        //   As a result, Webkit typically recognizes the syntax but will sometimes throw a false
        //   positive, thus we must do a more thorough check:
        if (ret){
          
          // Webkit allows this media query to succeed only if the feature is enabled.    
          // "@media (transform-3d),(-o-transform-3d),(-moz-transform-3d),(-ms-transform-3d),(-webkit-transform-3d),(modernizr){ ... }"      
          ret = testMediaQuery('@media ('+prefixes.join('transform-3d),(')+'modernizr)');
        }
        return ret;
    };
    
    
    tests['csstransitions'] = function() {
        //  set_css_all( 'transition:all .5s linear' );
        return test_props_all( 'transitionProperty' );
    };


 */
  
  /**
   * test_props is a generic CSS / DOM property test; if a browser supports
   *   a certain property, it won't return undefined for it.
   *   A supported CSS property returns empty string when its not yet set.
   */
  /*private static boolean testCssProperties(String... properties){
    for (String property : properties){
      
    }
  }*/
  /*function test_props( props, callback ) {
      for ( var i in props ) {
          if ( m_style[ props[i] ] !== undefined && ( !callback || callback( props[i], m ) ) ) {
              return true;
          }
      }
  }*/

  /**
   * test_props_all tests a list of DOM properties we want to check against.
   *   We specify literally ALL possible (known and/or likely) properties on 
   *   the element including the non-vendor prefixed one, for forward-
   *   compatibility.
   */
  /*function test_props_all( prop, callback ) {
    
      var uc_prop = prop.charAt(0).toUpperCase() + prop.substr(1),
          props   = (prop + ' ' + domPrefixes.join(uc_prop + ' ') + uc_prop).split(' ');

      return !!test_props( props, callback );
  }*/


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
