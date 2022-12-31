package io.github.h2sxxa.pmcv.net;

import io.github.h2sxxa.pmcv.Main;
import io.github.h2sxxa.pmcv.config.ModConfig;
import io.github.h2sxxa.pmcv.models.Setu;
import io.github.h2sxxa.pmcv.swing.SimpleImgViewer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPClient {
    public static void handleapi(){
        String api = ModConfig.setuapi;
        api = api.concat(String.format("?size=%s",ModConfig.setuquality));
        Main.logger.info(String.format("Start handle %s", api));
        try{
            String text = sendGet(api);
            Main.logger.info(String.format("connact %s successfully", api));
            Main.logger.info(text);
            Setu setu =new Setu(text);
            Main.logger.info(String.format("setu uid is %s",setu.setuid));
            SimpleImgViewer imgViewer = new SimpleImgViewer();
            String url = setu.getUrl(ModConfig.setuquality);
            if (url.equals("")){
                Main.logger.error("error config quality");
                return;
            }
            Main.logger.info(String.format("get pic success: %s",url));
            imgViewer.DisplayImageHtml(url);
        }catch(Exception e){
            Main.logger.error(e);
        }
    }
    public static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        //int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
