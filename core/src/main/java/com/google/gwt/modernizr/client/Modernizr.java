package com.google.gwt.modernizr.client;

import static com.google.gwt.modernizr.client.tests.ApplicationCache.ApplicationCache;
import static com.google.gwt.modernizr.client.tests.Audio.Audio;
import static com.google.gwt.modernizr.client.tests.Audio.M4aAudioFormat.M4aAudioFormat;
import static com.google.gwt.modernizr.client.tests.Audio.Mp3AudioFormat.Mp3AudioFormat;
import static com.google.gwt.modernizr.client.tests.Audio.OggAudioFormat.OggAudioFormat;
import static com.google.gwt.modernizr.client.tests.Audio.WavAudioFormat.WavAudioFormat;
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
import static com.google.gwt.modernizr.client.tests.Video.Video;
import static com.google.gwt.modernizr.client.tests.Video.H264AudioFormat.H264AudioFormat;
import static com.google.gwt.modernizr.client.tests.Video.OggVideoFormat.OggVideoFormat;
import static com.google.gwt.modernizr.client.tests.Video.WebmAudioFormat.WebmAudioFormat;
import static com.google.gwt.modernizr.client.tests.WebSockets.WebSockets;
import static com.google.gwt.modernizr.client.tests.WebSqlDatabase.WebSqlDatabase;
import static com.google.gwt.modernizr.client.tests.WebWorkers.WebWorkers;
import static com.google.gwt.modernizr.client.tests.Webgl.Webgl;

import com.google.gwt.modernizr.client.tests.ModernizrTest;

import java.util.HashMap;
import java.util.Map;

public class Modernizr {

  private static final Map<Class<? extends ModernizrTest>, ModernizrTest> tests = new HashMap<Class<? extends ModernizrTest>, ModernizrTest>();

  public static enum AudioFormat {
    OGG(OggAudioFormat, "audio/ogg; codecs=\"vorbis\""), MP3(Mp3AudioFormat,
        "audio/mpeg;"), WAV(WavAudioFormat, "audio/wav; codecs=\"1\""), M4A(
        M4aAudioFormat, "audio/x-m4a;", "audio/aac;");

    private String[] types;
    private Class<? extends ModernizrTest> associatedTest;

    private AudioFormat(Class<? extends ModernizrTest> test, String... types) {
      this.types = types;
      associatedTest = test;
    }

    public String[] getTypes() {
      return types;
    }

    public Class<? extends ModernizrTest> getAssociatedTest() {
      return associatedTest;
    }
  }

  public static enum VideoFormat {
    OGG(OggVideoFormat, "video/ogg; codecs=\"theora\""), H264(H264AudioFormat,
        "video/mp4; codecs=\"avc1.42E01E\"","video/mp4; codecs=\"avc1.42E01E, mp4a.40.2\""), WEBM(WebmAudioFormat,
        "video/webm; codecs=\"vp8, vorbis\"");

    private String[] types;
    private Class<? extends ModernizrTest> associatedTest;

    private VideoFormat(Class<? extends ModernizrTest> test, String... types) {
      this.types = types;
      associatedTest = test;
    }

    public String[] getTypes() {
      return types;
    }

    public Class<? extends ModernizrTest> getAssociatedTest() {
      return associatedTest;
    }
  }

  public static boolean audio() {
    return test(Audio);
  }

  public static boolean audio(AudioFormat format) {
    return test(format.getAssociatedTest());

  }

  public static boolean video() {
    return test(Video);
  }

  public static boolean video(VideoFormat format) {
    return test(format.getAssociatedTest());
  }

  public static boolean canvas() {
    return test(Canvas);
  }

  public static boolean canvasText() {
    return test(CanvasText);
  }

  public static boolean webgl() {
    return test(Webgl);
  }

  public static boolean flexbox() {
    return test(Flexbox);
  }

  public static boolean geolocation() {
    return test(Geolocation);
  }

  public static boolean postMessage() {
    return test(Postmessage);
  }

  public static boolean webSqlDatabase() {
    return test(WebSqlDatabase);
  }

  public static boolean indexedDB() {
    return test(IndexedDB);
  }

  public static boolean hashChange() {
    return test(HashChange);
  }

  public static boolean history() {
    return test(History);
  }

  public static boolean dragAndDrop() {
    return test(DragAndDrop);
  }

  public static boolean webSockets() {
    return test(WebSockets);
  }

  public static boolean rgba() {
    return test(Rgba);
  }

  public static boolean hsla() {
    return test(Hsla);
  }

  public static boolean multipleBackgroung() {
    return test(MultipleBackground);
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

  public static boolean textShadow() {
    return test(TextShadow);
  }

  public static boolean opacity() {
    return test(Opacity);
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

  public static boolean localStorage() {
    return test(LocalStorage);
  }

  public static boolean sessionStorage() {
    return test(SessionStorage);
  }

  public static boolean webWorkers() {
    return test(WebWorkers);
  }

  public static boolean applicationCache() {
    return test(ApplicationCache);
  }

  public static boolean svg() {
    return test(Svg);
  }

  public static boolean inlineSvg() {
    return test(InlineSvg);
  }

  public static boolean smil() {
    return test(Smil);
  }

  public static boolean svgClipPaths() {
    return test(SvgClipPaths);
  }

  public static void addTest(ModernizrTest test) {
    tests.put(test.getClass(), test);
  }

  public static <T extends ModernizrTest> boolean test(Class<T> test) {

    assert tests.containsKey(test) : "No test associated with class :" + test;

    return tests.get(test).getResult();
  }
}
