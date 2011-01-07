package com.google.gwt.modernizr.client.tests;

import static com.google.gwt.modernizr.client.tests.Svg.SVG_NAMESPACE;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.modernizr.client.Modernizr;

public class InlineSvg extends AbstractModernizrTest {
  
  public static final Class<InlineSvg> InlineSvg = InlineSvg.class;
  
  
  static {
    Modernizr.addTest(new InlineSvg());
  }
  
  
  @Override
  protected boolean runTest() {
    DivElement div = Document.get().createDivElement();
    div.setInnerHTML("<svg/>");
    Element firstChild = (Element) div.getFirstChild();
    return firstChild != null && SVG_NAMESPACE.equals(firstChild.getPropertyString("namespaceURI"));
  }
  

}
