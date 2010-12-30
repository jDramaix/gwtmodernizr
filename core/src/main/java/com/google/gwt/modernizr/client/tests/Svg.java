package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.Document;
import com.google.gwt.modernizr.client.Modernizr;

public class Svg extends AbstractModernizrTest {
  
  public static final Class<Svg> Svg = Svg.class;
  static final String SVG_NAMESPACE ="http://www.w3.org/2000/svg";
  
  static {
    Modernizr.addTest(new Svg());
  }
  
  
  @Override
  protected boolean runTest() {
    return doTest(Document.get(), SVG_NAMESPACE);
  }
  
  private native boolean doTest(Document document, String nameSpace)/*-{
    return !!document.createElementNS && !!document.createElementNS(nameSpace, "svg").createSVGRect;
  }-*/;


}
