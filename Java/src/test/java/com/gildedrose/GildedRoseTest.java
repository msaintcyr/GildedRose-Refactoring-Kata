package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 10, 30) };
        Item[] itemas = new Item[] { new Item("foo", 10, 30) };

        GildedRose appRose = new GildedRose(items);
        GildedRoseM2 appMicke = new GildedRoseM2(itemas);
        int days = 20;
        List<String> resultRose = new ArrayList<String>();
        List<String> resultMick = new ArrayList<String>();

        // app.updateQuality();
        // appMicke.updateQuality();

        for (int d = 0; d < days; d++) {
            System.out.println("-------- day " + d + " --------");

            for (int i = 0; i < items.length; i++) {
                resultRose.add(appRose.items[i].toString());
                System.out.println("> Ros > " + appRose.items[i]);

                resultMick.add(appMicke.items[i].toString());
                System.out.println("> Mic > " + appMicke.items[i] + "\n");
            }
            appRose.updateQuality();
            appMicke.updateQuality();
        }
        assertEquals(resultRose, resultMick);
    }
}
