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
public class ItemToItemDaoMapper implements Mapper<Item, ItemDao> {


    private final Mapper<ItemSpec, ItemSpecDao> itemSpecItemSpecDaoMapper;
    private final Mapper<ItemCategory, ItemCategoryDao> itemCategoryItemCategoryDaoMapper;

    @Override
    public ItemDao map(Item input) {
        List<ItemCategoryDao> itemCategoriesDao = new ArrayList<>();
        List<ItemSpecDao> itemSpecsDao = new ArrayList<>();

        if (null != input.getCategories() && !input.getCategories().isEmpty()) {
            for (ItemCategory itemCategory : input.getCategories()) {
                ItemCategoryDao itemCategoryDao = itemCategoryItemCategoryDaoMapper.map(itemCategory);
                itemCategoriesDao.add(itemCategoryDao);
            }

        }
        if (null != input.getSpecs() && !input.getSpecs().isEmpty()) {
            for (ItemSpec itemSpec : input.getSpecs()) {
                ItemSpecDao itemSpecDao = itemSpecItemSpecDaoMapper.map(itemSpec);
                itemSpecsDao.add(itemSpecDao);
            }

        }
        return ItemDao.builder()
                .name(input.getName()).sku(input.getSku()).UUID(input.getUUID()).
                        specs(itemSpecsDao).categories(itemCategoriesDao).build();
    }
}

