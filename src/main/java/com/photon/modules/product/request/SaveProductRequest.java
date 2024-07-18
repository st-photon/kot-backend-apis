package com.photon.modules.product.request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveProductRequest {

    private String name;

    private String price;

    private String description;
}
