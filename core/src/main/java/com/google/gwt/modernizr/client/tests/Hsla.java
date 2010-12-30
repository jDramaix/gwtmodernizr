package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class Hsla extends AbstractModernizrTest {
  
  public static final Class<Hsla> Hsla = Hsla.class;
  
  static {
    Modernizr.addTest(new Hsla());
  }
    
  
  @Override
  protected boolean runTest() {    
    setCss(modernizr,"background-color:hsla(120,40%,100%,.5)");
    String backgroungColor = modernizr.getStyle().getBackgroundColor();
    // browsers re-map hsla() to rgba() internally,  except IE9 
    return backgroungColor != null && (backgroungColor.contains("rgba") || backgroungColor.contains("hsla")) ;
  }
  
  
}
