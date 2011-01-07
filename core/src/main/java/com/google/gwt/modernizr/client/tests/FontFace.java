package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.StyleElement;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.utils.StyleSheet;
import com.google.gwt.regexp.shared.RegExp;

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
