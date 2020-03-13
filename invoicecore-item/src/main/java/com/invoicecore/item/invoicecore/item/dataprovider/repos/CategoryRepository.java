package com.invoicecore.item.invoicecore.item.dataprovider.repos;

import com.invoicecore.item.invoicecore.item.dataprovider.dao.ItemCategoryDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<ItemCategoryDao, Long> {

    ItemCategoryDao findByDisplayName(String categoryName);

    List<ItemCategoryDao> findAllByDisplayNameIsLike(String categoryDisplayName);
}
