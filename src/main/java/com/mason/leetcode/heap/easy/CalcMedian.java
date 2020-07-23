package com.mason.leetcode.heap.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by mwu on 2020/6/9
 */
public class CalcMedian {

    public static void main(String[] args) {
        int n = 20;
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
        System.out.println(Arrays.toString(copyData));
        int half = n >>> 1;
        if (n % 2 == 0) {
            System.out.println((copyData[half - 1] + copyData[half]) / 2.0);
        } else {
            System.out.println(copyData[half]);

        }
        System.out.println("堆方法：");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(half + 1, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(half + 1);

        int numOfElements = 0;
        for (int i = 0; i < n; i++) {
            maxHeap.add(data[i]);
            if (numOfElements % 2 == 0) {

                if (minHeap.isEmpty()) {
                    numOfElements++;
                    continue;
                } else if (maxHeap.peek() > minHeap.peek()) {
                    Integer maxHeapRoot = maxHeap.poll();
                    Integer minHeapRoot = minHeap.poll();
                    maxHeap.add(minHeapRoot);
                    minHeap.add(maxHeapRoot);
                }
            } else {
                minHeap.add(maxHeap.poll());
            }
            numOfElements++;
        }

        if (numOfElements % 2 != 0)        // If total number received is not even
            System.out.println(maxHeap.peek());
        else
            System.out.println((maxHeap.peek() + minHeap.peek()) / 2.0);

    }
}
