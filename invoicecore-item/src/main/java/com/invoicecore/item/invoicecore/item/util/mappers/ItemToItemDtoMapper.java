package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemDtoMapper implements Mapper<ItemDto, Item> {

    @Override
    public Item map(ItemDto input) {

        //TODO: mapper
        return null;
    }
}
