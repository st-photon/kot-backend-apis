package com.photon.core.commandinvoker;

@FunctionalInterface
public interface CommandInvoker {

    CommandResponse invoke(CommandRequest commandRequest);
}
