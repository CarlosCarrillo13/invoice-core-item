package com.invoicecore.item.invoicecore.item.util.mappers;

import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemDtoMapper implements Mapper<Item, ItemDto> {


    @Override
    public ItemDto map(Item input) {

        return ItemDto.builder().name(input.getName()).sku(input.getSku()).build();
    }
}
