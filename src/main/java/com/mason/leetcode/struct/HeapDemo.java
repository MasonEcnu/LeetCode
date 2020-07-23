package com.mason.leetcode.struct;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by mwu on 2020/6/9
 */
public class HeapDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HeapDemo heapDemo = new HeapDemo();
        int len = 10;
        int bound = 10;
        Random random = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(bound) + 1;
            heapDemo.bigSiftUp(i, arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    // 小顶堆
    public void smallHeapify(int[] arr) {
        for (int i = (arr.length >>> 1) - 1; i >= 0; i--)
            smallSiftDown(i, arr, arr.length);
    }

    public void smallSiftDown(int index, int[] arr, int realSize) {
        int key = arr[index];
        int half = realSize >>> 1;        // loop while a non-leaf
        while (index < half) {
            int child = (index << 1) + 1; // assume left child is least
            int c = arr[child];
            int right = child + 1;
            if (right < realSize && c > arr[right])
                c = arr[child = right];
            if (key <= c)
                break;
            arr[index] = c;
            index = child;
        }
        arr[index] = key;
    }

    public void smallSiftUp(int index, int[] arr) {
        int key = arr[index];
        while (index > 0) {
            int parent = (index - 1) >>> 1;
            int e = arr[parent];
            if (key >= e)
                break;
            arr[index] = e;
            index = parent;
        }
        arr[index] = key;
    }

    // 大顶堆
    public void bigHeapify(int[] arr) {
        for (int i = (arr.length >>> 1) - 1; i >= 0; i--)
            bigSiftDown(i, arr, arr.length);
    }

    public void bigSiftDown(int index, int[] arr, int size) {
        int key = arr[index];
        int half = size >>> 1;        // loop while a non-leaf
        while (index < half) {
            int child = (index << 1) + 1; // assume left child is least
            int c = arr[child];
            int right = child + 1;
            if (right < size && c < arr[right])
                c = arr[child = right];
            if (key >= c)
                break;
            arr[index] = c;
            index = child;
        }
        arr[index] = key;
    }

    public void bigSiftUp(int index, int[] arr) {
        int key = arr[index];
        while (index > 0) {
            int parent = (index - 1) >>> 1;
            int e = arr[parent];
            if (key <= e)
                break;
            arr[index] = e;
            index = parent;
        }
        arr[index] = key;
    }
}
