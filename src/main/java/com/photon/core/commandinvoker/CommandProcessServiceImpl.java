package com.photon.core.commandinvoker;

import com.photon.core.request.BaseRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CommandProcessServiceImpl implements CommandProcessService {

    private final ApplicationContext applicationContext;

    @Override
    public void process(BaseRequest baseRequest) {
        this.applicationContext.getBean(baseRequest.getCommandProcessServiceName());
    }
}
