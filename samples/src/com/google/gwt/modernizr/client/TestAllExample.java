package com.google.gwt.modernizr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
import com.google.gwt.modernizr.client.Modernizr.InputAttributes;
import com.google.gwt.modernizr.client.Modernizr.VideoFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class TestAllExample implements EntryPoint {

  private int testCounter;
  private int subTestCounter;

  public void onModuleLoad() {
    testCounter = 0;
    subTestCounter = 0;
    // TODO put loading time !

    // Audio
    createAndAddLabel("Font face", Modernizr.fontFace(), false);

    // Audio
    createAndAddLabel("Html5 audio", Modernizr.audio(), false);
    // Audio format
    for (AudioFormat format : AudioFormat.values()) {

      createAndAddLabel("audio format " + format.name(), Modernizr
          .audio(format), true);
    }

    // Video
    createAndAddLabel("Html5 video", Modernizr.video(), false);

    // Video format
    for (VideoFormat format : VideoFormat.values()) {

      createAndAddLabel("video format " + format.name(), Modernizr
          .video(format), true);
    }

    // Canvas
    createAndAddLabel("Canvas", Modernizr.canvas(), false);

    createAndAddLabel("Canvas text", Modernizr.canvasText(), false);
    createAndAddLabel("webgl", Modernizr.webgl(), false);

    // flexbox
    createAndAddLabel("Flexbox", Modernizr.flexbox(), false);

    // geolocation
    createAndAddLabel("Geolocation", Modernizr.geolocation(), false);

    // Postmessage
    createAndAddLabel("Postmessage", Modernizr.postMessage(), false);

    // webSqlDatabase
    createAndAddLabel("WebSqlDatabase", Modernizr.webSqlDatabase(), false);

    // indexedDB
    createAndAddLabel("IndexedDB", Modernizr.indexedDB(), false);

    // hashChange
    createAndAddLabel("HashChange", Modernizr.hashChange(), false);

    // history
    createAndAddLabel("History", Modernizr.history(), false);

    // DragAndDrop
    createAndAddLabel("DragAndDrop", Modernizr.dragAndDrop(), false);

    // WebSockets
    createAndAddLabel("WebSockets", Modernizr.webSockets(), false);

    // Rgba
    createAndAddLabel("rgba", Modernizr.rgba(), false);

    // Hsla
    createAndAddLabel("hsla", Modernizr.hsla(), false);

    // Multiple background
    createAndAddLabel("Multiple background", Modernizr.multipleBackgroung(),
        false);

    // Border Image
    createAndAddLabel("Border image", Modernizr.borderImage(), false);

    // Border Radius
    createAndAddLabel("Border radius", Modernizr.borderRadius(), false);

    // Box Shadow
    createAndAddLabel("Box shadow", Modernizr.boxShadow(), false);

    // Text Shadow
    createAndAddLabel("Text shadow", Modernizr.textShadow(), false);

    // Opacity
    createAndAddLabel("Opacity", Modernizr.opacity(), false);

    // Css animations

    createAndAddLabel("Css animations", Modernizr.cssAnimations(), false);

    // Css columns

    createAndAddLabel("Css columns", Modernizr.cssColumns(), false);

    // Css gradient

    createAndAddLabel("Css gradient", Modernizr.cssGradients(), false);

    // Css reflections
    createAndAddLabel("Css reflections", Modernizr.cssReflections(), false);

    // Css transforms
    createAndAddLabel("Css transforms", Modernizr.cssTransforms(), false);

    // Css transforms 3d
    createAndAddLabel("Css transforms 3d", Modernizr.cssTransforms3d(), false);

    // Css transitions
    createAndAddLabel("Css transitions", Modernizr.cssTransitions(), false);

    // Local storage
    createAndAddLabel("Local storage", Modernizr.localStorage(), false);

    // Session storage
    createAndAddLabel("Session storage", Modernizr.sessionStorage(), false);

    // Web worker
    createAndAddLabel("Web workers", Modernizr.webWorkers(), false);

    // Application cache
    createAndAddLabel("Application cache", Modernizr.applicationCache(), false);

    // Svg
    createAndAddLabel("svg", Modernizr.svg(), false);

    // Inline svg
    createAndAddLabel("inlinesvg", Modernizr.inlineSvg(), false);

    // Touch
    createAndAddLabel("touch", Modernizr.touch(), false);

    // Input attributes
    boolean atLeastOneOk = false;
    for (InputAttributes attr : InputAttributes.values()) {
      atLeastOneOk |= Modernizr.input(attr);
    }

    createAndAddLabel("Input attributes", atLeastOneOk, false);

    for (InputAttributes attr : InputAttributes.values()) {
      createAndAddLabel(attr.name().toLowerCase(), Modernizr.input(attr), true);
    }

  }

  private void createAndAddLabel(String test, boolean testResult,
      boolean subTest) {
    computeCounters(subTest);   
    
    String s = "" + testCounter + "."
        + (subTest ? "" + subTestCounter + " " : " ") + test + ": "
        + (testResult ? "true" : "false");
    
    Label l = new Label(s);
    
    if (subTest){
      l.addStyleName("subTest");
    }
    if (testResult){
      l.addStyleName("yes");
    }
    
    RootPanel.get().add(l);

  }

  private void computeCounters(boolean subTest) {
    if (!subTest) {
      subTestCounter = 0;
      testCounter++;
    } else {
      subTestCounter++;
    }
    
  }

}
