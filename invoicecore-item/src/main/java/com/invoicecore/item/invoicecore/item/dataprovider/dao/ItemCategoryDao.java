package com.invoicecore.item.invoicecore.item.dataprovider.dao;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "category")
public class ItemCategoryDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String displayName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "categories")
    private List<ItemDao> items;
}
