package com.photon.modules.product;

import com.photon.core.commandinvoker.CommandInvoker;
import com.photon.core.commandinvoker.CommandResponse;
import com.photon.infrastructure.Response;
import com.photon.modules.product.commands.request.SaveProductCommandRequest;
import com.photon.modules.product.request.SaveProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productCommandProcess")
@Slf4j
@RequiredArgsConstructor
public class ProductCommandProcessImpl implements ProductCommandProcess {

    private final CommandInvoker commandInvoker;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Response saveProduct(SaveProductRequest saveProductRequest) {
        SaveProductCommandRequest saveProductCommandRequest = modelMapper.map(saveProductRequest, SaveProductCommandRequest.class);
        final CommandResponse commandResponse = commandInvoker.invoke(saveProductCommandRequest);
        return Response.of(commandResponse.getId());
    }
}
