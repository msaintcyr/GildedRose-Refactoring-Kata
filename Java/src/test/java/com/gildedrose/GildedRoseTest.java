package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 10, 30) };
        GildedRose app = new GildedRose(items);
        GildedRoseM2 appMicke = new GildedRoseM2(items);
        int days = 20;

        // app.updateQuality();
        // appMicke.updateQuality();

        for (int d = 0; d < days; d++) {
            System.out.println("-------- day " + d + " --------");
            for (int i = 0; i < items.length; i++) {
                assertEquals(app.items[i].sellIn, appMicke.items[i].sellIn);
                assertEquals(app.items[i].quality, appMicke.items[i].quality);
                System.out.println("> Ros > " + appMicke.items[i]);
                System.out.println("> Mic > " + appMicke.items[i] + "\n");
            }
            app.updateQuality();
            appMicke.updateQuality();
        }
    }

}
