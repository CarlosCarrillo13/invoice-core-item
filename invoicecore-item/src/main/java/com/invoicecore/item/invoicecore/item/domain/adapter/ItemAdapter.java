package com.invoicecore.item.invoicecore.item.domain.adapter;

import com.invoicecore.item.invoicecore.item.dataprovider.client.ItemClient;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemAdapter {

    @Autowired
    private final ItemClient itemClient;

    public void getItem(MessageContext messageContext) throws MessageContextException {

        itemClient.getBySku(messageContext);
    }

    public void saveItem(MessageContext messageContext) throws MessageContextException {

        itemClient.save(messageContext);
    }

    public void saveSpec(MessageContext messageContext) throws MessageContextException {

        itemClient.setSpecForItem(messageContext);
    }

    public void getItemsByCategory(MessageContext messageContext) throws MessageContextException {

        itemClient.getItemsByCategory(messageContext);
    }
}
