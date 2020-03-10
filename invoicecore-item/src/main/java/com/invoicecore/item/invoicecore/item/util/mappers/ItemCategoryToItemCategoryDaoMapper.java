package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemCategory;
import org.springframework.stereotype.Component;

@Component
public class ItemCategoryToItemCategoryDaoMapper implements Mapper<ItemCategory, ItemCategoryDao> {


    @Override
    public ItemCategoryDao map(ItemCategory input) {

        return ItemCategoryDao.builder().displayName(input.getDisplayName())
                .name(input.getName()).build();
    }
}
