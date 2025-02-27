package com.gildedrose;

public final class CtrlQuality {

    private int min;
    private int max;

    public CtrlQuality(int pMin, int pMax) {
        this.min = pMin;
        this.max = pMax;

        if (pMin > pMax) {
            // TO DO exception
        }
    }

    public boolean isUnderMax(int pQual) {
        return this.max > pQual;
    }

    public boolean isOverMin(int pQual) {
        return this.min < pQual;
    }

    public boolean isGood(int pQual) {
        return isOverMin(pQual) && isUnderMax(pQual);
    }
}
