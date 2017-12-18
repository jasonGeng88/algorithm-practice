package com.jason.algorithm.einsteinthinking;

import com.jason.algorithm.einsteinthinking.TypeEnum.ITEM_TYPE;

/**
 *
 * @author jason-geng
 * @date 12/17/17
 */
public class ItemRelationCondition {
    ITEM_TYPE itemType;
    int itemValue;
    ITEM_TYPE relateItemType;
    int relateItemValue;

    public ItemRelationCondition(ITEM_TYPE itemType, int itemValue, ITEM_TYPE relateItemType, int relateItemValue) {
        this.itemType = itemType;
        this.itemValue = itemValue;
        this.relateItemType = relateItemType;
        this.relateItemValue = relateItemValue;
    }
}
