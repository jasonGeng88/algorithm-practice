package com.jason.sort;

/**
 * Created by jason-geng on 2/19/16.
 * 快速排序
 * 最坏情况 O(n²), 期望情况 O(nlgn)
 * 随机抽样key,来避免最坏情况发生的概率
 */
public class QuickSort {
//    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
//
//    public void quickSort(){
//        if (a.length > 1)
//            _quickSort(a, 0, a.length-1);
//        showResult();
//    }
//
//    private void _quickSort(int[] list, int start, int end){
//        int key = list[start];
//        int i = start;
//        int j = end;
//        while (i < j){
//            while (i<j && list[j] > key){
//                j--;
//            }
//            list[i] = list[j];
//            while (i<j && list[i] <= key){
//                i++;
//            }
//            list[j] = list[i];
//        }
//        list[i] = key;
//
//        if (i-1 > start){
//            _quickSort(list, start, i-1);
//        }
//        if (i+1 < end){
//            _quickSort(list, i+1, end);
//        }
//    }
//
//    private void showResult(){
//        for (int i=0; i<a.length; i++)
//            System.out.print(a[i] + " ");
//    }
    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};

    public void quickSort(){

        quick(a);

        for(int i=0;i<a.length;i++)

            System.out.println(a[i]);

    }

    public int getMiddle(int[] list, int low, int high) {

        int tmp = list[low];    //数组的第一个作为中轴

        while (low < high) {

            while (low < high && list[high] >= tmp) {

                high--;
            }

            list[low] = list[high];   //比中轴小的记录移到低端

            while (low < high && list[low] <= tmp) {

                low++;

            }

            list[high] = list[low];   //比中轴大的记录移到高端

        }

        list[low] = tmp;              //中轴记录到尾

        return low;                   //返回中轴的位置

    }

    public void _quickSort(int[] list, int low, int high) {

        if (low < high) {

            int middle = getMiddle(list, low, high);  //将list数组进行一分为二

            _quickSort(list, low, middle - 1);        //对低字表进行递归排序

            _quickSort(list, middle + 1, high);       //对高字表进行递归排序

        }

    }

    public void quick(int[] a2) {

        if (a2.length > 0) {    //查看数组是否为空

            _quickSort(a2, 0, a2.length - 1);

        }

    }
}
