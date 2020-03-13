package com.invoicecore.item.invoicecore.item.entrypoint.rest;

import com.invoicecore.item.invoicecore.item.dataprovider.service.ItemService;
import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.domain.usecase.GetItemUseCase;
import com.invoicecore.item.invoicecore.item.domain.usecase.GetItemsByCategoryUseCase;
import com.invoicecore.item.invoicecore.item.domain.usecase.GetItemsByNameUseCase;
import com.invoicecore.item.invoicecore.item.domain.usecase.SaveItemUseCase;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemDto;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.ItemToItemDtoMapper;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;
import context.EnumMessageContext;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    private final GetItemsByNameUseCase getItemsByNameUseCase;

    @Autowired
    ItemService itemService;

    @GetMapping("/by-id/{sku}")
    public ResponseEntity getItemBySku(@PathVariable String sku) throws MessageContextException {

        messageContext.addItem(ItemContext.SKU, sku);
        getItemUseCase.handle(messageContext);
        return new ResponseEntity<>(itemToItemDtoMapper.map((Item) messageContext.getitem(ItemContext.ITEM, Item.class)), HttpStatus.OK);
    }

    @GetMapping("/by-name/{displayname}")
    public ResponseEntity getItemsByDisplayName(@PathVariable String displayname,
                                                @RequestParam int page,
                                                @RequestParam int size) throws MessageContextException {

        Pageable pageable = PageRequest.of(page, size);
        messageContext.addItem(ItemContext.PAGEABLE, pageable);
        messageContext.addItem(ItemContext.ITEM_DISPLAY_NAME, displayname);
        getItemsByNameUseCase.handle(messageContext);
        return new ResponseEntity<>(mapItemsDto(messageContext), HttpStatus.OK);
    }


    @GetMapping("/by-category-name/{categoryName}")
    public ResponseEntity getItemsByCategoryName(@PathVariable String categoryName,
                                                @RequestParam int page,
                                                @RequestParam int size) throws MessageContextException {

        Pageable pageable = PageRequest.of(page, size);
        messageContext.addItem(ItemContext.CATEGORY_NAME, categoryName);
        messageContext.addItem(ItemContext.PAGEABLE, pageable);
        getItemsByCategoryUseCase.handle(messageContext);
        return new ResponseEntity<>(mapItemsDto(messageContext), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity saveItem(@RequestBody ItemDto itemDto) {

        messageContext.addItem(ItemContext.ITEM, itemDtoItemMapper.map(itemDto));
        messageContext.addItem(ItemContext.CATEGORY_LIST, itemDto.getCategories());
        saveItemUseCase.handle(messageContext);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    private Page<ItemDto> mapItemsDto (MessageContext messageContext) throws MessageContextException {

        Page<Item> items = (Page<Item>) messageContext.getitem(ItemContext.ITEM_PAGE, Page.class);
        Page<ItemDto> itemPage = items.map(itemToItemDtoMapper::map);
        return itemPage;
    }
}
