package com.photon.modules.product;

import com.photon.core.commandinvoker.CommandResponse;
import com.photon.infrastructure.Response;
import com.photon.modules.product.request.SaveProductRequest;

public interface ProductCommandProcess {

    Response saveProduct(SaveProductRequest saveProductRequest);
}
