package com.invoicecore.item.invoicecore.item.domain.pojo;

import java.util.List;

public class Item {

    private String UUID;

    private String name;

    private String sku;

    private List<ItemCategory> categories;

    private List<ItemSpec> specs;


    Item(String UUID, String name, String sku, List<ItemCategory> categories, List<ItemSpec> specs) {
        this.UUID = UUID;
        this.name = name;
        this.sku = sku;
        this.categories = categories;
        this.specs = specs;
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public String getUUID() {
        return this.UUID;
    }

    public String getName() {
        return this.name;
    }

    public String getSku() {
        return this.sku;
    }

    public List<ItemCategory> getCategories() {
        return this.categories;
    }

    public List<ItemSpec> getSpecs() {
        return this.specs;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setCategories(List<ItemCategory> categories) {
        this.categories = categories;
    }

    public void setSpecs(List<ItemSpec> specs) {
        this.specs = specs;
    }

    public static class ItemBuilder {
        private String UUID;
        private String name;
        private String sku;
        private List<ItemCategory> categories;
        private List<ItemSpec> specs;

        ItemBuilder() {
        }

        public Item.ItemBuilder UUID(String UUID) {
            this.UUID = UUID;
            return this;
        }

        public Item.ItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Item.ItemBuilder sku(String sku) {
            this.sku = sku;
            return this;
        }

        public Item.ItemBuilder categories(List<ItemCategory> categories) {
            this.categories = categories;
            return this;
        }

        public Item.ItemBuilder specs(List<ItemSpec> specs) {
            this.specs = specs;
            return this;
        }

        public Item build() {
            return new Item(UUID, name, sku, categories, specs);
        }

        public String toString() {
            return "Item.ItemBuilder(UUID=" + this.UUID + ", name=" + this.name + ", sku=" + this.sku + ", categories=" + this.categories + ", specs=" + this.specs + ")";
        }
    }
}
