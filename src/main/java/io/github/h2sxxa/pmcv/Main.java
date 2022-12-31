package io.github.h2sxxa.pmcv;

import io.github.h2sxxa.pmcv.commands.ModViewImgCmd;
import io.github.h2sxxa.pmcv.commands.SetuCommand;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "pmcviewer";
    public static final String NAME = "PMCViewer";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ClientCommandHandler.instance.registerCommand(new SetuCommand());
        ClientCommandHandler.instance.registerCommand(new ModViewImgCmd());
        logger.info("success reg command");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
