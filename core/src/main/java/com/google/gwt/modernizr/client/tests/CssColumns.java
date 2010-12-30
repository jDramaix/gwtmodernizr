package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class CssColumns extends AbstractModernizrTest {
  
  public static final Class<CssColumns> CssColumns = CssColumns.class;
  
  static {
    Modernizr.addTest(new CssColumns());
  }
    
  
  @Override
  protected boolean runTest() {    
    return testCssProperty("columnCount", null);
  }
  
  
}
