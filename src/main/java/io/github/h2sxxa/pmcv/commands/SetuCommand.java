package io.github.h2sxxa.pmcv.commands;

import io.github.h2sxxa.pmcv.thread.SetuThreading;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class SetuCommand extends CommandBase {

    @Override
    public String getName() {
        return "setu";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "use '/setu' to open a swing viewer to get a random illust";
    }


    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        sender.sendMessage(new TextComponentString("Start handle 'setu',wait for handle finish...."));
        SetuThreading threading = new SetuThreading();
        threading.start();
    }


    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
