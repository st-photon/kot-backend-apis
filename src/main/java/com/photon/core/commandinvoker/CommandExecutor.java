package com.photon.core.commandinvoker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CommandExecutor {

    private final ApplicationContext applicationContext;

    public CommandResponse executeCommand(Class<?> commandClass, CommandRequest request) {
        try {
            final ICommand command = this.applicationContext.getBean(commandClass.getSimpleName(), ICommand.class);
            command.execute(request);
            return request.getCommandResponse();
        } catch (Exception e) {
            throw new RuntimeException("Command not found");
        }
    }
}
