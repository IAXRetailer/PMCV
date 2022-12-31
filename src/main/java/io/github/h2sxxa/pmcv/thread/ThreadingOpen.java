package io.github.h2sxxa.pmcv.thread;

import io.github.h2sxxa.pmcv.net.HTTPClient;
import io.github.h2sxxa.pmcv.swing.SimpleImgViewer;

public class ThreadingOpen extends Thread{
    private String url;

    public void setUrl(String url){
        this.url = url;
    }
    @Override
    public void run(){
        SimpleImgViewer imgViewer = new SimpleImgViewer();
        imgViewer.DisplayImageHtml(this.url);
    }
}
