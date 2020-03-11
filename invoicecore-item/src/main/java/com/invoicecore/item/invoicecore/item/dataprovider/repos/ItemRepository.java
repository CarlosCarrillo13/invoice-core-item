package com.invoicecore.item.invoicecore.item.dataprovider.repos;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemDao, Long> {

    Optional<ItemDao> findBySku(String sku);
    List<ItemDao> findAllByCategoriesContains(ItemCategoryDao itemCategoryDao);
}
