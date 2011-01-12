package com.google.gwt.modernizr.client.csssample;

import static com.google.gwt.modernizr.client.csssample.Resources.Resources;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class CssSample implements EntryPoint {

  public void onModuleLoad() {
    Resources.css().ensureInjected();
    
    addLabel("css border-radius", Modernizr.borderRadius(), Resources.css().borderRadius());
    addLabel("css box-shadow", Modernizr.boxShadow(), Resources.css().boxShadow());
    addLabel("css gradients", Modernizr.cssGradients(), Resources.css().cssGradients());
    addLabel("text shadow", Modernizr.textShadow(), Resources.css().textShadow());
    addLabel("css 2D transforms", Modernizr.cssTransforms(), Resources.css().cssTransforms());

  }
  
  private void addLabel(String featureName, boolean isSupported, String cssClassName) {
    Label l = new Label();
    if (isSupported){
      l.setText("Your browser support "+featureName+" feature");
    }else{
      l.setText("Your browser doesn't support "+featureName+" feature");
    }
    l.addStyleName(cssClassName);
    RootPanel.get().add(l);
  }

}
