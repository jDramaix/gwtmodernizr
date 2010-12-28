package com.google.gwt.modernizr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.modernizr.client.Modernizr.AudioFormat;
import com.google.gwt.modernizr.client.Modernizr.VideoFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class TestAllExample implements EntryPoint {

  public void onModuleLoad() {
    //TODO put loading time !
    
    //Audio
    RootPanel.get().add(new Label("HTML5 Audio :"+(Modernizr.audio() ? "yes" : "no")));
    //Audio format
    for (AudioFormat format : AudioFormat.values()){
      RootPanel.get().add(new Label("Audio format "+format.name()+":"+(Modernizr.audio(format) ? "yes" : "no")));
    }
    
    //Video
    RootPanel.get().add(new Label("HTML5 Video :"+(Modernizr.audio() ? "yes" : "no")));
    //Video format
    for (VideoFormat format : VideoFormat.values()){
      RootPanel.get().add(new Label("Video format "+format.name()+":"+(Modernizr.video(format) ? "yes" : "no")));
    }

  }

}
