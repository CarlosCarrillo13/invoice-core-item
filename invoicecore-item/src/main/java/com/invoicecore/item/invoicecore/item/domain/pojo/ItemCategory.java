package com.invoicecore.item.invoicecore.item.domain.pojo;

import java.util.List;

public class ItemCategory {

    private String name;

    private String displayName;

    private List<Item> items;


    ItemCategory(String name, String displayName, List<Item> items) {
        this.name = name;
        this.displayName = displayName;
        this.items = items;
    }

    public static ItemCategoryBuilder builder() {
        return new ItemCategoryBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String toString() {
        return "ItemCategory(name=" + this.getName() + ", displayName=" + this.getDisplayName() + ", items=" + this.getItems() + ")";
    }

    public static class ItemCategoryBuilder {
        private String name;
        private String displayName;
        private List<Item> items;

        ItemCategoryBuilder() {
        }

        public ItemCategory.ItemCategoryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ItemCategory.ItemCategoryBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public ItemCategory.ItemCategoryBuilder items(List<Item> items) {
            this.items = items;
            return this;
        }

        public ItemCategory build() {
            return new ItemCategory(name, displayName, items);
        }

        public String toString() {
            return "ItemCategory.ItemCategoryBuilder(name=" + this.name + ", displayName=" + this.displayName + ", items=" + this.items + ")";
        }
    }
}
