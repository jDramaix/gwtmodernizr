package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.Document;
import com.google.gwt.modernizr.client.Modernizr;
import static com.google.gwt.modernizr.client.tests.Svg.SVG_NAMESPACE;

public class SvgClipPaths extends Smil {
  
  public static final Class<SvgClipPaths> SvgClipPaths = SvgClipPaths.class;
  
  static {
    Modernizr.addTest(new SvgClipPaths());
  }
    
  
  @Override
  protected boolean runTest() {    
    return doTest(Document.get(), SVG_NAMESPACE, "clipPath");
  }
  
}
