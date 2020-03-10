package com.invoicecore.item.invoicecore.item.domain.pojo;

import com.invoicecore.item.invoicecore.item.util.enums.MeasureUnit;

import java.math.BigDecimal;

public class ItemSpec {

    private String displayName;

    private Long size;

    private Long quantity;

    private MeasureUnit measureUnit;

    private boolean shippable;

    private BigDecimal unitPrize;


    public ItemSpec(String displayName, Long size, Long quantity, MeasureUnit measureUnit, boolean shippable, BigDecimal unitPrize) {
        this.displayName = displayName;
        this.size = size;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
        this.shippable = shippable;
        this.unitPrize = unitPrize;
    }

    public ItemSpec() {
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

    public Long getQuantity() {
        return this.quantity;
    }

    public MeasureUnit getMeasureUnit() {
        return this.measureUnit;
    }

    public boolean isShippable() {
        return this.shippable;
    }

    public BigDecimal getUnitPrize() {
        return this.unitPrize;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    public void setUnitPrize(BigDecimal unitPrize) {
        this.unitPrize = unitPrize;
    }

    public String toString() {
        return "ItemSpec(displayName=" + this.getDisplayName() + ", size=" + this.getSize() + ", quantity=" + this.getQuantity() + ", measureUnit=" + this.getMeasureUnit() + ", shippable=" + this.isShippable() + ", unitPrize=" + this.getUnitPrize() + ")";
    }

    public static class ItemSpecBuilder {
        private String displayName;
        private Long size;
        private Long quantity;
        private MeasureUnit measureUnit;
        private boolean shippable;
        private BigDecimal unitPrize;

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

        public ItemSpec.ItemSpecBuilder quantity(Long quantity) {
            this.quantity = quantity;
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

        public ItemSpec.ItemSpecBuilder unitPrize(BigDecimal unitPrize) {
            this.unitPrize = unitPrize;
            return this;
        }

        public ItemSpec build() {
            return new ItemSpec(displayName, size, quantity, measureUnit, shippable, unitPrize);
        }

        public String toString() {
            return "ItemSpec.ItemSpecBuilder(displayName=" + this.displayName + ", size=" + this.size + ", quantity=" + this.quantity + ", measureUnit=" + this.measureUnit + ", shippable=" + this.shippable + ", unitPrize=" + this.unitPrize + ")";
        }
    }
}
