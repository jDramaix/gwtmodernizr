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
 * 
 * GWTModernizr is a clone of Modernizr js library (http://www.modernizr.com)
 * initially developed by: 
 *    - Faruk Ates  http://farukat.es/
 *    - Paul Irish  http://paulirish.com/
 */
package com.google.gwt.modernizr.client;

import static com.google.gwt.modernizr.client.tests.ApplicationCache.ApplicationCache;
import static com.google.gwt.modernizr.client.tests.Audio.Audio;
import static com.google.gwt.modernizr.client.tests.BorderImage.BorderImage;
import static com.google.gwt.modernizr.client.tests.BorderRadius.BorderRadius;
import static com.google.gwt.modernizr.client.tests.BoxShadow.BoxShadow;
import static com.google.gwt.modernizr.client.tests.Canvas.Canvas;
import static com.google.gwt.modernizr.client.tests.CanvasText.CanvasText;
import static com.google.gwt.modernizr.client.tests.CssAnimations.CssAnimations;
import static com.google.gwt.modernizr.client.tests.CssColumns.CssColumns;
import static com.google.gwt.modernizr.client.tests.CssGradients.CssGradients;
import static com.google.gwt.modernizr.client.tests.CssReflections.CssReflections;
import static com.google.gwt.modernizr.client.tests.CssTransforms.CssTransforms;
import static com.google.gwt.modernizr.client.tests.CssTransforms3d.CssTransforms3d;
import static com.google.gwt.modernizr.client.tests.CssTransitions.CssTransitions;
import static com.google.gwt.modernizr.client.tests.DragAndDrop.DragAndDrop;
import static com.google.gwt.modernizr.client.tests.Flexbox.Flexbox;
import static com.google.gwt.modernizr.client.tests.FontFace.FontFace;
import static com.google.gwt.modernizr.client.tests.Geolocation.Geolocation;
import static com.google.gwt.modernizr.client.tests.HashChange.HashChange;
import static com.google.gwt.modernizr.client.tests.History.History;
import static com.google.gwt.modernizr.client.tests.Hsla.Hsla;
import static com.google.gwt.modernizr.client.tests.IndexedDB.IndexedDB;
import static com.google.gwt.modernizr.client.tests.InlineSvg.InlineSvg;
import static com.google.gwt.modernizr.client.tests.LocalStorage.LocalStorage;
import static com.google.gwt.modernizr.client.tests.MultipleBackground.MultipleBackground;
import static com.google.gwt.modernizr.client.tests.Opacity.Opacity;
import static com.google.gwt.modernizr.client.tests.Postmessage.Postmessage;
import static com.google.gwt.modernizr.client.tests.Rgba.Rgba;
import static com.google.gwt.modernizr.client.tests.SessionStorage.SessionStorage;
import static com.google.gwt.modernizr.client.tests.Smil.Smil;
import static com.google.gwt.modernizr.client.tests.Svg.Svg;
import static com.google.gwt.modernizr.client.tests.SvgClipPaths.SvgClipPaths;
import static com.google.gwt.modernizr.client.tests.TextShadow.TextShadow;
import static com.google.gwt.modernizr.client.tests.Touch.Touch;
import static com.google.gwt.modernizr.client.tests.Video.Video;
import static com.google.gwt.modernizr.client.tests.WebSockets.WebSockets;
import static com.google.gwt.modernizr.client.tests.WebSqlDatabase.WebSqlDatabase;
import static com.google.gwt.modernizr.client.tests.WebWorkers.WebWorkers;
import static com.google.gwt.modernizr.client.tests.Webgl.Webgl;
import static com.google.gwt.modernizr.client.tests.BackgroundSize.BackgroundSize;

import com.google.gwt.modernizr.client.tests.Input;
import com.google.gwt.modernizr.client.tests.InputTypes;
import com.google.gwt.modernizr.client.tests.ModernizrTest;
import com.google.gwt.modernizr.client.tests.Audio.AudioFormatTest;
import com.google.gwt.modernizr.client.tests.Video.VideoFormatTest;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link Modernizr} class allows you to test if the browser support new CSS3
 * and HTML5 features
 * 
 * @author Julien Dramaix (julien.dramaix@gmail.com, @jdramaix)
 * 
 */
public class Modernizr {

  public static enum AudioFormat {
    M4A("audio/x-m4a;", "audio/aac;"), MP3("audio/mpeg;"), OGG("audio/ogg; codecs=\"vorbis\""), WAV(
            "audio/wav; codecs=\"1\"");

    private ModernizrTest test;
    private String[] types;

    private AudioFormat(String... types) {
      this.types = types;
      this.test = new AudioFormatTest(this);
    }

    public String[] getTypes() {
      return types;
    }

    private ModernizrTest getAssociatedTest() {
      return test;
    }
  }

  public static enum InputAttribute {
    AUTOCOMPLETE, AUTOFOCUS, LIST, MAX, MIN, MULTIPLE, PATTERN, PLACEHOLDER, REQUIRED, STEP;

