
GWTModernizr
============
[Modernizr](http://www.modernizr.com) is a great js library that detects if your browser offers native support for a number of CSS3 and HTML5 features.
The idea of this project is to port [Modernizr](http://www.modernizr.com) to GWT and make this feature detection possible from within your GWT code.

For the moment, gwtmodernizr implements all tests present in Modernizr 1.6. You can find the list of detected features in the [Modernizr documentation](http://www.modernizr.com/docs/#s2)


Simple User Guide
-----------------

To use gwtmodernizr, download the [latest version](http://code.google.com/p/gwtmodernizr/downloads/list) of the gwtmodernizr library and place it on your classpath. Edit your module config file to inherit the gwtmodernizr library:

    <inherits name='com.google.gwt.modernizr.GwtModernizr'/>


The library consists of a class `com.google.gwt.modernizr.client.Modernizr` with static methods. Each method test one feature and returns a boolean indicating if the browser supports the feature or not.


    import com.google.gwt.modernizr.client.Modernizr;
    
    ...
    
    VideoPlayerWidget player = null;
    
    if (Modernizr.video()){
        //use a widget using video DOM element
        player = new NativeVideoPlayerWidget();
    }else {
        //use a widget using Flash
        player = new FlashVideoPlayerWidget();
    }
    
    ...
    
    
    Widget dateBox = null;
    if (Modernizr.inputType(InputType.DATE)){
       //use a widget using input DOM element with type=date
       dateBox = new NativeDateBox();
    else {
       //use dateBox widget of GWT
       dateBox = new DateBox();
    }



You can also use gwtmodernizr to branch your css rules :


    /**
     * If the browser supports css columns, display content on 4 columns. Otherwise, float left each label
     */
    @if (com.google.gwt.modernizr.client.Modernizr.cssColumns()) {
        @if user.agent gecko gecko1_8 {
            body{
                -moz-column-count: 4;
	        }
        }@elif user.agent safari {
	        body{
	            -webkit-column-count: 4;
	        }
        }@else {
	        body{
	            column-count: 4;
            }
        }	
    }@else {
        .gwt-Label {
            float: left;
        }		
    }


GWTModernizr in action
----------------------

  * GWT port of the [outputTest of Modernizr](http://modernizr.github.com/Modernizr/output.html), this example lists all features detected by GwtModernizer and shows if your browser supports their : http://gwtmodernizr.googlecode.com/svn/trunk/samples/demo/RuntimeSample/RuntimeSample.html
  
  * Css branching example : http://gwtmodernizr.googlecode.com/svn/trunk/samples/demo/csssample/CssSample.html
 
 
