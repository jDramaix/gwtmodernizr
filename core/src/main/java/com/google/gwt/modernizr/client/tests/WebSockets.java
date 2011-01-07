package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class WebSockets extends AbstractModernizrTest {
  
  public static final Class<WebSockets> WebSockets = WebSockets.class;
  
  static {
    Modernizr.addTest(new WebSockets());
  }
  
  
  @Override
  protected boolean runTest() {
    return propertyBelongToElement(getWindowElement(),"WebSocket");
  }

}
