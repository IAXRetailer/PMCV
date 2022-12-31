package io.github.h2sxxa.pmcv.thread;

import io.github.h2sxxa.pmcv.net.HTTPClient;

public class SetuThreading extends Thread{
    @Override
    public void run(){
        HTTPClient.handleapi();
    }
}
