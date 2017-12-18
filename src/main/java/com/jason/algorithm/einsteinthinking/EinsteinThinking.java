package com.jason.algorithm.einsteinthinking;

import java.util.Arrays;

import static com.jason.algorithm.einsteinthinking.TypeEnum.*;

/**
 * 题目来自: 《算法的乐趣》
 * 爱因斯坦的思考题
 * 多纬度下的穷举法实现
 *
 * @author jason-geng
 * @date 12/17/17
 */
public class EinsteinThinking {
    static ItemBindCondition[] bindConditions = new ItemBindCondition[8];
    static ItemRelationCondition[] relationConditions = new ItemRelationCondition[4];

    static {
        bindConditions[0] = new ItemBindCondition(ITEM_TYPE.NATION, NATION_TYPE.ENGLAND.getType(), ITEM_TYPE.HOUSE, HOUSE_TYPE.RED.getType());
        bindConditions[1] = new ItemBindCondition(ITEM_TYPE.NATION, NATION_TYPE.SWIRZERLAND.getType(), ITEM_TYPE.PET, PET_TYPE.DOG.getType());
        bindConditions[2] = new ItemBindCondition(ITEM_TYPE.NATION, NATION_TYPE.DANMARK.getType(), ITEM_TYPE.DRINK, DRINK_TYPE.TEA.getType());
        bindConditions[3] = new ItemBindCondition(ITEM_TYPE.HOUSE, HOUSE_TYPE.GREEN.getType(), ITEM_TYPE.DRINK, DRINK_TYPE.COOFEE.getType());
        bindConditions[4] = new ItemBindCondition(ITEM_TYPE.CIGERATE, CIGERATE_TYPE.PALL_MALL.getType(), ITEM_TYPE.PET, PET_TYPE.BIRD.getType());
        bindConditions[5] = new ItemBindCondition(ITEM_TYPE.HOUSE, HOUSE_TYPE.YELLOW.getType(), ITEM_TYPE.CIGERATE, CIGERATE_TYPE.DUNHILL.getType());
        bindConditions[6] = new ItemBindCondition(ITEM_TYPE.DRINK, DRINK_TYPE.BEER.getType(), ITEM_TYPE.CIGERATE, CIGERATE_TYPE.BLUE_MASTER.getType());
        bindConditions[7] = new ItemBindCondition(ITEM_TYPE.NATION, NATION_TYPE.GERMANY.getType(), ITEM_TYPE.CIGERATE, CIGERATE_TYPE.PRINCE.getType());

        relationConditions[0] = new ItemRelationCondition(ITEM_TYPE.CIGERATE, CIGERATE_TYPE.BLENDS.getType(), ITEM_TYPE.PET, PET_TYPE.CAT.getType());
        relationConditions[1] = new ItemRelationCondition(ITEM_TYPE.CIGERATE, CIGERATE_TYPE.DUNHILL.getType(), ITEM_TYPE.PET, PET_TYPE.HORSE.getType());
        relationConditions[2] = new ItemRelationCondition(ITEM_TYPE.NATION, NATION_TYPE.NORWAY.getType(), ITEM_TYPE.HOUSE, HOUSE_TYPE.BLUE.getType());
        relationConditions[3] = new ItemRelationCondition(ITEM_TYPE.CIGERATE, CIGERATE_TYPE.BLENDS.getType(), ITEM_TYPE.DRINK, DRINK_TYPE.WATER.getType());
    }

    public static void main(String[] args) {
        GroupItem[] groups = new GroupItem[5];
        for (int i = 0; i < 5; i++) {
            groups[i] = new GroupItem();
        }

        if (enumHouse(groups, 0)){
            System.out.println("房子 国家 饮料 宠物 香烟");

            for (GroupItem item: groups) {
                System.out.println(String.format("%s %s %s %s %s",
                        HOUSE_TYPE.matchValue(item.items[ITEM_TYPE.HOUSE.getType()]),
                        NATION_TYPE.matchValue(item.items[ITEM_TYPE.NATION.getType()]),
                        DRINK_TYPE.matchValue(item.items[ITEM_TYPE.DRINK.getType()]),
                        PET_TYPE.matchValue(item.items[ITEM_TYPE.PET.getType()]),
                        CIGERATE_TYPE.matchValue(item.items[ITEM_TYPE.CIGERATE.getType()])
                ));
            }
        }
    }


