package com.invoicecore.item.invoicecore.item.dataprovider.dao;

import com.invoicecore.item.invoicecore.item.domain.pojo.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Entity(name = "item_category")
public class ItemCategoryDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String displayName;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Item> items;
}
