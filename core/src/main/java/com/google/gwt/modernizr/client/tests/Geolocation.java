package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class Geolocation extends AbstractModernizrTest {
  
  public static final Class<Geolocation> Geolocation = Geolocation.class;
  
  static {
    Modernizr.addTest(new Geolocation());
  }
  
  
  @Override
  protected boolean runTest() {
    return doTest();
  }
  
  private native boolean doTest()/*-{
    return !!$wnd.navigator.geolocation;
  }-*/;

}
