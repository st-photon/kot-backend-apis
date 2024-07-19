package com.photon.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class BaseIT extends AbstractCoreBaseIT {

    @Autowired
    public ApplicationContext applicationContext;

    public Object getBean(Class<?> clazz) {
        return applicationContext.getBean(clazz);
    }
}
