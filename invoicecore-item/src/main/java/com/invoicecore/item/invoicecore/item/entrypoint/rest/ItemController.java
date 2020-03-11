package com.invoicecore.item.invoicecore.item.entrypoint.rest;

import com.invoicecore.item.invoicecore.item.dataprovider.service.ItemService;
import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.domain.usecase.GetItemUseCase;
import com.invoicecore.item.invoicecore.item.domain.usecase.GetItemsByCategoryUseCase;
import com.invoicecore.item.invoicecore.item.domain.usecase.SaveItemUseCase;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemDto;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;
import context.EnumMessageContext;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final Mapper<Item, ItemDto> itemToItemDtoMapper;
    private final Mapper<ItemDto, Item> itemDtoItemMapper;
    MessageContext messageContext = new EnumMessageContext<>(ItemContext.class);
    private final GetItemUseCase getItemUseCase;
    private final SaveItemUseCase saveItemUseCase;
    private final GetItemsByCategoryUseCase getItemsByCategoryUseCase;

    @Autowired
    ItemService itemService;

    @GetMapping("/by-id/{sku}")
    public ResponseEntity getItemBySku(@PathVariable String sku) throws MessageContextException {

        messageContext.addItem(ItemContext.SKU, sku);
        getItemUseCase.handle(messageContext);
        return new ResponseEntity<>(itemToItemDtoMapper.map((Item) messageContext.getitem(ItemContext.ITEM, Item.class)), HttpStatus.OK);

    }


    @GetMapping("/by-category-name/{categoryName}")
    public ResponseEntity getItemByCategoryName(@PathVariable String categoryName) throws MessageContextException {

        messageContext.addItem(ItemContext.CATEGORY_NAME, categoryName);
        getItemsByCategoryUseCase.handle(messageContext);
        List<Item> items = (List<Item>)messageContext.getitem(ItemContext.ITEM_LIST, List.class);

        return new ResponseEntity<>(items.stream().map(itemToItemDtoMapper::map), HttpStatus.OK);

    }


    @PostMapping("/save")
    public ResponseEntity saveItem(@RequestBody ItemDto itemDto) {

        messageContext.addItem(ItemContext.ITEM, itemDtoItemMapper.map(itemDto));
        messageContext.addItem(ItemContext.CATEGORY_LIST, itemDto.getCategories());
        saveItemUseCase.handle(messageContext);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
