package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.StyleElement;
import com.google.gwt.user.client.DOM;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModernizrTest implements ModernizrTest {
  
  public interface CallBack {
    public boolean call(Object data);
  }

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
  protected final static Element modernizr = DOM.createElement("modernizr");

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
  
  protected boolean testCssProperty(String property, CallBack callBack){
    assert property != null && property.length() > 0 : "Property cannot be null or empty";
    
    String ucProperty = property.substring(0, 1).toUpperCase() + property.substring(1);
    String[] properties = new String[]{property, impl.getDomVendorPrefix()+ucProperty};
    for (String p : properties){
      if (cssPropertyExist(modernizr.getStyle(), p) && (callBack == null || callBack.call(p))){
        return true;
      }
    }
    
    return false;
  }
  
  protected native boolean cssPropertyExist(Style s, String property)/*-{
    return s[property] !== undefined;
  }-*/;
  
  protected boolean testMediaQuery(String mediaQuery){
    StyleElement style = Document.get().createStyleElement();
    DivElement div = Document.get().createDivElement();
    
    style.setPropertyString("textContent", mediaQuery+ "{#modernizr{height:3px}}");
    
    HeadElement head = Document.get().getElementsByTagName("head").getItem(0).cast();
    head.appendChild(style);
    div.setId("modernizr");
    Document.get().getDocumentElement().appendChild(div);
    
    boolean result = div.getOffsetHeight() == 3;
    
    style.removeFromParent();
    div.removeFromParent();
    
    return result;
    
  }
  
  /*testMediaQuery = function(mq){

    var st = document.createElement('style'),
        div = doc.createElement('div'),
        ret;

    st.textContent = mq + '{#modernizr{height:3px}}';
    (doc.head || doc.getElementsByTagName('head')[0]).appendChild(st);
    div.id = 'modernizr';
    docElement.appendChild(div);

    ret = div.offsetHeight === 3;

    st.parentNode.removeChild(st);
    div.parentNode.removeChild(div);

    return !!ret;

  }*/

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
