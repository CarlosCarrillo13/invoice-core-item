package com.invoicecore.item.invoicecore.item.dataprovider.client;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemDao;
import com.invoicecore.item.invoicecore.item.dataprovider.repos.ItemRepository;
import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.util.client.Client;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemClient implements Client {

    @Autowired
    ItemRepository itemRepository;

    private final Mapper<ItemDao, Item> itemDaoToItemMapper;

    public void getBySku(MessageContext messageContext) throws MessageContextException {
        String sku = (String) messageContext.getitem(ItemContext.SKU, String.class);
        ItemDao itemDao = itemRepository.findBySku(sku).get();
        messageContext.addItem(ItemContext.ITEM, itemDaoToItemMapper.map(itemDao));
    }

    @Override
    public void get(MessageContext messageContext) throws MessageContextException {

    }

    @Override
    public void getBy(MessageContext messageContext) throws MessageContextException {

    }

    @Override
    public void save(MessageContext messageContext) throws MessageContextException {

    }

    @Override
    public void delete(MessageContext messageContext) throws MessageContextException {

    }
}
