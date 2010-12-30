package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class CssAnimations extends AbstractModernizrTest {
  
  public static final Class<CssAnimations> CssAnimations = CssAnimations.class;
  
  static {
    Modernizr.addTest(new CssAnimations());
  }
    
  
  @Override
  protected boolean runTest() {    
    return testCssProperty("animationName", null);
  }
  
  
}
