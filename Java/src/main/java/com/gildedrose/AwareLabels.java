package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwareLabels {

    private List<String> awareLabels;

    AwareLabels() {
        this.awareLabels = new ArrayList<String>();
    }

    AwareLabels(String pItemLabel[]) {
        this.awareLabels = Arrays.asList(pItemLabel);
    }

    AwareLabels(String pItemLabel) {
        this.awareLabels.add(pItemLabel);
    }

    public boolean addItemLabel(String pItemLabel) {
        return this.awareLabels.add(pItemLabel);
    }

    public List<String> getAwareLabels() {
        return this.awareLabels;
    }
}
