package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemSpecDto;
import org.springframework.stereotype.Component;

@Component
public class ItemSpecDtoItemSpecMapper implements Mapper<ItemSpecDto, ItemSpec> {

    @Override
    public ItemSpec map(ItemSpecDto input) {
        return ItemSpec.builder().displayName(input.getDisplayName())
                .measureUnit(input.getMeasureUnit())
                .shippable(input.isShippable())
                .size(input.getSize())
                .quantity(input.getQuantity())
                .unitPrize(input.getUnitPrize())
                .build();
    }
}
