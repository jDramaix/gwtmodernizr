package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.Element;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.user.client.DOM;

public class Rgba extends AbstractModernizrTest {
  
  public static final Class<Rgba> Rgba = Rgba.class;
  
  static {
    Modernizr.addTest(new Rgba());
  }
    
  
  @Override
  protected boolean runTest() {    
    Element modernizr = DOM.createElement("modernizr");
    setCss(modernizr,"background-color:rgba(150,255,150,.5);");
    String backgroungColor = modernizr.getStyle().getBackgroundColor();
    return backgroungColor != null && backgroungColor.contains("rgba");
  }
  
  
}
