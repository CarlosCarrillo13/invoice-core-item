package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemSpecDao;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import org.springframework.stereotype.Component;

@Component
public class ItemSpecToItemSpecDaoMapper implements Mapper<ItemSpec, ItemSpecDao> {
    @Override
    public ItemSpecDao map(ItemSpec input) {
        return ItemSpecDao.builder().displayName(input.getDisplayName())
                .measureUnit(input.getMeasureUnit())
                .shippable(input.isShippable()).build();
    }
}
