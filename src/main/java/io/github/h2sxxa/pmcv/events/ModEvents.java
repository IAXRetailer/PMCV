package io.github.h2sxxa.pmcv.events;

import io.github.h2sxxa.pmcv.Main;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void SyncConfig(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.getModID().equals(Main.MODID)) {
            ConfigManager.sync(Main.MODID, Config.Type.INSTANCE);
        }
    }

}
