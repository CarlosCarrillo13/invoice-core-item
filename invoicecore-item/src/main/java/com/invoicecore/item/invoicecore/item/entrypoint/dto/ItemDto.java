package com.invoicecore.item.invoicecore.item.entrypoint.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemDto {

    private String name;

    private String sku;

}
