package com.invoicecore.item.invoicecore.item.dataprovider.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Getter
@Setter
@Builder
@Entity(name = "item")
public class ItemDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String UUID;

    private String name;

    private String sku;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "item_category")
    private List<ItemCategoryDao> categories;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<ItemSpecDao> specs;

}
