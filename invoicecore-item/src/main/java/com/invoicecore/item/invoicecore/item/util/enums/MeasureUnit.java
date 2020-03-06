package com.invoicecore.item.invoicecore.item.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MeasureUnit {

    CENTIMETER("cm"),
    MILLIMETER("mm"),
    LITER("lt"),
    METER("mt");

    private final String measureName;
}
