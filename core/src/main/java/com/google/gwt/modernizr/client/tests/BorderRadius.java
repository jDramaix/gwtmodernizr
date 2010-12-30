package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class BorderRadius extends AbstractModernizrTest {
  
  public static final Class<BorderRadius> BorderRadius = BorderRadius.class;
  
  static {
    Modernizr.addTest(new BorderRadius());
  }
    
  
  @Override
  protected boolean runTest() {    
    return testCssProperty("borderRadius", null);
  }
  
  
}
