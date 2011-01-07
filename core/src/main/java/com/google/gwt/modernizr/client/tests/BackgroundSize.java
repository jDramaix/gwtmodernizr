package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class BackgroundSize extends AbstractModernizrTest {
  
  public static final Class<BackgroundSize> BackgroundSize = BackgroundSize.class;
  
  static {
    Modernizr.addTest(new BackgroundSize());
  }
    
  
  @Override
  protected boolean runTest() {    
    return testCssProperty("backgroundSize", null);
  }
  
  
}
