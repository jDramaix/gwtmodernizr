package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.Element;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.user.client.DOM;

public class MultipleBackground extends AbstractModernizrTest {
  
  public static final Class<MultipleBackground> MultipleBackground = MultipleBackground.class;
  
  static {
    Modernizr.addTest(new MultipleBackground());
  }
    
  
  @Override
  protected boolean runTest() {    
    Element modernizr = DOM.createElement("modernizr");
    setCss(modernizr,"background:url(//:),url(//:),red url(//:)");
    String background = modernizr.getStyle().getProperty("background");
    return background.split("url").length == 4;
  }
  
  
}
