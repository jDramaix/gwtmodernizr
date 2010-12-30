package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class WebWorkers extends AbstractModernizrTest {
  
  public static final Class<WebWorkers> WebWorkers = WebWorkers.class;
  
  static {
    Modernizr.addTest(new WebWorkers());
  }
  
  
  @Override
  protected boolean runTest() {
    return getWindowElement().getPropertyBoolean("Worker");
  }

}
