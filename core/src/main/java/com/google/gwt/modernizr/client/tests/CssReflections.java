package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class CssReflections extends AbstractModernizrTest {
  
  public static final Class<CssReflections> CssReflections = CssReflections.class;
  
  static {
    Modernizr.addTest(new CssReflections());
  }
    
  
  @Override
  protected boolean runTest() {    
    return testCssProperty("boxReflect", null);
  }
  
  
}
