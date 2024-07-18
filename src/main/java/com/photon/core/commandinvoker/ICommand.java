package com.photon.core.commandinvoker;

@FunctionalInterface
public interface ICommand {

    void execute(CommandRequest commandRequest);
}
