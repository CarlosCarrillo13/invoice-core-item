package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemDao;
import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemSpecDao;
import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemCategory;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemDaoToItemMapper implements Mapper<ItemDao, Item> {

    private final Mapper<ItemSpecDao, ItemSpec> itemSpecDaoItemSpecMapper;
    private final Mapper<ItemCategoryDao, ItemCategory> itemCategoryDaoItemCategoryMapper;

    @Override
    public Item map(ItemDao input) {

        List<ItemCategory> itemCategories = new ArrayList<>();
        List<ItemSpec> itemSpecs = new ArrayList<>();

        if (null != input.getCategories() && !input.getCategories().isEmpty()) {
            for (ItemCategoryDao itemCategoryDao: input.getCategories()) {
                ItemCategory itemCategory = itemCategoryDaoItemCategoryMapper.map(itemCategoryDao);
                itemCategories.add(itemCategory);
            }

        }
        if (null != input.getSpecs() && !input.getSpecs().isEmpty()) {
            for (ItemSpecDao itemSpecDao: input.getSpecs()) {
                ItemSpec itemSpec = itemSpecDaoItemSpecMapper.map(itemSpecDao);
                itemSpecs.add(itemSpec);
            }

        }
        return Item.builder()
                .name(input.getName()).sku(input.getSku()).UUID(input.getUUID()).
                        specs(itemSpecs).categories(itemCategories).build();
    }

}
