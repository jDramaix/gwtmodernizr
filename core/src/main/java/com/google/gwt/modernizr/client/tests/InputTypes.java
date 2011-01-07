/*
 * Copyright 2011 Julien Dramaix.
 * 
 * Licensed under the MIT License, Version 2.0 (the "License"); 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * GWTModernizr is a clone of Modernizr js library (http://www.modernizr.com)
 * initially developed by: 
 *    - Faruk Ates  http://farukat.es/
 *    - Paul Irish  http://paulirish.com/
 */
package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.DOM;

/**
 * 
 * @author Julien Dramaix (julien.dramaix@gmail.com, @jdramaix)
 * 
 */
public class InputTypes extends AbstractModernizrTest {

  private static class Impl {

    protected boolean doTest(String type) {
      InputElement input = DOM.createElement("input").cast();
      input.setAttribute("type", type);

      return !"text".equals(input.getType());

    }
  }

  @SuppressWarnings("unused")
  private static class WebKitImpl extends Impl {
    private static final String EMAIL_TYPE = "email";
    private static final String RANGE_TYPE = "range";
    private static final String SEARCH_TYPE = "search";
    private static final String SMILEY = ":)";
    private static final String TEL_TYPE = "tel";
    private static final String URL_TYPE = "url";

    @Override
    protected boolean doTest(String type) {
      boolean result = super.doTest(type);

      if (result) {
        InputElement input = DOM.createElement("input").cast();
        input.setAttribute("type", type);
        input.setValue(SMILEY);
        String inputType = input.getType();

        if (RANGE_TYPE.equals(inputType)) {
          Document.get().getDocumentElement().appendChild(input);
          result = rangeCheck(Document.get(), input);
          Document.get().getDocumentElement().removeChild(input);
        } else if (URL_TYPE.equals(inputType) || EMAIL_TYPE.equals(inputType)) {
          result = input.getPropertyBoolean("checkValidity");
        } else if (!SEARCH_TYPE.equals(inputType)
            && !TEL_TYPE.equals(inputType)) {
          result = !SMILEY.equals(input.getValue());
        }

      }

      return result;
    }

    private native boolean rangeCheck(Document doc, InputElement input)/*-{
      var defaultView = doc.defaultView;

      return (defaultView.getComputedStyle && 
              defaultView.getComputedStyle(input, null).WebkitAppearance !== 'textfield' && 
              (input.offsetHeight !== 0));
    }-*/;

  }

  private static Impl impl = GWT.create(Impl.class);

  private String type;

  public InputTypes(String type) {
    this.type = type;
  }

  @Override
  protected boolean runTest() {
    return impl.doTest(type);
  }

}
