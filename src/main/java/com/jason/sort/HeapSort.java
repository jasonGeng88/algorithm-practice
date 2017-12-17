package com.jason.sort;

/**
 * Created by jason-geng on 2/20/16.
 * 堆排序
 * O(nlogn)
 */
public class HeapSort {
    int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};

    //最大堆调整（Max-Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
    //创建最大堆（Build-Max-Heap）：将堆所有数据重新排序，使其成为最大堆
    //堆排序（Heap-Sort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
    public void sort(){
        buildMaxHeap(a);
        heapSort(a);
        showResult();
    }

    private void buildMaxHeap(int[] data){
        //从末节点的父节点开始
        int lenth = data.length-1;
        int parent = (lenth-1) >> 1;
        for (int i = parent; i >= 0; i--) {
            maxHeapify(data, i, data.length);
        }
    }

    private void heapSort(int[] data){
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            maxHeapify(data, 0, i);
        }
    }

    /**
     * 调整堆中的index顺序
     * @param data
     * @param index
     */
    private void maxHeapify(int[] data, int index, int heapSize){
        int left = (index<<1) + 1;
        int right = (index<<1) + 2;
        int max = index;

        if (left < heapSize && data[max] < data[left])
            max = left;

        if (right < heapSize && data[max] < data[right])
            max = right;

        if (max != index){
            swap(data, index, max);
            index = max;
            maxHeapify(data, max, heapSize);
        }


    }

    private void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void showResult(){
        for (int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
    }
}
