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

import static com.google.gwt.modernizr.client.tests.Svg.SVG_NAMESPACE;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.modernizr.client.Modernizr;

/**
 * 
 * @author Julien Dramaix (julien.dramaix@gmail.com, @jdramaix)
 * 
 */
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
    return firstChild != null
        && SVG_NAMESPACE.equals(firstChild.getPropertyString("namespaceURI"));
  }

}
