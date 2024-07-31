package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void updateInventory() {
        boolean isAgedBrie = name.equals("Aged Brie");
        if (isAgedBrie) {
            if (quality < 50) {
                quality = quality + 1;

            }

            sellIn = sellIn - 1;

            if (sellIn < 0) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        } else {
            boolean isBackstagePasses = name.equals("Backstage passes to a TAFKAL80ETC concert");
            if (isBackstagePasses) {
                if (!isBackstagePasses) {
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    if (quality < 50) {
                        quality = quality + 1;

                        if (sellIn < 11) {
                            if (quality < 50) {
                                quality = quality + 1;
                            }
                        }

                        if (sellIn < 6) {
                            if (quality < 50) {
                                quality = quality + 1;
                            }
                        }
                    }
                }

                sellIn = sellIn - 1;

                if (sellIn < 0) {
                    quality = 0;
                }
            } else {
                if (quality > 0) {
                    if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                        quality = quality - 1;
                    }
                }

                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    sellIn = sellIn - 1;
                }

                if (sellIn < 0) {
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            quality = quality - 1;
                        }
                    }
                }
            }
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
