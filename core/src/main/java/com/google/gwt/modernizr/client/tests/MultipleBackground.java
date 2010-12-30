package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class MultipleBackground extends AbstractModernizrTest {
  
  public static final Class<MultipleBackground> MultipleBackground = MultipleBackground.class;
  
  static {
    Modernizr.addTest(new MultipleBackground());
  }
    
  
  @Override
  protected boolean runTest() {    
    setCss(modernizr,"background:url(//:),url(//:),red url(//:)");
    String background = modernizr.getStyle().getProperty("background");
    return background.split("url").length == 4;
  }
  
  
}
