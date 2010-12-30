package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class CssGradients extends AbstractModernizrTest {
  
  private static final String BACKG_IMAGE = "background-image:";
  private static final String GRADIENT = "gradient(linear,left top,right bottom,from(#9f9),to(white));";
  private static final String LINEAR_GRADIENT = "linear-gradient(left top,#9f9, white);";
  
  public static final Class<CssGradients> CssGradients = CssGradients.class;
  
  static {
    Modernizr.addTest(new CssGradients());
  }
    
  
  @Override
  protected boolean runTest() { 
    StringBuilder css = new StringBuilder();
    css.append(BACKG_IMAGE).append(GRADIENT);
    css.append(BACKG_IMAGE).append(impl.getStyleVendorPrefix()).append(GRADIENT);
    css.append(BACKG_IMAGE).append(LINEAR_GRADIENT);
    css.append(BACKG_IMAGE).append(impl.getStyleVendorPrefix()).append(LINEAR_GRADIENT);
    setCss(modernizr, css.toString());
    
    String backgroundImage = modernizr.getStyle().getBackgroundImage();
    
    return backgroundImage != null && backgroundImage.contains("gradient");
  }
  
  
}
