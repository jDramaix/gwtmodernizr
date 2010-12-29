package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class History extends AbstractModernizrTest {
  
  public static final Class<History> History = History.class;
  
  static {
    Modernizr.addTest(new History());
  }
    
  
  @Override
  protected boolean runTest() {    
    return doTest();
  }
  
  private native boolean doTest() /*-{
   return !!($wnd.history && history.pushState);
   }-*/;

}
