package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.Document;
import com.google.gwt.modernizr.client.Modernizr;
import static com.google.gwt.modernizr.client.tests.Svg.SVG_NAMESPACE;

public class Smil extends AbstractModernizrTest {
  
  public static final Class<Smil> Smil = Smil.class;
  
  static {
    Modernizr.addTest(new Smil());
  }
    
  
  @Override
  protected boolean runTest() {    
    return doTest(Document.get(), SVG_NAMESPACE, "animate");
  }


  protected final native boolean doTest(Document document, String svgNamespace, String elementNs) /*-{
    return !!document.createElementNS && /SVG/.test(document.createElementNS(svgNamespace,elementNs).toString());
  }-*/;
  
  
}
