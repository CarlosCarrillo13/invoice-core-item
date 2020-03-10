package com.invoicecore.item.invoicecore.item.dataprovider.client;


import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import com.invoicecore.item.invoicecore.item.dataprovider.repos.CategoryRepository;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemCategory;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryClient {

    @Autowired
    private CategoryRepository categoryRepository;
    private final Mapper<ItemCategory, ItemCategoryDao> itemCategoryItemCategoryDaoMapper;

    public void saveCategory(MessageContext messageContext) throws MessageContextException {

        categoryRepository.save(itemCategoryItemCategoryDaoMapper.map((ItemCategory)messageContext.getitem(ItemContext.CATEGORY, ItemCategory.class)));

    }

    public void getCategories(MessageContext messageContext) throws MessageContextException {

        List<Long> categoryIds = (List<Long>)messageContext.getitem(ItemContext.CATEGORY_LIST, List.class);
        List<ItemCategoryDao> categories = categoryRepository.findAllById(categoryIds);
        messageContext.addItem(ItemContext.CATEGORY, categories);
    }
}
