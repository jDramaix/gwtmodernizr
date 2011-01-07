package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class SessionStorage extends AbstractModernizrTest {

  public static final Class<SessionStorage> SessionStorage = SessionStorage.class;

  static {
    Modernizr.addTest(new SessionStorage());
  }

  @Override
  protected boolean runTest() {
    try {
      return propertyBelongToElement(getWindowElement(), "sessionStorage");
    } catch (Exception e) {
      return false;
    }
  }

}
