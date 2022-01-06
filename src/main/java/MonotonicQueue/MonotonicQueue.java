package MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {

  public int[] monotonicQueue(int[] nums, int k) {
    int[] ans = new int[nums.length - k + 1];

    Deque<Integer> queue = new ArrayDeque();

    for (int i = 0; i < nums.length; i++) {
      int startWindowIndex = i - k + 1;

      while (!queue.isEmpty() && (i - queue.peekFirst() >= k)) {
        queue.pollFirst();
      }

      while (!queue.isEmpty() && (nums[queue.peekLast()] <= nums[i])) {
        queue.pollLast();
      }

      queue.addLast(nums[i]);

      if (startWindowIndex >= 0) {
        ans[startWindowIndex] = nums[queue.peekFirst()];
      }
    }

    return ans;

  }

}
