package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;

public abstract class AbstractModernizrTest implements ModernizrTest {

  static class TestImpl {
    
    public String getStyleValueVendorPrefix(){
      return "-khtml-";
    }
    
    public String geStylePropertyVendorPrefix(){
      return "Khtml";
    }
  }
  
  static class TestImplGecko extends TestImpl{
    @Override
    public String getStyleValueVendorPrefix() {
      return "-moz-";
    }
    
    @Override
    public String geStylePropertyVendorPrefix(){
      return "Moz";
    }
  }
  
  static class TestImplOpera extends TestImpl{
    @Override
    public String getStyleValueVendorPrefix() {
      return "-o-";
    }
    
    @Override
    public String geStylePropertyVendorPrefix(){
      return "O";
    }
  }
  
  static class TestImplSafari extends TestImpl{
    @Override
    public String getStyleValueVendorPrefix() {
      return "-webkit-";
    }
    
    @Override
    public String geStylePropertyVendorPrefix(){
      return "Webkit";
    }
  }
  
  static class TestImplTrident extends TestImpl{
    @Override
    public String getStyleValueVendorPrefix() {
      return "-ms";
    }
    
    @Override
    public String geStylePropertyVendorPrefix(){
      return "ms";
    }
    
  }
  
  private Boolean cachedResult = null; 
  protected TestImpl impl = GWT.create(TestImpl.class);
  
  public boolean getResult() {
    if (cachedResult == null){
      cachedResult = runTest();
    }
    
    return cachedResult;
    
  }

  protected abstract boolean runTest();
  
  /**
   * GWT doesn't allows to set a style property in non camel case format...
   * 
   * @param style
   * @param property
   * @param value
   */
  protected native void setNonCamelCaseStyle(Style style, String property, String value) /*-{
  style[property] = value;
  }-*/;

}
