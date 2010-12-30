package com.google.gwt.modernizr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
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
    RootPanel.get().add(createLabel("Html5 audio", Modernizr.audio(), false));
    // Audio format
    for (AudioFormat format : AudioFormat.values()) {
      RootPanel.get().add(
          createLabel("audio format " + format.name(), Modernizr.audio(format),
              true));
    }

    // Video
    RootPanel.get().add(createLabel("Html5 video", Modernizr.video(), false));

    // Video format
    for (VideoFormat format : VideoFormat.values()) {
      RootPanel.get().add(
          createLabel("video format " + format.name(), Modernizr.video(format),
              true));
    }

    // Canvas
    RootPanel.get().add(createLabel("Canvas", Modernizr.canvas(), false));
    RootPanel.get().add(
        createLabel("Canvas text", Modernizr.canvasText(), false));
    RootPanel.get().add(createLabel("webgl", Modernizr.webgl(), false));

    // flexbox
    RootPanel.get().add(createLabel("Flexbox", Modernizr.flexbox(), false));

    // geolocation
    RootPanel.get().add(
        createLabel("Geolocation", Modernizr.geolocation(), false));

    // Postmessage
    RootPanel.get().add(
        createLabel("Postmessage", Modernizr.postMessage(), false));

    // webSqlDatabase
    RootPanel.get().add(
        createLabel("WebSqlDatabase", Modernizr.webSqlDatabase(), false));

    // indexedDB
    RootPanel.get().add(createLabel("IndexedDB", Modernizr.indexedDB(), false));

    // hashChange
    RootPanel.get().add(
        createLabel("HashChange", Modernizr.hashChange(), false));

    // history
    RootPanel.get().add(createLabel("History", Modernizr.history(), false));

    // DragAndDrop
    RootPanel.get().add(
        createLabel("DragAndDrop", Modernizr.dragAndDrop(), false));

    // WebSockets
    RootPanel.get().add(
        createLabel("WebSockets", Modernizr.webSockets(), false));

    // Rgba
    RootPanel.get().add(
        createLabel("rgba", Modernizr.rgba(), false));

    // Hsla
    RootPanel.get().add(
        createLabel("hsla", Modernizr.hsla(), false));
    
    // Multiple background
    RootPanel.get().add(
        createLabel("Multiple background", Modernizr.multipleBackgroung(), false));
    
    // Border Image
    RootPanel.get().add(
        createLabel("Border image", Modernizr.borderImage(), false));
    
    // Border Radius
    RootPanel.get().add(
        createLabel("Border radius", Modernizr.borderRadius(), false));
    
    // Box Shadow
    RootPanel.get().add(
        createLabel("Box shadow", Modernizr.boxShadow(), false));
    
    // Text Shadow
    RootPanel.get().add(
        createLabel("Text shadow", Modernizr.textShadow(), false));
    
    // Opacity
    RootPanel.get().add(
        createLabel("Opacity", Modernizr.opacity(), false));
    
     // Css animations
    RootPanel.get().add(
        createLabel("Css animations", Modernizr.cssAnimations(), false));
    
    // Css columns
    RootPanel.get().add(
        createLabel("Css columns", Modernizr.cssColumns(), false));
    
    // Css gradient
    RootPanel.get().add(
        createLabel("Css gradient", Modernizr.cssGradients(), false));
    
 // Css reflections
    RootPanel.get().add(
        createLabel("Css reflections", Modernizr.cssReflections(), false));
    
 // Css transforms
    RootPanel.get().add(
        createLabel("Css transforms", Modernizr.cssTransforms(), false));
    
 // Css transforms 3d
    RootPanel.get().add(
        createLabel("Css transforms 3d", Modernizr.cssTransforms3d(), false));
    
 // Css transitions 
    RootPanel.get().add(
        createLabel("Css transitions", Modernizr.cssTransitions(), false));
    
 // Local storage
    RootPanel.get().add(
        createLabel("Local storage", Modernizr.localStorage(), false));
    
 // Session storage
    RootPanel.get().add(
        createLabel("Session storage", Modernizr.sessionStorage(), false));
    
 // Web worker
    RootPanel.get().add(
        createLabel("Web workers", Modernizr.webWorkers(), false));
    
 // Application cache
    RootPanel.get().add(
        createLabel("Application cache", Modernizr.applicationCache(), false));
    
 // Svg
    RootPanel.get().add(
        createLabel("svg", Modernizr.svg(), false));
    
 // Inline svg
    RootPanel.get().add(
        createLabel("inlinesvg", Modernizr.inlineSvg(), false));
  }

  private Label createLabel(String test, boolean testResult, boolean subTest) {
    if (!subTest) {
      subTestCounter = 1;
      testCounter++;
    } else {
      subTestCounter++;
    }
    String s = "" + testCounter + "."
        + (subTest ? "" + subTestCounter + " " : " ") + test + ": "
        + (testResult ? "true" : "false");
    return new Label(s);

  }

}
