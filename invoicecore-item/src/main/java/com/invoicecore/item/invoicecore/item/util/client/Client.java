package com.invoicecore.item.invoicecore.item.util.client;

import context.MessageContext;
import exceptions.MessageContextException;


public interface Client {

    void get(MessageContext messageContext) throws MessageContextException;
    void getBy(MessageContext messageContext) throws MessageContextException;
    void save(MessageContext messageContext) throws MessageContextException;
    void delete(MessageContext messageContext) throws MessageContextException;
}
