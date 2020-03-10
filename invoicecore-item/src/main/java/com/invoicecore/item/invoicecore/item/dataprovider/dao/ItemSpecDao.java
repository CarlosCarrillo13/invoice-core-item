package com.invoicecore.item.invoicecore.item.dataprovider.dao;

import com.invoicecore.item.invoicecore.item.util.enums.MeasureUnit;
import lombok.*;

import javax.persistence.*;



@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "spec")
public class ItemSpecDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String displayName;

    private Long size;

    private MeasureUnit measureUnit;

    private boolean shippable;
}
