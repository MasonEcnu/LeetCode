package com.mason.leetcode.heap.easy;

import com.mason.leetcode.struct.HeapDemo;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mwu on 2020/6/8
 */
public class TopK {

    public static void main(String[] args) {
        int n = 20;
        int k = 10;
        int[] data = new int[n];
        int bound = 100;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(bound) + 1;
        }

        System.out.println("原始数据：");
        System.out.println(Arrays.toString(data));

        System.out.println("排序法：");
        int[] copyData = new int[n];
        System.arraycopy(data, 0, copyData, 0, n);
        Arrays.sort(copyData);
        int[] sortedCopyData = new int[k];
        System.arraycopy(copyData, n - k, sortedCopyData, 0, k);
        System.out.println(Arrays.toString(sortedCopyData));

        int[] smallHeap = new int[k];
        HeapDemo heapDemo = new HeapDemo();
        System.out.println("TopK：");
        // 建堆
        System.arraycopy(data, 0, smallHeap, 0, k);
        heapDemo.smallHeapify(smallHeap);

        // 更新堆
        for (int i = k; i < n; i++) {
            if (smallHeap[0] >= data[i]) continue;
            smallHeap[0] = data[i];
            heapDemo.smallSiftDown(0, smallHeap, k);
        }
        Arrays.sort(smallHeap);
        System.out.println(Arrays.toString(smallHeap));
    }
}
