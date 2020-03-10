package com.invoicecore.item.invoicecore.item.entrypoint.rest;

import UseCases.UseCase;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemCategory;
import com.invoicecore.item.invoicecore.item.domain.usecase.SaveCategoryUseCase;
import com.invoicecore.item.invoicecore.item.entrypoint.dto.ItemCategoryDto;
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
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final Mapper<ItemCategoryDto, ItemCategory> itemCategoryDtoToItemCategory;
    private final SaveCategoryUseCase saveCategoryUseCase;
    MessageContext messageContext = new EnumMessageContext<>(ItemContext.class);

    @PostMapping("/save")
    public ResponseEntity saveCategory(@RequestBody ItemCategoryDto categoryDto) {

        messageContext.addItem(ItemContext.CATEGORY, itemCategoryDtoToItemCategory.map(categoryDto));
        saveCategoryUseCase.handle(messageContext);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
