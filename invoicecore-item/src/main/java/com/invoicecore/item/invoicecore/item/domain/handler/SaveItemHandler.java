package com.invoicecore.item.invoicecore.item.domain.handler;

import com.invoicecore.item.invoicecore.item.domain.adapter.ItemAdapter;
import context.MessageContext;
import exceptions.MessageContextException;
import handlers.Handler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("saveItemHandler")
@RequiredArgsConstructor
public class SaveItemHandler implements Handler {

    private final ItemAdapter itemAdapter;

    @Override
    public void execute(MessageContext messageContext) throws MessageContextException {

        itemAdapter.saveItem(messageContext);
    }
}
