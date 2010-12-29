package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class Postmessage extends AbstractModernizrTest {
  
  public static final Class<Postmessage> Postmessage = Postmessage.class;
  
  static {
    Modernizr.addTest(new Postmessage());
  }
  
  
  @Override
  protected boolean runTest() {
    return getWindowElement().getPropertyBoolean("postMessage");
  }
  

}
