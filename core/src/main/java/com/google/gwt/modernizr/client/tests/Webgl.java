package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.utils.CanvasElement;

public class Webgl extends AbstractModernizrTest {
  
  public static final Class<Webgl> Webgl = Webgl.class;
  
  static {
    Modernizr.addTest(new Webgl());
  }
  
  
  @Override
  protected boolean runTest() {
    CanvasElement canvas = CanvasElement.create();
    
    try{
      if (canvas.getContext("webgl") != null){
        return true;
      }
    }catch (Exception e) {}
    
    try{
      if (canvas.getContext("experimental-webgl") != null){
        return true;
      }
    }catch (Exception e) {}
    
    return false;
  }

}
