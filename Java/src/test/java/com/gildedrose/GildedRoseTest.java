package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 10, 30) };
        GildedRose appRose = new GildedRose(items);
        GildedRoseM2 appMicke = new GildedRoseM2(items);
        int days = 20;

        // app.updateQuality();
        // appMicke.updateQuality();

        for (int d = 0; d < days; d++) {
            System.out.println("-------- day " + d + " --------");
            for (int i = 0; i < items.length; i++) {
                assertEquals(appRose.items[i].sellIn, appMicke.items[i].sellIn);
                assertEquals(appRose.items[i].quality, appMicke.items[i].quality);
                System.out.println("> Ros > " + appRose.items[i]);
                System.out.println("> Mic > " + appMicke.items[i] + "\n");
            }
            appRose.updateQuality();
            appMicke.updateQuality();
        }
    }

}
