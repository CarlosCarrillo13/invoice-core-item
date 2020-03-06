package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemSpecDao;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import org.springframework.stereotype.Component;

@Component
public class ItemSpecDaoItemSpecMapper implements Mapper<ItemSpecDao, ItemSpec> {

    @Override
    public ItemSpec map(ItemSpecDao input) {
        return ItemSpec.builder().displayName(input.getDisplayName())
                .measureUnit(input.getMeasureUnit()).shippable(input.isShippable())
                .size(input.getSize()).build();
    }
}
