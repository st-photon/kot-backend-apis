package com.photon.modules.product.enums;

import lombok.Getter;

@Getter
public enum PriceType {

    SPECIAL("special", "Special"),
    PRICE("price", "Price");

    private final String code;

    private final String label;

    PriceType(String code, String label) {
        this.code = code;
        this.label = label;
    }
}
