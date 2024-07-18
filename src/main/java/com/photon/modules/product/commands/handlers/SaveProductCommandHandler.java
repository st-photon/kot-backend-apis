package com.photon.modules.product.commands.handlers;

import com.photon.core.commandinvoker.CommandHandler;
import com.photon.core.commandinvoker.CommandRequest;
import com.photon.core.commandinvoker.CommandResponse;
import com.photon.core.commandinvoker.ICommand;
import com.photon.modules.product.commands.request.SaveProductCommandRequest;
import com.photon.modules.product.entity.Product;
import com.photon.modules.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("SaveProductCommandHandler")
@Slf4j
@CommandHandler(requestBeanName = "com.photon.modules.product.commands.request.SaveProductCommandRequest")
public class SaveProductCommandHandler implements ICommand {

    private final ProductRepository productRepository;

    @Autowired
    public SaveProductCommandHandler(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute(CommandRequest commandRequest) {
        log.debug("START execute method request data {}", commandRequest);
        SaveProductCommandRequest saveProductCommandRequest = (SaveProductCommandRequest) commandRequest;
        final Product product = productRepository.saveAndFlush(map(saveProductCommandRequest));
        final CommandResponse commandResponse = new CommandResponse();
        commandResponse.setId(product.getId());
        saveProductCommandRequest.setCommandResponse(commandResponse);
    }

    private Product map(SaveProductCommandRequest saveProductCommandRequest) {
        final Product product = new Product();
        product.setCode(saveProductCommandRequest.getName());
        product.setName(saveProductCommandRequest.getName());
        product.setPrice(saveProductCommandRequest.getPrice());
        product.setDescription(saveProductCommandRequest.getDescription());
        return product;
    }
}
