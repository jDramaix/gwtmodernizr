package com.google.gwt.modernizr.client.utils;


import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;

public class AudioElement extends HtmlMediaElement {

  static final String TAG = "audio";

  /**
   * Assert that the given {@link Element} is compatible with this class and
   * automatically typecast it.
   */
  public static AudioElement as(Element elem) {
    assert elem.getTagName().equalsIgnoreCase(TAG);
    return (AudioElement) elem;
  }
  
  public static AudioElement create(){
    return DOM.createElement(TAG).cast();
  }

  
  protected AudioElement() {
  }

}
