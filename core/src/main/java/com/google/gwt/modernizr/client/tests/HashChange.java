package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.modernizr.client.Modernizr;

public class HashChange extends AbstractModernizrTest {
  
  public static final Class<HashChange> HashChange = HashChange.class;
  public static final ImplStandard innerImpl = GWT.create(ImplStandard.class);
  
  static {
    Modernizr.addTest(new HashChange());
  }
  
  static class ImplStandard {
    protected boolean checkDocumentMode(){
      return true;
    }
  }
  
  static class ImplIE8 extends ImplStandard{
    @Override
    protected boolean checkDocumentMode() {
      return Document.get().getDocumentElement().getPropertyInt("documentMode") > 7;
    }
  }
  
  
  @Override
  protected boolean runTest() {    
    return isEventSupported("hashchange", getWindowElement()) && innerImpl.checkDocumentMode() ;
  }
  

}
