package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemCategory;
import org.springframework.stereotype.Component;

@Component
public class ItemCategoryDaoItemCategoryMapper implements Mapper<ItemCategoryDao, ItemCategory> {

    @Override
    public ItemCategory map(ItemCategoryDao input) {
        return ItemCategory.builder().displayName(input.getDisplayName())
                .name(input.getName())
                .build();
    }
}
