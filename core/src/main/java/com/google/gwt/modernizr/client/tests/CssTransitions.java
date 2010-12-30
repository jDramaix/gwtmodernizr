package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class CssTransitions extends AbstractModernizrTest {

  public static final Class<CssTransitions> CssTransitions = CssTransitions.class;

  static {
    Modernizr.addTest(new CssTransitions());
  }

  @Override
  protected boolean runTest() {
   return testCssProperty("transitionProperty", null);
  }

}
