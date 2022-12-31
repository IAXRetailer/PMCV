package io.github.h2sxxa.pmcv.commands;

import io.github.h2sxxa.pmcv.Main;
import io.github.h2sxxa.pmcv.thread.SetuThreading;
import io.github.h2sxxa.pmcv.thread.ThreadingOpen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class ModViewImgCmd extends CommandBase {
    @Override
    public String getName() {
        return "simg";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "use '/simg *img_url*' to open a swing viewer";
    }


    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        ThreadingOpen threading = new ThreadingOpen();
        Main.logger.info(String.format("show image %s",args[0]));
        threading.setUrl(args[0]);
        threading.start();
    }


    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
