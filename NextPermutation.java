// Find the breaking point where a number is greater than its left side one.
// Find the smallest larger number than the breaking point towards right side of breaking point. 
// Swap them
// Reverse that part of the array from breaking point to end of the array
class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        while (left >= 0) {
            if (nums[left] < nums[left + 1]) {
                break;
            }
            left--;
        }

        if (left < 0) {
            reverse(nums, 0);
            return;
        }
        int mini = left + 1;
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] > nums[left] &&
                nums[i] <= nums[mini]) {
                mini = i;
            }
        }
        int temp = nums[mini];
        nums[mini] = nums[left];
        nums[left] = temp;
        reverse(nums, left + 1);
    }
    public static void reverse(int[] arr,int left) {
        int start = left;
        int end = arr.length - 1;
        
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
}
