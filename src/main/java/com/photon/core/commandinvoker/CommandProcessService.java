package com.photon.core.commandinvoker;

import com.photon.core.request.BaseRequest;

public interface CommandProcessService {

    void process(BaseRequest baseRequest);
}
