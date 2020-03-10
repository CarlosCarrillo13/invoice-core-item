package com.invoicecore.item.invoicecore.item.entrypoint.rest;

import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import com.invoicecore.item.invoicecore.item.domain.usecase.GetItemUseCase;
import com.invoicecore.item.invoicecore.item.domain.usecase.SaveItemUseCase;
import com.invoicecore.item.invoicecore.item.domain.usecase.SaveSpecUseCase;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemDto;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemSpecDto;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;
import context.EnumMessageContext;
import context.MessageContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spec")
@RequiredArgsConstructor
public class SpecController {

    private final Mapper<ItemSpecDto, ItemSpec> itemSpecDtoItemSpecMapper;
    MessageContext messageContext = new EnumMessageContext<>(ItemContext.class);
    private final SaveSpecUseCase saveSpecUseCase;

    @PostMapping("/save")
    public ResponseEntity saveSpec(@RequestBody ItemSpecDto itemSpecDto) {

        messageContext.addItem(ItemContext.SPEC, itemSpecDtoItemSpecMapper.map(itemSpecDto));
        messageContext.addItem(ItemContext.ITEM_ID, itemSpecDto.getItemId());
        saveSpecUseCase.handle(messageContext);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
