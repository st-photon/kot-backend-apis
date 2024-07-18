package com.photon.core.commandinvoker;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CommandHandler {


    String requestBeanName();
}
