package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class LocalStorage extends AbstractModernizrTest {

  public static final Class<LocalStorage> LocalStorage = LocalStorage.class;

  static {
    Modernizr.addTest(new LocalStorage());
  }

  @Override
  protected boolean runTest() {
    try {
      return propertyBelongToElement(getWindowElement(), "localStorage");
    } catch (Exception e) {
      return false;
    }
  }

}
