package com.invoicecore.item.invoicecore.item.entrypoint.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ItemDto {

    private String name;

    private String sku;

    private String uuid;

    private String barcode;

    private List<Long> categories;

}
