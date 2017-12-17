package com.jason.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason-geng on 2/20/16.
 * 基数排序
 * 序列为正整数
 * O(Kn) -> O(logB(N)·n) B为底,B表示以B为底的位数,如10; N表示符合B为底的数据类型的全集
 * 基数排序一般要快过基于比较的排序，比如快速排序。
 */
public class RadixSort {
    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
//    int a[]={49,38,65,97,76};

    public void sort(){
        radixSort(a);
        showResult();
    }

    private void radixSort(int[] array){
        //1.获取最大数
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        //2.获取最大数的位数
        int time = 0;
        while (max > 0){
            max/=10;
            time++;
        }
        //3.创建0-9 10个数字的队列
        List<ArrayList> queueAll = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queueSingle = new ArrayList<Integer>();
            queueAll.add(queueSingle);
        }
        //4.进行time次分配和收集;
        for (int i = 0; i < time; i++) {
            //分配
            for (int j = 0; j < array.length; j++) {
                //获取第i+1位的数字
                int x =array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
                ArrayList<Integer> queueSpecial = queueAll.get(x);
                queueSpecial.add(array[j]);
//                queueAll.set(x, queueSpecial);
            }

            //收集
            int count = 0;
            for (int k = 0; k < queueAll.size(); k++) {
                while (queueAll.get(k).size() > 0){
                    ArrayList<Integer> queue3 = queueAll.get(k);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }


    }

    private void showResult(){
        for (int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
    }

}
