package com.gildedrose;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void updateInventory() {
        switch(name) {
            case AGED_BRIE:
                updateAgedBrie();
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                updateBackstagePasses();
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                break;
            default:
                updateRegularItems();
                break;
        }
    }

    private void updateRegularItems() {
        if (quality > 0) {
            quality = quality - 1;
        }
            sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                    quality = quality - 1;
            }
        }
    }

    private void updateBackstagePasses() {
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

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }

    private void updateAgedBrie() {
        if (quality < 50) {
            quality = quality + 1;

        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
