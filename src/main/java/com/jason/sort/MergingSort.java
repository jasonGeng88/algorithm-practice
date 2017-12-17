package com.jason.sort;

/**
 * Created by jason-geng on 2/19/16.
 * 归并排序
 * 将其拆成若干个子序列,然后进行分而治之
 * 分而治之
 * O(nlogn)
 */
public class MergingSort {
//    int a[]={49,38,65,97,76};
    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};

    public void mergeSort(){
        sort(a, 0, a.length-1);
        showResult();
    }

    private void sort(int[] data, int left, int right){
        int center = (left+right)/2;
        if (left < right){
            sort(data, left, center);
            sort(data, center+1, right);
            merge(data, left, center, right);
        }
    }

    private void merge(int[] data, int left, int center, int right){
        int[] tempArr = new int[data.length];
        int temp = left;
        int third = left;//记录临时数组的索引
        int mid = center + 1;
        while (left <= center && mid <= right){
            //从两个数组中取出最小的放入临时数组
            if (data[left] < data[mid]){
                tempArr[third++] = data[left++];
            }else{
                tempArr[third++] = data[mid++];
            }
        }

        //剩余部分依次放入临时数组
        while (left <= center){
            tempArr[third++] = data[left++];
        }

        while (mid <= right){
            tempArr[third++] = data[mid++];
        }

        //将临时数组中的内容复制回原数组
        while (temp <= right){
            data[temp] = tempArr[temp++];
        }
    }

    private void showResult(){
        for (int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
    }
}
