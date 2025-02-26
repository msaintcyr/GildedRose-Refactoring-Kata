package com.gildedrose;

public class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public final Item[] getItems() {
        return this.items;
    }

    public final boolean isMaxQual(Item itemTest) {
        return itemTest.quality < 50;
    }

    public final boolean isMinQual(Item itemTest) {
        return itemTest.quality > 0;
    }

    public void updateQuality() {
        for (Item product : items) {
            if (!product.name.equals("Aged Brie") &&
                    !product.name.equals("Backstage passes to a TAFKAL80ETC concert") &&
                    !product.name.equals("Sulfuras, Hand of Ragnaros") &&
                    isMinQual(product)) {
                product.quality--;

            } else if (isMaxQual(product)) {
                product.quality++;

                if (product.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (product.sellIn < 11 &&
                            isMaxQual(product)) {
                        product.quality++;
                    }

                    if (product.sellIn < 6 &&
                            isMaxQual(product)) {
                        product.quality++;
                    }
                }
            }

            if (!product.name.equals("Sulfuras, Hand of Ragnaros")) {
                product.sellIn--;
            }

            if (product.sellIn < 0) {
                if (!product.name.equals("Aged Brie")) {
                    if (!product.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (isMinQual(product) &&
                                !product.name.equals("Sulfuras, Hand of Ragnaros")) {
                            product.quality--;
                        }
                    } else {
                        product.quality -= product.quality;
                    }
                } else if (isMaxQual(product)) {
                    product.quality++;
                }
            }
        }
    }
}
