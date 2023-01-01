package io.github.h2sxxa.pmcv.config;

import io.github.h2sxxa.pmcv.Main;
import net.minecraftforge.common.config.Config;

@Config(modid = Main.MODID)
@Config.LangKey("conf."+Main.MODID+".general")
public class ModConfig {
    @Config.Comment("use the api to get 'setu'")
    @Config.LangKey("conf." + Main.MODID + ".setu")
    @Config.Name("Pixiv setu api")
    public static String setuapi = "https://api.lolicon.app/setu/v2";
    @Config.Comment("[optional] setu quality https://api.lolicon.app/#/setu?id=size")
    @Config.LangKey("conf." + Main.MODID + ".setu.quality")
    @Config.Name("get setu quality")
    public static String setuquality = "small";

    @Config.Comment("[optional] tempfile")
    @Config.LangKey("conf." + Main.MODID + ".setu.temp")
    @Config.Name("save path")
    public static String setutemp = "%TEMP%/setucache.jpg";

    @Config.Comment("[optional] custom html")
    @Config.LangKey("conf." + Main.MODID + ".viewer.html")
    @Config.Name("viewer html")
    public static String viewerhtml = "<html><img src='%s' alt='load image error' /><html>";

}