    public static boolean enumHouse(GroupItem[] groups, int index){
        if (index == 5){
            return enumNation(groups, 0);
        }
        GroupItem group = groups[index];

        for (int i = 0; i < 4; i++) {
            if (!isGroupItemValueUsed(groups, ITEM_TYPE.HOUSE, i)){
                group.items[ITEM_TYPE.HOUSE.getType()] = i;

                if (HOUSE_TYPE.GREEN.getType() == i) {
                    groups[++index].items[ITEM_TYPE.HOUSE.getType()] = HOUSE_TYPE.WHITE.getType();
                }

                if (enumHouse(groups, index+1)) {
                    return true;
                }

                if (HOUSE_TYPE.GREEN.getType() == i) {
                    groups[index].items[ITEM_TYPE.HOUSE.getType()] = -1;
                    index--;
                }

                group.items[ITEM_TYPE.HOUSE.getType()] = -1;
            }
        }
        return false;
    }

    public static boolean enumNation(GroupItem[] groups, int index){
        if (index == 5){
            return enumDrink(groups, 0);
        }
        GroupItem group = groups[index];

        if (index == 0) {//first guy
            group.items[ITEM_TYPE.NATION.getType()] = NATION_TYPE.NORWAY.getType();

            if (enumNation(groups, index+1)) {
                return true;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (!isGroupItemValueUsed(groups, ITEM_TYPE.NATION, i)){
                    group.items[ITEM_TYPE.NATION.getType()] = i;

                    if (enumNation(groups, index+1)) {
                        return true;
                    }
                    group.items[ITEM_TYPE.NATION.getType()] = -1;
                }
            }
        }
        return false;
    }

    public static boolean enumDrink(GroupItem[] groups, int index){
        if (index == 5){
            return enumPet(groups, 0);
        }
        GroupItem group = groups[index];

        if (index == 2) {//middle guy
            group.items[ITEM_TYPE.DRINK.getType()] = DRINK_TYPE.MILK.getType();

            if (enumDrink(groups, index+1)){
                return true;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (!isGroupItemValueUsed(groups, ITEM_TYPE.DRINK, i)){
                    group.items[ITEM_TYPE.DRINK.getType()] = i;

                    if (enumDrink(groups, index+1)){
                        return true;
                    }
                    group.items[ITEM_TYPE.DRINK.getType()] = -1;
                }
            }
        }
        return false;
    }

    public static boolean enumPet(GroupItem[] groups, int index){
        if (index == 5){
            return enumCigerate(groups, 0);
        }
        GroupItem group = groups[index];

        for (int i = 0; i < 5; i++) {
            if (!isGroupItemValueUsed(groups, ITEM_TYPE.PET, i)){
                group.items[ITEM_TYPE.PET.getType()] = i;

                if (enumPet(groups, index+1)) {
                    return true;
                }
                group.items[ITEM_TYPE.PET.getType()] = -1;
            }
        }
        return false;
    }

    public static boolean enumCigerate(GroupItem[] groups, int index){
        if (index == 5){
            if (validate(groups)) {
                System.out.println(Arrays.toString(groups));
                return false;
            }
            return false;
        }
        GroupItem group = groups[index];

        for (int i = 0; i < 5; i++) {
            if (!isGroupItemValueUsed(groups, ITEM_TYPE.CIGERATE, i)){
                group.items[ITEM_TYPE.CIGERATE.getType()] = i;

                if (enumCigerate(groups, index+1)) {
                    return true;
                }
                group.items[ITEM_TYPE.CIGERATE.getType()] = -1;
            }
        }
        return false;
    }

    public static boolean isGroupItemValueUsed(GroupItem[] groups, ITEM_TYPE type, int value){
        for (int i = 0; i < 5; i++) {
            if (groups[i].items[type.getType()] == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean validate(GroupItem[] groups){
        for (int i = 0; i < 5; i++) {
            GroupItem group =  groups[i];

            for (ItemBindCondition bind: bindConditions) {
                if (group.items[bind.firstItemType.getType()] == bind.firstItemValue) {
                    if (group.items[bind.secondItemType.getType()] != bind.secondItemValue) {
                        return false;
                    }
                }
            }
        }

        for (ItemRelationCondition relation: relationConditions) {
            for (int i = 0; i < 5; i++) {
                GroupItem group =  groups[i];

                if (group.items[relation.itemType.getType()] == relation.itemValue) {

                    if (i == 0) {
                        if (groups[i+1].items[relation.relateItemType.getType()] != relation.relateItemValue) {
                            return false;
                        }
                    } else if (i == 4) {
                        if (groups[i-1].items[relation.relateItemType.getType()] != relation.relateItemValue) {
                            return false;
                        }
                    } else{
                        if (groups[i-1].items[relation.relateItemType.getType()] != relation.relateItemValue && groups[i+1].items[relation.relateItemType.getType()] != relation.relateItemValue) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
