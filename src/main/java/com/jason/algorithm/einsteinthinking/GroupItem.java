package com.jason.algorithm.einsteinthinking;

import java.util.Arrays;

/**
 * Created by jason-geng on 12/17/17.
 */
public class GroupItem {
    int[] items = new int[5];

    public GroupItem() {
        for (int i = 0; i < 5; i++) {
            items[i] = -1;
        }
    }

    @Override
    public String toString() {
        return "GroupItem{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
