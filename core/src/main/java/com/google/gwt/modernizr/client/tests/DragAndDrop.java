package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class DragAndDrop extends AbstractModernizrTest {

  public static final Class<DragAndDrop> DragAndDrop = DragAndDrop.class;

  static {
    Modernizr.addTest(new DragAndDrop());
  }

  @Override
  protected boolean runTest() {
    return isEventSupported("drag", null)
        && isEventSupported("dragstart", null)
        && isEventSupported("dragenter", null)
        && isEventSupported("dragover", null)
        && isEventSupported("dragleave", null)
        && isEventSupported("dragend", null) 
        && isEventSupported("drop", null);
  }

}
