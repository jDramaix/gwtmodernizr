package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class CssTransforms3d extends AbstractModernizrTest {

  public static final Class<CssTransforms3d> CssTransforms3d = CssTransforms3d.class;

  static {
    Modernizr.addTest(new CssTransforms3d());
  }

  @Override
  protected boolean runTest() {
    boolean result = cssPropertyExist(modernizr.getStyle(),
        "perspectiveProperty")
        || cssPropertyExist(modernizr.getStyle(), impl.getDomVendorPrefix()
            + "Perspective");
    if (result){
      result = testMediaQuery("@media ("+impl.getStyleVendorPrefix()+"transform-3d),(modernizr)");
    }
    return result;
  }

}
