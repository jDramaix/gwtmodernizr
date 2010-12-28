package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.utils.CanvasElement;

public class Canvas extends AbstractModernizrTest {
  
  public static final Class<Canvas> Canvas = Canvas.class;
  
  static {
    Modernizr.addTest(new Canvas());
  }
  
  
  @Override
  protected boolean runTest() {
    CanvasElement canvas = CanvasElement.create();
    return canvas.getPropertyBoolean("getContext") && canvas.getContext("2d") != null;
  }

}
