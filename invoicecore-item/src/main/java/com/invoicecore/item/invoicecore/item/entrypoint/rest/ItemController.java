package com.invoicecore.item.invoicecore.item.entrypoint.rest;

import com.invoicecore.item.invoicecore.item.dataprovider.service.ItemService;
import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.domain.usecase.GetItemUseCase;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemDto;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;
import context.EnumMessageContext;
import context.MessageContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final Mapper<Item, ItemDto> itemToItemDtoMapper;
    MessageContext messageContext = new EnumMessageContext<>(ItemContext.class);
    private final GetItemUseCase getItemUseCase;

    @Autowired
    ItemService itemService;

    @GetMapping("/by-id/{sku}")
    public ResponseEntity getItemBySku(@PathVariable String SKU) {

        messageContext.addItem(ItemContext.ITEM, SKU);
        return null;

    }
}
