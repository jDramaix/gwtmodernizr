package com.google.gwt.modernizr.client.utils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.StyleElement;

public class StyleSheet extends JavaScriptObject {
  
 public static class CssRuleList extends JavaScriptObject{
    
    protected CssRuleList(){      
    }
    
    public final native int getLenght()/*-{
      return this.length;
    }-*/;
    
    public final native CssRule item(int index)/*-{
    return this[index];
  }-*/;
  }
 
  public static class CssRule extends JavaScriptObject{
    
    protected CssRule(){      
    }
    
    public final native String getCssText()/*-{
      return this.cssText;
    }-*/;
  }

  public native static StyleSheet get(StyleElement style)/*-{
    return style.sheet || style.styleSheet;
  }-*/;

  protected StyleSheet() {

  }

  public final native void insertRule(String rule, int index)/*-{
    this.insertRule(rule,index);
  }-*/;

  public final native void deleteRule(int index)/*-{
    this.deleteRule(index);
  }-*/;
  
  public final native CssRuleList getCssRules()/*-{
    return this.cssRules;
  }-*/;
  
  public final native String getCssText()/*-{
    return this.cssText;
  }-*/;
  
  public final native void setCssText(String css)/*-{
    this.cssText=css;
  }-*/;

}
