package com.invoicecore.item.invoicecore.item.entrypoint.dto;


import com.invoicecore.item.invoicecore.item.util.enums.MeasureUnit;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemSpecDto {

    private String displayName;

    private Long size;

    private MeasureUnit measureUnit;

    private boolean shippable;
}
