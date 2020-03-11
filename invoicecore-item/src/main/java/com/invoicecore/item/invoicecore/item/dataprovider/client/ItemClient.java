package com.invoicecore.item.invoicecore.item.dataprovider.client;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemDao;
import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemSpecDao;
import com.invoicecore.item.invoicecore.item.dataprovider.repos.ItemRepository;
import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import com.invoicecore.item.invoicecore.item.util.client.Client;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;

import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemClient implements Client {

    @Autowired
    ItemRepository itemRepository;

    private final Mapper<ItemDao, Item> itemDaoToItemMapper;
    private final Mapper<Item, ItemDao> itemItemDaoMapper;
    private final Mapper<ItemSpec, ItemSpecDao> itemSpecItemSpecDaoMapper;

    public void getBySku(MessageContext messageContext) throws MessageContextException {
        String sku = (String) messageContext.getitem(ItemContext.SKU, String.class);
        ItemDao itemDao = itemRepository.findBySku(sku).get();
        messageContext.addItem(ItemContext.ITEM, itemDaoToItemMapper.map(itemDao));
    }

    @Transactional
    public void setSpecForItem(MessageContext messageContext) throws MessageContextException {
        ItemSpecDao itemSpecDao = itemSpecItemSpecDaoMapper.map((ItemSpec)messageContext.getitem(ItemContext.SPEC, ItemSpec.class));
        ItemDao itemDao = itemRepository.getOne((Long) messageContext.getitem(ItemContext.ITEM_ID, Long.class));
        itemDao.getSpecs().add(itemSpecDao);
        itemRepository.save(itemDao);

    }

    @Transactional
    public void getItemsByCategory(MessageContext messageContext) throws MessageContextException {
        ItemCategoryDao itemCategoryDao = (ItemCategoryDao) messageContext.getitem(ItemContext.CATEGORY, ItemCategoryDao.class);
        List<ItemDao> itemsDao = itemRepository.findAllByCategoriesContains(itemCategoryDao);
        messageContext.addItem(ItemContext.ITEM_LIST, itemsDao.stream().map(
                itemDaoToItemMapper::map).collect(Collectors.toList()));

    }

    @Override
    public void get(MessageContext messageContext) throws MessageContextException {

    }

    @Override
    public void getBy(MessageContext messageContext) throws MessageContextException {

    }

    @Override
    public void save(MessageContext messageContext) throws MessageContextException {

        Item item = (Item) messageContext.getitem(ItemContext.ITEM, Item.class);
        List<ItemCategoryDao> categoryDaos = (List<ItemCategoryDao>) messageContext.getitem(ItemContext.CATEGORY, List.class);
        ItemDao itemDao = itemItemDaoMapper.map(item);
        itemDao.setCategories(categoryDaos);
        itemRepository.save(itemDao);

    }

    @Override
    public void delete(MessageContext messageContext) throws MessageContextException {

    }
}
