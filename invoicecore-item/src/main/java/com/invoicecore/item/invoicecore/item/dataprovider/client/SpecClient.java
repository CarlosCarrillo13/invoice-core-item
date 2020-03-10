package com.invoicecore.item.invoicecore.item.dataprovider.client;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemSpecDao;
import com.invoicecore.item.invoicecore.item.dataprovider.repos.SpecRepository;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import com.invoicecore.item.invoicecore.item.util.context.ItemContext;
import com.invoicecore.item.invoicecore.item.util.mappers.Mapper;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SpecClient {

    @Autowired
    private SpecRepository specRepository;
    private final Mapper<ItemSpec, ItemSpecDao> itemSpecItemSpecDaoMapper;

    public void getSpec(MessageContext messageContext) throws MessageContextException {

        Long specId = (Long) messageContext.getitem(ItemContext.SPEC, Long.class);
        ItemSpecDao itemSpecDao = specRepository.getOne(specId);
        messageContext.addItem(ItemContext.SPEC, itemSpecDao);

    }
}
