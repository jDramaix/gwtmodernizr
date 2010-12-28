package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
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
    
    container.getStyle().setProperty("display", "box");
    container.getStyle().setProperty("display", impl.getStyleValueVendorPrefix()+"box");
    container.getStyle().setWidth(42, Unit.PX);
    container.getStyle().setPadding(0, Unit.PX);
    
    child.getStyle().setProperty("BoxFlex", "1");
    child.getStyle().setProperty(impl.geStylePropertyVendorPrefix()+"BoxFlex", "1");
    child.getStyle().setWidth(10, Unit.PX);
    
    container.appendChild(child);
    RootPanel.get().getElement().appendChild(container);
    
    boolean result = child.getOffsetWidth() == 42;
    
    container.removeChild(child);
    RootPanel.get().getElement().removeChild(container);
    return result;
  }
  
  
}