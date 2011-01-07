package com.google.gwt.modernizr.client.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.DOM;


public class InputTypes extends AbstractModernizrTest {

  
  private  static class Impl {
    
    protected boolean doTest(String type){
      InputElement input = DOM.createElement("input").cast();
      input.setAttribute("type", type);
      
      return ! "text".equals(input.getType());
      
    }
  }
  
  @SuppressWarnings("unused")
  private static class WebKitImpl extends Impl{
    private static final String SMILEY = ":)";
    private static final String SEARCH_TYPE= "search";
    private static final String RANGE_TYPE = "range";
    private static final String TEL_TYPE = "tel";
    private static final String URL_TYPE = "url";
    private static final String EMAIL_TYPE = "email";
    
    @Override
    protected boolean doTest(String type) {
      boolean result = super.doTest(type);
      
      if (result){
        InputElement input = DOM.createElement("input").cast();
        input.setAttribute("type", type);
        input.setValue(SMILEY);
        String inputType = input.getType();
        
        if (RANGE_TYPE.equals(inputType)){
          Document.get().getDocumentElement().appendChild(input);
          result = rangeCheck(Document.get(), input);
          Document.get().getDocumentElement().removeChild(input);
        }else if (URL_TYPE.equals(inputType)|| EMAIL_TYPE.equals(inputType)){
          result = input.getPropertyBoolean("checkValidity");
        }else if (!SEARCH_TYPE.equals(inputType) && !TEL_TYPE.equals(inputType)){
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
