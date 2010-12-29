package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class WebSqlDatabase extends AbstractModernizrTest {
  
  public static final Class<WebSqlDatabase> WebSqlDatabase = WebSqlDatabase.class;
  
  static {
    Modernizr.addTest(new WebSqlDatabase());
  }
  
  
  @Override
  protected boolean runTest() {
    return getWindowElement().getPropertyBoolean("openDatabase");
  }
  

}
