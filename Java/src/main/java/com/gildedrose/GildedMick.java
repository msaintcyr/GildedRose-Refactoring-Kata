package com.gildedrose;

class GildedMick implements ItemQualityRules {
    Item[] items;

    public GildedMick(Item[] items) {
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
