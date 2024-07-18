package com.photon.modules.product.enums;

import lombok.Getter;

@Getter
public enum ProductType {

    SIMPLE("simple", "Simple");

    private final String code;

    private final String label;

    ProductType(String code, String label) {
        this.code = code;
        this.label = label;
    }
}
