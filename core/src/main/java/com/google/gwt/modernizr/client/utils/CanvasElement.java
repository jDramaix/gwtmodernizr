package com.google.gwt.modernizr.client.utils;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;

public class CanvasElement extends Element{

  static final String TAG = "canvas";

  /**
   * Assert that the given {@link Element} is compatible with this class and
   * automatically typecast it.
   */
  public static CanvasElement as(Element elem) {
    assert elem.getTagName().equalsIgnoreCase(TAG);
    return (CanvasElement) elem;
  }
  
  public static CanvasElement create(){
    return DOM.createElement(TAG).cast();
  }

  
  protected CanvasElement() {
  }

  public final native Object getContext(String ctxType) /*-{
    if (!!this.getContext){
      return this.getContext(ctxType);
    }
    return null;
  }-*/;

  public final native boolean isTextSupported()/*-{
    return !!(typeof this.getContext('2d').fillText == 'function');
  }-*/;

}
