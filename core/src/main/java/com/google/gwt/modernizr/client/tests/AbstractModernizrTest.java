/*
 * Copyright 2011 Julien Dramaix.
 * 
 * Licensed under the MIT License, Version 2.0 (the "License"); 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * GWTModernizr is a clone of Modernizr js library (http://www.modernizr.com)
 * initially developed by: 
 *    - Faruk Ates  http://farukat.es/
 *    - Paul Irish  http://paulirish.com/
 */
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

/**
 * This class offers some useful methods that can be used in the test
 * implementations
 * 
 * @author Julien Dramaix (julien.dramaix@gmail.com, @jdramaix)
 * 
 */
public abstract class AbstractModernizrTest implements ModernizrTest {

  static class TestImpl {

    public String getDomVendorPrefix() {
      return "Khtml";
    }

    public String getStyleVendorPrefix() {
      return "-khtml-";
    }
  }

  static class TestImplGecko extends TestImpl {
    @Override
    public String getDomVendorPrefix() {
      return "Moz";
    }

    @Override
    public String getStyleVendorPrefix() {
      return "-moz-";
    }
  }

  static class TestImplOpera extends TestImpl {
    @Override
    public String getDomVendorPrefix() {
      return "O";
    }

    @Override
    public String getStyleVendorPrefix() {
      return "-o-";
    }
  }

  static class TestImplSafari extends TestImpl {
    @Override
    public String getDomVendorPrefix() {
      return "Webkit";
    }

    @Override
    public String getStyleVendorPrefix() {
      return "-webkit-";
    }
  }

  static class TestImplTrident extends TestImpl {
    @Override
    public String getDomVendorPrefix() {
      return "ms";
    }

    @Override
    public String getStyleVendorPrefix() {
      return "-ms";
    }

  }

  protected final static Element modernizr = DOM.createElement("modernizr");
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

  protected TestImpl impl = GWT.create(TestImpl.class);

  private Boolean cachedResult = null;

  public boolean getResult() {
    if (cachedResult == null) {
      cachedResult = runTest();
    }

    return cachedResult;

  }

  protected native boolean cssPropertyExist(Style s, String property)/*-{
    return s[property] !== undefined;
  }-*/;

  protected HeadElement getHeadElement() {
    HeadElement head = Document.get().getElementsByTagName("head").getItem(0)
        .cast();
    return head;
  }

  protected native Element getWindowElement() /*-{
    return $wnd;
  }-*/;

  protected native boolean propertyBelongToElement(Element element,
      String property)/*-{
    return property in element;
  }-*/;

  protected abstract boolean runTest();

  protected void setCss(Element e, String css) {
    assert e != null : "Element cannot be null";
    e.getStyle().setProperty("cssText", css);
  }

  protected boolean testCssProperty(String property) {
    assert property != null && property.length() > 0 : "Property cannot be null or empty";

    String ucProperty = property.substring(0, 1).toUpperCase()
        + property.substring(1);
    String[] properties = new String[] { property,
        impl.getDomVendorPrefix() + ucProperty };
    for (String p : properties) {
      if (cssPropertyExist(modernizr.getStyle(), p)) {
        return true;
      }
    }

    return false;
  }

  protected boolean testMediaQuery(String mediaQuery) {
    StyleElement style = Document.get().createStyleElement();
    DivElement div = Document.get().createDivElement();

    style.setPropertyString("textContent", mediaQuery
        + "{#modernizr{height:3px}}");

    HeadElement head = getHeadElement();

    head.appendChild(style);
    div.setId("modernizr");
    Document.get().getDocumentElement().appendChild(div);

    boolean result = div.getOffsetHeight() == 3;

    style.removeFromParent();
    div.removeFromParent();

    return result;

  }
}
