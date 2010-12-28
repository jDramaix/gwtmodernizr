package com.google.gwt.modernizr.client;


import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;

public class VideoElement extends HtmlMediaElement {

  static final String TAG = "video";

  /**
   * Assert that the given {@link Element} is compatible with this class and
   * automatically typecast it.
   */
  public static VideoElement as(Element elem) {
    assert elem.getTagName().equalsIgnoreCase(TAG);
    return (VideoElement) elem;
  }
  
  public static VideoElement create(){
    return DOM.createElement(TAG).cast();
  }

  
  protected VideoElement() {
  }

}
