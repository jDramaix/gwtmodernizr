package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class CssTransforms extends AbstractModernizrTest {

  public static final Class<CssTransforms> CssTransforms = CssTransforms.class;

  static {
    Modernizr.addTest(new CssTransforms());
  }

  @Override
  protected boolean runTest() {
    return cssPropertyExist(modernizr.getStyle(), "transformProperty")
        || cssPropertyExist(modernizr.getStyle(), impl.getDomVendorPrefix()
            + "Transform");
  }

}
