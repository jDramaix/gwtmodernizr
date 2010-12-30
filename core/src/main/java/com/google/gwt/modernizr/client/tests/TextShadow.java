package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.Element;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.user.client.DOM;

public class TextShadow extends AbstractModernizrTest {
  
  public static final Class<TextShadow> TextShadow = TextShadow.class;
  
  static {
    Modernizr.addTest(new TextShadow());
  }
    
  
  @Override
  protected boolean runTest() {   
    Element div = DOM.createDiv();
    return cssPropertyExist(div.getStyle(), "textShadow");
  }
  
  
}
