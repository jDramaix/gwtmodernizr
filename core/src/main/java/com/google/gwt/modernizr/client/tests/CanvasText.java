package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.utils.CanvasElement;

public class CanvasText extends AbstractModernizrTest {

  public static Class<CanvasText> CanvasText = CanvasText.class;
  
  static {
    Modernizr.addTest(new CanvasText());
  }

  
  @Override
  protected boolean runTest() {
   return Modernizr.canvas() && CanvasElement.create().isTextSupported();
  }

}
