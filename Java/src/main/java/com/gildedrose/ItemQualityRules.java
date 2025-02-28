package com.gildedrose;

public interface ItemQualityRules extends ItemLabel {

    public static int maxQuality = 50;
    public static int minQuality = 0;

    static void updateNormalItem(Item item) {
        if (item.quality > minQuality) {
            item.quality--;
        }
    }

    public static void updateAgedBrie(Item item) {
        if (item.quality < maxQuality) {
            item.quality++;
        }
    }

    public static void updateBackstagePasses(Item item) {
        if (item.quality < maxQuality) {
            item.quality++;

            if (item.sellIn < 11) {
                if (item.quality < maxQuality) {
                    item.quality++;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < maxQuality) {
                    item.quality++;
                }
            }
        }
    }

    public static void updateSulfuras(Item item) {
        // Auto-generated method stub

    }

    public static void handleExpiredItem(Item item) {
        if (item.name.equals(AGE)) {
            if (item.quality < maxQuality) {
                item.quality++;
            }
        } else if (item.name.equals(BAC)) {
            item.quality = 0;
        } else if (item.quality > minQuality) {
            item.quality--;
        }
    }
}
