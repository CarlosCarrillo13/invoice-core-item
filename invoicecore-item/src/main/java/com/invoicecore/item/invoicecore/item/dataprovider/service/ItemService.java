package com.invoicecore.item.invoicecore.item.dataprovider.service;

import com.invoicecore.item.invoicecore.item.dataprovider.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;


}
