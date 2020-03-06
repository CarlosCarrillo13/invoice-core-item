package com.invoicecore.item.invoicecore.item.dataprovider.dao;

import com.invoicecore.item.invoicecore.item.domain.pojo.ItemCategory;
import com.invoicecore.item.invoicecore.item.domain.pojo.ItemSpec;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Table
@Getter
@Entity(name = "item")
public class ItemDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String UUID;

    private String name;

    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    private List<ItemCategoryDao> categories;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<ItemSpecDao> specs;

}
