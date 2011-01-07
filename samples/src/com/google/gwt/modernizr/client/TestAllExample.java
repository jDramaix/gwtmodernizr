package com.google.gwt.modernizr.client;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
import com.google.gwt.modernizr.client.Modernizr.InputAttribute;
import com.google.gwt.modernizr.client.Modernizr.InputType;
import com.google.gwt.modernizr.client.Modernizr.VideoFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class TestAllExample implements EntryPoint {

  private int testCounter;
  private int subTestCounter;
  private Duration time;
  private int labelCreationTime;

  public void onModuleLoad() {
    testCounter = 0;
    subTestCounter = 0;
    time = new Duration();
    labelCreationTime = 0;

    // Loading time !
    Label durationLabel = new Label();
    RootPanel.get().add(durationLabel);

    // flexbox
    createAndAddLabel("Flexbox", Modernizr.flexbox(), false);

    // Canvas
    createAndAddLabel("Canvas", Modernizr.canvas(), false);

    createAndAddLabel("Canvas text", Modernizr.canvasText(), false);
    createAndAddLabel("webgl", Modernizr.webgl(), false);

    // Touch
    createAndAddLabel("Touch events", Modernizr.touch(), false);

    // geolocation
    createAndAddLabel("Geolocation API", Modernizr.geolocation(), false);

    // Postmessage
    createAndAddLabel("Postmessage", Modernizr.postMessage(), false);

    // webSqlDatabase
    createAndAddLabel("Web SQL Database", Modernizr.webSqlDatabase(), false);

    // indexedDB
    createAndAddLabel("IndexedDB", Modernizr.indexedDB(), false);

    // hashChange
    createAndAddLabel("HashChange", Modernizr.hashChange(), false);

    // history
    createAndAddLabel("History management", Modernizr.history(), false);

    // DragAndDrop
    createAndAddLabel("Drag and Drop", Modernizr.dragAndDrop(), false);

    // WebSockets
    createAndAddLabel("Web Sockets", Modernizr.webSockets(), false);

    // Rgba
    createAndAddLabel("rgba", Modernizr.rgba(), false);

    // Hsla
    createAndAddLabel("hsla", Modernizr.hsla(), false);

    // Multiple background
    createAndAddLabel("Multiple background", Modernizr.multipleBackgroung(),
        false);

    // Background size
    createAndAddLabel("Background size", Modernizr.backgroundSize(), false);

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

    createAndAddLabel("CSS animations", Modernizr.cssAnimations(), false);

    // Css columns

    createAndAddLabel("CSS columns", Modernizr.cssColumns(), false);

    // Css gradient

    createAndAddLabel("CSS gradient", Modernizr.cssGradients(), false);

    // Css reflections
    createAndAddLabel("CSS reflections", Modernizr.cssReflections(), false);

    // Css transforms
    createAndAddLabel("CSS transforms", Modernizr.cssTransforms(), false);

    // Css transforms 3d
    createAndAddLabel("CSS transforms 3d", Modernizr.cssTransforms3d(), false);

    // Css transitions
    createAndAddLabel("CSS transitions", Modernizr.cssTransitions(), false);

    // Audio
    createAndAddLabel("Font face", Modernizr.fontFace(), false);

    // Audio
    createAndAddLabel("HTML5 audio", Modernizr.audio(), false);
    // Audio format
    for (AudioFormat format : AudioFormat.values()) {

      createAndAddLabel("audio format " + format.name(), Modernizr
          .audio(format), true);
    }

    // Video
    createAndAddLabel("HTML5 video", Modernizr.video(), false);

    // Video format
    for (VideoFormat format : VideoFormat.values()) {

      createAndAddLabel("video format " + format.name(), Modernizr
          .video(format), true);
    }

    // Local storage
    createAndAddLabel("Local storage", Modernizr.localStorage(), false);

    // Session storage
    createAndAddLabel("Session storage", Modernizr.sessionStorage(), false);

    // Web worker
    createAndAddLabel("Web workers", Modernizr.webWorkers(), false);

    // Application cache
    createAndAddLabel("Application cache", Modernizr.applicationCache(), false);

    // Svg
    createAndAddLabel("SVG", Modernizr.svg(), false);

    // Inline svg
    createAndAddLabel("Inline SVG", Modernizr.inlineSvg(), false);

    // Smil
    createAndAddLabel("SMIL", Modernizr.smil(), false);
    
    // Svg clip paths
    createAndAddLabel("SVG Clipping", Modernizr.svgClipPaths(), false);

    // Input attributes
    createAndAddLabel("Input attributes", null, false);

    for (InputAttribute attr : InputAttribute.values()) {
      createAndAddLabel(attr.name().toLowerCase(), Modernizr.inputAttribute(attr), true);
    }
    
    // Input types
    createAndAddLabel("Input types", null, false);

    for (InputType type : InputType.values()) {
      createAndAddLabel(type.toString(), Modernizr.inputType(type), true);
    }

    // set durationTime
    int gwtModernizrTime = time.elapsedMillis() - labelCreationTime;
    durationLabel.setText("GWTModernizr took: " + gwtModernizrTime + "ms");

    /*
     * //for testing purpose
     * 
     * Button reload = new Button("reload"); reload.addClickHandler(new
     * ClickHandler() {
     * 
     * public void onClick(ClickEvent event) { RootPanel.get().clear();
     * onModuleLoad();
     * 
     * } }); RootPanel.get().add(reload);
     */
  }

  private void createAndAddLabel(String test, Boolean testResult,
      boolean subTest) {
    Duration creationLabelDuration = new Duration();

    computeCounters(subTest);

    String s = "" + testCounter + "."
        + (subTest ? "" + subTestCounter + " " : " ") + test + ": "
        + (testResult != null ? testResult : "");

    Label l = new Label(s);

    if (subTest) {
      l.addStyleName("subTest");
    }
    if (testResult == null) {
      l.addStyleName("black");
    } else if (testResult) {
      l.addStyleName("yes");
    }

    RootPanel.get().add(l);

    labelCreationTime += creationLabelDuration.elapsedMillis();

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
