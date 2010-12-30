package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class BorderImage extends AbstractModernizrTest {
  
  public static final Class<BorderImage> BorderImage = BorderImage.class;
  
  static {
    Modernizr.addTest(new BorderImage());
  }
    
  
  @Override
  protected boolean runTest() {    
    return testCssProperty("borderImage", null);
  }
  
  
}
