package com.invoicecore.item.invoicecore.item.dataprovider.repos;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemSpecDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecRepository extends JpaRepository<ItemSpecDao, Long> {
}
