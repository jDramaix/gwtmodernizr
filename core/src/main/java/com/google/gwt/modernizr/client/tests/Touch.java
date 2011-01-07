package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class Touch extends AbstractModernizrTest {

  public static final Class<Touch> Touch = Touch.class;

  static {
    Modernizr.addTest(new Touch());
  }

  @Override
  protected boolean runTest() {
    return propertyBelongToElement(getWindowElement(),"ontouchstart")  || testMediaQuery("@media ("+impl.getStyleVendorPrefix()+"touch-enabled),(modernizr)");
    
  }

}
