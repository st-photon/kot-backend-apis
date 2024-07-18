package com.photon.core.commandinvoker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandInvokerImpl implements CommandInvoker {

    private final CommandExecutor commandExecutor;

    @Override
    public CommandResponse invoke(CommandRequest commandRequest) {
        String requestClassName = commandRequest.getClass().getCanonicalName();
        Reflections reflections = new Reflections("com.photon.modules");
        Set<Class<?>> commandClasses = reflections.getTypesAnnotatedWith(CommandHandler.class);
        Class<?> className = commandClasses.stream()
                .filter(c -> c.getAnnotation(CommandHandler.class).requestBeanName().equals(requestClassName))
                .findAny().orElseThrow(() -> new RuntimeException("Developer error!!! no command handler found to process the request"));
        return commandExecutor.executeCommand(className, commandRequest);
    }
}
