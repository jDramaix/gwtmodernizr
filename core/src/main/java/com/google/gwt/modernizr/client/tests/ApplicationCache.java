package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class ApplicationCache extends AbstractModernizrTest {
  
  public static final Class<ApplicationCache> ApplicationCache = ApplicationCache.class;
  
  static {
    Modernizr.addTest(new ApplicationCache());
  }
  
  
  @Override
  protected boolean runTest() {
    return getWindowElement().getPropertyBoolean("applicationCache");
  }

}
