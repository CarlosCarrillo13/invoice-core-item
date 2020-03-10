package com.invoicecore.item.invoicecore.item.dataprovider.repos;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ItemCategoryDao, Long> {
}
