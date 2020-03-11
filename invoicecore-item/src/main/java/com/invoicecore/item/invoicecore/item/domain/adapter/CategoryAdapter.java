package com.invoicecore.item.invoicecore.item.domain.adapter;

import com.invoicecore.item.invoicecore.item.dataprovider.client.CategoryClient;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryAdapter {

    @Autowired
    private CategoryClient categoryClient;

    public void saveCategory(MessageContext messageContext) throws MessageContextException {

        categoryClient.saveCategory(messageContext);
    }

    public void getCategories(MessageContext messageContext) throws MessageContextException {

        categoryClient.getCategories(messageContext);
    }

    public void getCategoryByName(MessageContext messageContext) throws MessageContextException {

        categoryClient.getCategoryByDisplayName(messageContext);
    }
}
