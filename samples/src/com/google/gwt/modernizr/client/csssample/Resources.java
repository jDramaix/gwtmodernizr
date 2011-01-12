package com.google.gwt.modernizr.client.csssample;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resources extends ClientBundle {

  public interface Css extends CssResource {
    public String borderRadius();

    public String boxShadow();

    public String cssGradients();

    public String textShadow();

    public String cssTransforms();

  }

  public Resources Resources = GWT.create(Resources.class);

  @Source("style.css")
  public Css css();
}
