package com.photon.modules.product.request;

import com.photon.modules.product.commands.request.SaveProductCommandRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductRequestCommandBuilder {

    private static final String PRODUCT_COMMAND_PROCESS_HANDLER_NAME = "productCommandProcess";

    private final ModelMapper modelMapper;

    public SaveProductCommandRequest buildSaveProductRequest(SaveProductRequest saveProductRequest) {
        SaveProductCommandRequest saveProductCommandRequest = modelMapper.map(saveProductRequest, SaveProductCommandRequest.class);
        //saveProductRequest.setCommandProcessServiceName(PRODUCT_COMMAND_PROCESS_HANDLER_NAME);
        return saveProductCommandRequest;
    }
}
