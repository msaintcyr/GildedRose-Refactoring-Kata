package com.gildedrose;

public class GildedRoseM1 implements ItemLab {
    private Item[] items;
    private CtrlQuality gradeCtrl;
    // private AwareLabels exludItemLabel;

    public GildedRoseM1(Item[] items) {
        this.items = items;
        gradeCtrl = new CtrlQuality(0, 50);
        // this.exludItemLabel = new AwareLabels(new String[] {
        // "Aged Brie",
        // "Backstage passes to a TAFKAL80ETC concert",
        // "Sulfuras, Hand of Ragnaros",
        // "Conjured Mana Cake" // ? check consigne
        // });
    }

    public final Item[] getItems() {
        return this.items;
    }

    public void updateQuality() {
        for (Item product : items) {
            if (gradeCtrl.isGood(product.quality)) {

                switch (product.name) {
                    case AGE:
                        product.quality++;
                        break;

                    case BAC:
                        if (product.sellIn < 6) {
                            product.quality += 3;
                        } else if (product.sellIn < 11) {
                            product.quality += 2;
                        }
                        break;

                    case CON:
                        product.quality -= 2;
                        break;

                    case SUL:

                        break;

                    default:
                        if (product.sellIn < 0) {
                            product.quality -= 1;
                        }
                        break;
                }
            }
            if (!product.name.equals(SUL)) {
                product.sellIn -= 1;

                if (product.sellIn < 0) {

                }
            }
        }
    }
}
