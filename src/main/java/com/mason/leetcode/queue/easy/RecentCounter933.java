package com.mason.leetcode.queue.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mwu on 2019/11/27
 */
public class RecentCounter933 {
  private Queue<Integer> queue;

  public RecentCounter933() {
    queue = new LinkedList<>();
  }

  public int ping(int t) {
    queue.add(t);
    if (!queue.isEmpty()) {
      while (queue.peek() < t - 3000) {
        queue.poll();
      }
    }
    return queue.size();
  }
}
