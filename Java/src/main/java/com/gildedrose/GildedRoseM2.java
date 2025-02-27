package com.gildedrose;

class GildedRoseM2 implements ItemLab {
    Item[] items;
    private static final int maxQuality = 50;
    private static final int minQuality = 0;

    public GildedRoseM2(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            switch (item.name) {
                case AGE:
                    updateAgedBrie(item);
                    break;

                case BAC:
                    updateBackstagePasses(item);
                    break;

                case SUL:
                    // ...
                    break;

                default:
                    updateNormalItem(item);
                    break;
            }

            if (!item.name.equals(SUL)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                handleExpiredItem(item);
            }
        }
    }

    private void updateNormalItem(Item item) {
        if (item.quality > minQuality) {
            item.quality--;
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < maxQuality) {
            item.quality++;
        }
    }

    private void updateBackstagePasses(Item item) {
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

    private void handleExpiredItem(Item item) {
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
