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
 */
package com.google.gwt.modernizr.client.runtimesample;

import static com.google.gwt.modernizr.client.runtimesample.TestAllExample.Resources.Resources;
import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.modernizr.client.Modernizr;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
import com.google.gwt.modernizr.client.Modernizr.InputAttribute;
import com.google.gwt.modernizr.client.Modernizr.InputType;
import com.google.gwt.modernizr.client.Modernizr.VideoFormat;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Test all modernizr features.
 * 
 * @author Julien Dramaix (julien.dramaix@gmail.com)
 * 
 */
public class TestAllExample implements EntryPoint {

  public static interface Resources extends ClientBundle {
    public static Resources Resources = GWT.create(Resources.class);

    @Source("style.css")
    public Css css();
  }

  public static interface Css extends CssResource {

    public String subTest();

    public String yes();

    public String black();

  }

  private int testCounter;
  private int subTestCounter;
  private Duration time;
  private int labelCreationTime;

  public void onModuleLoad() {
    Resources.css().ensureInjected();

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
      createAndAddLabel(attr.name().toLowerCase(), Modernizr
          .inputAttribute(attr), true);
    }

    // Input types
    createAndAddLabel("Input types", null, false);

    for (InputType type : InputType.values()) {
      createAndAddLabel(type.toString(), Modernizr.inputType(type), true);
    }

    // set durationTime
    int gwtModernizrTime = time.elapsedMillis() - labelCreationTime;
    durationLabel.setText("GWTModernizr took: " + gwtModernizrTime + "ms");

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
      l.addStyleName(Resources.css().subTest());
    }
    if (testResult == null) {
      l.addStyleName(Resources.css().black());
    } else if (testResult) {
      l.addStyleName(Resources.css().yes());
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
