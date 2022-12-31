package io.github.h2sxxa.pmcv.models;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Setu {
    public LinkedTreeMap picurls;
    public String setuid;
    public String title;
    public String picurl;

    public Setu(String repo){
        Gson gson = new Gson();
        HashMap jsonhm=gson.fromJson(repo, HashMap.class);
        ArrayList data = (ArrayList) jsonhm.get("data");
        LinkedTreeMap picdata= (LinkedTreeMap) data.get(0);
        this.setuid=FmtSecMath(picdata.get("pid").toString());
        this.title=picdata.get("title").toString();
        LinkedTreeMap picurls= (LinkedTreeMap) picdata.get("urls");
        this.picurls=picurls;
    }
    public String getUrl(String size){
        if (picurls.isEmpty()){
            return "";
        }
        return picurls.get(size).toString();
    }

    public String FmtSecMath(String val){
        BigDecimal bg=new BigDecimal(val);
        return bg.toPlainString();
    }

}
