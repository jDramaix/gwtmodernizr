package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class BoxShadow extends AbstractModernizrTest {
  
  public static final Class<BoxShadow> BoxShadow = BoxShadow.class;
  
  static {
    Modernizr.addTest(new BoxShadow());
  }
    
  
  @Override
  protected boolean runTest() {    
    return testCssProperty("boxShadow", null);
  }
  
  
}
