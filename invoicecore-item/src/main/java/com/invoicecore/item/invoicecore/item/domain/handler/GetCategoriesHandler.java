package com.invoicecore.item.invoicecore.item.domain.handler;

import com.invoicecore.item.invoicecore.item.domain.adapter.CategoryAdapter;
import com.invoicecore.item.invoicecore.item.domain.adapter.ItemAdapter;
import context.MessageContext;
import exceptions.MessageContextException;
import handlers.Handler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("getCategoriesHandler")
@RequiredArgsConstructor
public class GetCategoriesHandler implements Handler {

    private final CategoryAdapter categoryAdapter;

    @Override
    public void execute(MessageContext messageContext) throws MessageContextException {
        categoryAdapter.getCategories(messageContext);
    }
}