    private ModernizrTest test;

    private InputAttribute() {
      test = new Input(name().toLowerCase());
    }

    public ModernizrTest getAssociatedTest() {
      return test;
    }
  }

  public static enum InputType {
    COLOR, DATE, DATETIME, DATETIME_LOCAL, EMAIL, MONTH, NUMBER, RANGE, SEARCH, TEL, TIME, URL, WEEK;

    private ModernizrTest test;

    private InputType() {
      test = new InputTypes(toString());
    }

    public ModernizrTest getAssociatedTest() {
      return test;
    }

    @Override
    public String toString() {
      return name().toLowerCase().replace('_', '-');
    }
  }

  public static enum VideoFormat {
    H264(
        "video/mp4; codecs=\"avc1.42E01E\"",
        "video/mp4; codecs=\"avc1.42E01E, mp4a.40.2\""), OGG("video/ogg; codecs=\"theora\""), WEBM(
        "video/webm; codecs=\"vp8, vorbis\"");

    private ModernizrTest test;
    private String[] types;

    private VideoFormat(String... types) {
      this.types = types;
      test = new VideoFormatTest(this);
    }

    public String[] getTypes() {
      return types;
    }

    private ModernizrTest getAssociatedTest() {
      return test;
    }
  }

  private static final Map<Class<? extends ModernizrTest>, ModernizrTest> tests = new HashMap<Class<? extends ModernizrTest>, ModernizrTest>();

  public static void addTest(ModernizrTest test) {
    tests.put(test.getClass(), test);
  }

  public static boolean applicationCache() {
    return test(ApplicationCache);
  }

  public static boolean audio() {
    return test(Audio);
  }

  public static boolean audio(AudioFormat format) {
    return format.getAssociatedTest().getResult();

  }

  public static boolean backgroundSize() {
    return test(BackgroundSize);
  }

  public static boolean borderImage() {
    return test(BorderImage);
  }

  public static boolean borderRadius() {
    return test(BorderRadius);
  }

  public static boolean boxShadow() {
    return test(BoxShadow);
  }

  public static boolean canvas() {
    return test(Canvas);
  }

  public static boolean canvasText() {
    return test(CanvasText);
  }

  public static boolean cssAnimations() {
    return test(CssAnimations);
  }

  public static boolean cssColumns() {
    return test(CssColumns);
  }

  public static boolean cssGradients() {
    return test(CssGradients);
  }

  public static boolean cssReflections() {
    return test(CssReflections);
  }

  public static boolean cssTransforms() {
    return test(CssTransforms);
  }

  public static boolean cssTransforms3d() {
    return test(CssTransforms3d);
  }

  public static boolean cssTransitions() {
    return test(CssTransitions);
  }

  public static boolean dragAndDrop() {
    return test(DragAndDrop);
  }

  public static boolean flexbox() {
    return test(Flexbox);
  }

  public static boolean fontFace() {
    return test(FontFace);
  }

  public static boolean geolocation() {
    return test(Geolocation);
  }

  public static boolean hashChange() {
    return test(HashChange);
  }

  public static boolean history() {
    return test(History);
  }

  public static boolean hsla() {
    return test(Hsla);
  }

  public static boolean indexedDB() {
    return test(IndexedDB);
  }

  public static boolean inlineSvg() {
    return test(InlineSvg);
  }

  public static boolean inputAttribute(InputAttribute attr) {
    assert attr != null : "Please specify a InputAttributes object";

    return attr.getAssociatedTest().getResult();
  }

  public static boolean inputType(InputType type) {
    assert type != null : "Please specify a InputAttributes object";

    return type.getAssociatedTest().getResult();
  }

  public static boolean localStorage() {
    return test(LocalStorage);
  }

  public static boolean multipleBackgroung() {
    return test(MultipleBackground);
  }

  public static boolean opacity() {
    return test(Opacity);
  }

  public static boolean postMessage() {
    return test(Postmessage);
  }

  public static boolean rgba() {
    return test(Rgba);
  }

  public static boolean sessionStorage() {
    return test(SessionStorage);
  }

  public static boolean smil() {
    return test(Smil);
  }

  public static boolean svg() {
    return test(Svg);
  }

  public static boolean svgClipPaths() {
    return test(SvgClipPaths);
  }

  public static <T extends ModernizrTest> boolean test(Class<T> test) {

    assert tests.containsKey(test) : "No test associated with class :" + test;

    return tests.get(test).getResult();
  }

  public static boolean textShadow() {
    return test(TextShadow);
  }

  public static boolean touch() {
    return test(Touch);
  }

  public static boolean video() {
    return test(Video);
  }

  public static boolean video(VideoFormat format) {
    return format.getAssociatedTest().getResult();
  }

  public static boolean webgl() {
    return test(Webgl);
  }

  public static boolean webSockets() {
    return test(WebSockets);
  }

  public static boolean webSqlDatabase() {
    return test(WebSqlDatabase);
  }

  public static boolean webWorkers() {
    return test(WebWorkers);
  }
}
