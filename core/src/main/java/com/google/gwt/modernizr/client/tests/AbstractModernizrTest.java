package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModernizrTest implements ModernizrTest {

  static class TestImpl {
    
    public String getStyleVendorPrefix(){
      return "-khtml-";
    }
    
    public String getDomVendorPrefix(){
      return "Khtml";
    }
  }
  
  static class TestImplGecko extends TestImpl{
    @Override
    public String getStyleVendorPrefix() {
      return "-moz-";
    }
    
    @Override
    public String getDomVendorPrefix(){
      return "Moz";
    }
  }
  
  static class TestImplOpera extends TestImpl{
    @Override
    public String getStyleVendorPrefix() {
      return "-o-";
    }
    
    @Override
    public String getDomVendorPrefix(){
      return "O";
    }
  }
  
  static class TestImplSafari extends TestImpl{
    @Override
    public String getStyleVendorPrefix() {
      return "-webkit-";
    }
    
    @Override
    public String getDomVendorPrefix(){
      return "Webkit";
    }
  }
  
  static class TestImplTrident extends TestImpl{
    @Override
    public String getStyleVendorPrefix() {
      return "-ms";
    }
    
    @Override
    public String getDomVendorPrefix(){
      return "ms";
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

  
  private Boolean cachedResult = null; 
  protected TestImpl impl = GWT.create(TestImpl.class);
  
  public boolean getResult() {
    if (cachedResult == null){
      cachedResult = runTest();
    }
    
    return cachedResult;
    
  }

  protected abstract boolean runTest();
  
  /**
   * GWT doesn't allows to set a style property in non camel case format...
   * 
   * @param style
   * @param property
   * @param value
   */
  protected native void setNonCamelCaseStyle(Style style, String property, String value) /*-{
  style[property] = value;
  }-*/;

  protected native Element getWindowElement() /*-{
    return $wnd;
  }-*/;
  
  /**
   * Determine if a given element supports the given event
   *
   */
  protected static boolean isEventSupported(String eventName, Element element) {
    Element testElement = element;
    if (testElement == null) {
      String testElementTag = testElementTagByEvent.get(eventName);
      testElement = DOM.createElement(testElementTag != null ? testElementTag
          : "div");
    }

    eventName = "on" + eventName;

    return _isEventSupported(eventName, testElement);
  }
  
  protected void setCss(Element e, String css){
    assert e != null : "Element cannot be null";
    e.getStyle().setProperty("cssText", css);
  }

  /**
   * function from http://yura.thinkweb2.com/isEventSupported/
   */
  private static native boolean _isEventSupported(String eventName,
      Element element)/*-{
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
}
