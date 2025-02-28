package com.gildedrose;

class GildedRoseM2 implements ItemQualityRules {
    Item[] items;

    public GildedRoseM2(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            switch (item.name) {
                case AGE:
                    ItemQualityRules.updateAgedBrie(item);
                    break;

                case BAC:
                    ItemQualityRules.updateBackstagePasses(item);
                    break;

                case SUL:
                    ItemQualityRules.updateSulfuras(item);
                    break;

                default:
                    ItemQualityRules.updateNormalItem(item);
                    break;
            }

            if (!item.name.equals(SUL)) {
                item.sellIn--;
                if (item.sellIn < 0) {
                    ItemQualityRules.handleExpiredItem(item);
                }
            }

        }
    }
}
