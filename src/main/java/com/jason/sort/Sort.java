/**
 * Created by jason-geng on 2/13/16.
 */
package com.jason.sort;

public class Sort {

    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
//    int a[]={1,54,6,3,78,34,12,45,56,100};

    /**
     * 直接插入排序
     * 假设前面（n-1）[n>=2]个元素已排好序,将第n个元素插入前面的有序数中
     * 类似打扑克牌
     * O(n²)
     */
    public void insertSort(){

        int temp=0;

        for (int i = 1; i < a.length; i++) {
            int j = i-1;
            temp = a[i];
            for (; j >= 0 && temp < a[j] ; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }

        showResult();
    }

    /**
     * 希尔排序（递减增量排序算法）
     * 将序列以步长分成多个列分别进行插入排序
     * 最后当步长为1时,在进行一次插入排序
     * 对插入排序的优化
     * O(nlog²n)
     */
    public void shellSort(){
        double d1 = a.length;
        int temp = 0;

        while (true){
            d1 = Math.ceil(d1/2);
            if (d1%2 == 0)
                d1--;

            for (int i = 0; i < d1; i++) {
                for (int k = i+(int)d1; k < a.length; k+=d1) {
                    int j = k - (int)d1;
                    temp = a[k];
                    for (; j>=0 && temp < a[j] ; j-=d1) {
                        a[j+(int)d1] = a[j];
                    }
                    a[j+(int)d1] = temp;
                }
//                System.out.println(d1);
//                showResult();
            }

            if (d1 == 1)
                break;
        }
        showResult();
    }

    /**
     * 简单选择排序
     * 找出最小数,将其与最前面的数进行交换
     * 除此期间,数组中没有任何数进行交换
     * O(n²)
     */
    public void selectSort(){
        int temp = 0;
        int position = 0;
        for (int i = 0; i < a.length; i++) {
            //采用position,temp,使for循环中仅改变变量,而不是改变数组变量,减小开销
            //事先声明j,减小for循环中反复声明j的开销（因为j声明的是表达式,而不是常量）
            position = i;
            temp = a[i];
            int j = i+1;
            for (; j < a.length; j++) {
                if (a[j] < temp){
                    position = j;
                    temp = a[j];
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
        showResult();
    }

    /**
     * 冒泡排序
     * 每次比较相邻两个数,并进行交换,
     * 区别:而简单选择排序只找到最小数,再进行交换
     * O(n²)
     */
    public void bubbleSort(){
        int temp =0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        showResult();
    }

    private void showResult(){
        for (int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
    }

}
