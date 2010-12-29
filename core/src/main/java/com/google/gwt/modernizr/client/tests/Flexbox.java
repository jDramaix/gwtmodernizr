package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.user.client.ui.RootPanel;

public class Flexbox extends AbstractModernizrTest {
  
  public static final Class<Flexbox> Flexbox = Flexbox.class;
  
  static {
    Modernizr.addTest(new Flexbox());
  }
  
  
  @Override
  protected boolean runTest() {
    DivElement container = Document.get().createDivElement();
    DivElement child = Document.get().createDivElement();

    container.getStyle().setProperty("cssText", "display: box; display: "+impl.getStyleVendorPrefix()+"box;width: 42px; padding: 0px;");
    child.getStyle().setProperty("cssText", "box-flex: 1;"+impl.getStyleVendorPrefix()+"box-flex:1; width: 10px;");
    
    
    container.appendChild(child);
    RootPanel.get().getElement().appendChild(container);
    
    boolean result = child.getOffsetWidth() == 42;
    
    container.removeChild(child);
    RootPanel.get().getElement().removeChild(container);
    return result;
  }

}