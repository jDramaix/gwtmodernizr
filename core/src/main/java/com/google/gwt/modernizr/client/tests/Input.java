package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;

public class Input extends AbstractModernizrTest {

  private String attribute;

  public Input(String attribute) {
    this.attribute = attribute;
  }

  @Override
  protected boolean runTest() {
GWT.log("RunTest ... with attribute "+attribute);
    return propertyBelongToElement(DOM.createElement("input"), attribute);
  }

}
