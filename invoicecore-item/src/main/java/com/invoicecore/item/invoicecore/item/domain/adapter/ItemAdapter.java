package com.invoicecore.item.invoicecore.item.domain.adapter;

import com.invoicecore.item.invoicecore.item.util.client.Client;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.ws.handler.MessageContext;

@Service
@RequiredArgsConstructor
public class ItemAdapter {

    private final Client ItemClient;

    public void getItem(MessageContext messageContext) throws MessageContextException {

    }
}
