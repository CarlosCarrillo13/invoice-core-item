package com.invoicecore.item.invoicecore.item.entrypoint.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ItemCategoryDto {

    private String name;

    private String displayName;

    private List<ItemDto> items;
}
