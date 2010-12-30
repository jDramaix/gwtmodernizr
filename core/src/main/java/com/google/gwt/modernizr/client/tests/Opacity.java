package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class Opacity extends AbstractModernizrTest {
  
  public static final Class<Opacity> Opacity = Opacity.class;
  
  static {
    Modernizr.addTest(new Opacity());
  }
    
  
  @Override
  protected boolean runTest() {    
    setCss(modernizr, "opacity:.5");
    String opacity = modernizr.getStyle().getProperty("opacity");
    return opacity != null && opacity.contains("0.5");
  }
  
  
}
