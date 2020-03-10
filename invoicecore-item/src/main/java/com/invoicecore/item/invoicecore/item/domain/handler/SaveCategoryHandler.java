package com.invoicecore.item.invoicecore.item.domain.handler;

import com.invoicecore.item.invoicecore.item.domain.adapter.CategoryAdapter;
import context.MessageContext;
import exceptions.MessageContextException;
import handlers.Handler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("saveCategoryHandler")
@RequiredArgsConstructor
public class SaveCategoryHandler implements Handler {

    private final CategoryAdapter categoryAdapter;

    @Override
    public void execute(MessageContext messageContext) throws MessageContextException {
        categoryAdapter.saveCategory(messageContext);
    }
}
