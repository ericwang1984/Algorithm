package MonotonicStack;

import java.util.Stack;

public class MonotonicStack {
  public static int[] nextGreaterElement(int[] nums){
    int[] ans = new int[nums.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = nums.length-1; i >=0; i--) {
      while (!stack.isEmpty()&&(nums[i]>=stack.peek())){
        stack.pop();
      }
      ans[i]= stack.isEmpty()?-1:stack.peek();
      stack.push(nums[i]);
    }

    return ans;
  }

}
