package com.invoicecore.item.invoicecore.item.domain.pojo;

import com.invoicecore.item.invoicecore.item.util.enums.MeasureUnit;

public class ItemSpec {

    private String displayName;

    private Long size;

    private MeasureUnit measureUnit;

    private boolean shippable;


    ItemSpec(String displayName, Long size, MeasureUnit measureUnit, boolean shippable) {
        this.displayName = displayName;
        this.size = size;
        this.measureUnit = measureUnit;
        this.shippable = shippable;
    }

    public static ItemSpecBuilder builder() {
        return new ItemSpecBuilder();
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Long getSize() {
        return this.size;
    }

    public MeasureUnit getMeasureUnit() {
        return this.measureUnit;
    }

    public boolean isShippable() {
        return this.shippable;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    public String toString() {
        return "ItemSpec(displayName=" + this.getDisplayName() + ", size=" + this.getSize() + ", measureUnit=" + this.getMeasureUnit() + ", shippable=" + this.isShippable() + ")";
    }

    public static class ItemSpecBuilder {
        private String displayName;
        private Long size;
        private MeasureUnit measureUnit;
        private boolean shippable;

        ItemSpecBuilder() {
        }

        public ItemSpec.ItemSpecBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public ItemSpec.ItemSpecBuilder size(Long size) {
            this.size = size;
            return this;
        }

        public ItemSpec.ItemSpecBuilder measureUnit(MeasureUnit measureUnit) {
            this.measureUnit = measureUnit;
            return this;
        }

        public ItemSpec.ItemSpecBuilder shippable(boolean shippable) {
            this.shippable = shippable;
            return this;
        }

        public ItemSpec build() {
            return new ItemSpec(displayName, size, measureUnit, shippable);
        }

        public String toString() {
            return "ItemSpec.ItemSpecBuilder(displayName=" + this.displayName + ", size=" + this.size + ", measureUnit=" + this.measureUnit + ", shippable=" + this.shippable + ")";
        }
    }
}
