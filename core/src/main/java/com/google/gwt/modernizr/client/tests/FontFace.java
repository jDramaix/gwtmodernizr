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
 * Developed by: 
 *    - Faruk Ates  http://farukat.es/
 *    - Paul Irish  http://paulirish.com/
 */
package com.google.gwt.modernizr.client.tests;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.StyleElement;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.utils.StyleSheet;
import com.google.gwt.regexp.shared.RegExp;

/**
 * 
 * @author Julien Dramaix (julien.dramaix@gmail.com, @jdramaix)
 * 
 */
public class FontFace extends AbstractModernizrTest {

  private static class Css2SupportRuleTest extends SupportRuleTest {

    @Override
    public boolean isFontFaceSupported(StyleSheet sheet) {
      if (sheet == null) {
        return false;
      }
      try {
        sheet.insertRule(FONT_FACE_RULE, 0);
        boolean result = !UNKNOWN_REGULAR_EXPRESSION.test(sheet.getCssRules()
            .item(0).getCssText());
        sheet.deleteRule(sheet.getCssRules().getLenght() - 1);
        return result;
      } catch (Exception e) {
        return false;
      }

    }
  }

  private static class SupportRuleTest {

    public static String FONT_FACE_RULE = "@font-face { font-family: \"font\"; src: \"font.ttf\"; }";
    public static RegExp UNKNOWN_REGULAR_EXPRESSION = RegExp.compile("unknown",
        "i");

    public boolean isFontFaceSupported(StyleSheet sheet) {
      if (sheet == null) {
        return false;
      }

      sheet.setCssText(FONT_FACE_RULE);

      String cssText = sheet.getCssText();

      return cssText != null
          && cssText.length() > 0
          && !UNKNOWN_REGULAR_EXPRESSION.test(cssText)
          && sheet.getCssText().replaceAll("\\r+|\\n+", "").indexOf(
              "@font-face") == 0;
    }

  }

  public static final Class<FontFace> FontFace = FontFace.class;

  static {
    Modernizr.addTest(new FontFace());
  }

  @Override
  protected boolean runTest() {
    StyleElement style = Document.get().createStyleElement();
    HeadElement head = getHeadElement();

    style.setType("text/css");
    head.insertFirst(style);
    SupportRuleTest test = hasCss2Feature() ? new Css2SupportRuleTest()
        : new SupportRuleTest();

    return test.isFontFaceSupported(StyleSheet.get(style));
  }

  private native boolean hasCss2Feature() /*-{
    return $doc.implementation ? $doc.implementation.hasFeature('CSS2', '') : false;
  }-*/;
}
