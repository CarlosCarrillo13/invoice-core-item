package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.domain.pojo.ItemCategory;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemCategoryDto;
import org.springframework.stereotype.Component;

@Component
public class ItemCategoryDtoItemCategoryMapper implements Mapper<ItemCategoryDto, ItemCategory> {

    @Override
    public ItemCategory map(ItemCategoryDto input) {
        return ItemCategory.builder().displayName(input.getDisplayName())
                .name(input.getName())
                .build();
    }
}
