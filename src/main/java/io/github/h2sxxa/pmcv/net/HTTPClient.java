package io.github.h2sxxa.pmcv.net;

import io.github.h2sxxa.pmcv.Main;
import io.github.h2sxxa.pmcv.config.ModConfig;
import io.github.h2sxxa.pmcv.models.Setu;
import io.github.h2sxxa.pmcv.swing.SimpleImgViewer;

import java.io.*;
import java.net.URL;

import java.net.HttpURLConnection;


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
            String url = setu.getUrl(ModConfig.setuquality);
            if (url.equals("")){
                Main.logger.error("error config quality");
                return;
            }
            Main.logger.info(String.format("get pic success: %s",url));
            handledl(url,ModConfig.setutemp);
            SimpleImgViewer viewer = new SimpleImgViewer();
            viewer.DisplayLocalImg(ModConfig.setutemp);

        }catch(Exception e){
            Main.logger.error(e);
        }
    }
    public static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    public static void handledl(String url,String savepath) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream inputStream = con.getInputStream();
        byte[] getData = readInputStream(inputStream);
        File file = new File(savepath);
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }
    }
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
