package com.google.gwt.modernizr.client;


import com.google.gwt.dom.client.Element;

public abstract class HtmlMediaElement extends Element{

  protected HtmlMediaElement(){
    
  }
  
  /**
   * http://www.whatwg.org/specs/web-apps/current-work/multipage/video.html#dom-navigator-canplaytype
   * @param type
   * @return
   */
  public final native String canPlayType(String type)/*-{
    return this.canPlayType(type);
  }-*/;
}
