package com.photon.modules.product.api;

import com.photon.core.commandinvoker.CommandProcessService;
import com.photon.infrastructure.Response;
import com.photon.modules.product.ProductCommandProcess;
import com.photon.modules.product.request.ProductRequestCommandBuilder;
import com.photon.modules.product.request.SaveProductRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
@Tag(name = "ProductApiResource")
public class ProductApiResource {

    private final ProductCommandProcess productCommandProcess;

    @PostMapping
    public Response saveProduct(@RequestBody SaveProductRequest saveProductRequest) {
        return this.productCommandProcess.saveProduct(saveProductRequest);
    }
}
