package com.jason.algorithm.einsteinthinking;

import static com.jason.algorithm.einsteinthinking.TypeEnum.*;

/**
 *
 * @author jason-geng
 * @date 12/17/17
 */
public class ItemBindCondition {
    ITEM_TYPE firstItemType;
    int firstItemValue;
    ITEM_TYPE secondItemType;
    int secondItemValue;

    public ItemBindCondition(ITEM_TYPE firstItemType, int firstItemValue, ITEM_TYPE secondItemType, int secondItemValue) {
        this.firstItemType = firstItemType;
        this.firstItemValue = firstItemValue;
        this.secondItemType = secondItemType;
        this.secondItemValue = secondItemValue;
    }
}
