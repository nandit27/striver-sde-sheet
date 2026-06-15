class Solution {
    public int findDuplicate(int[] nums) {
        for(int num: nums){
            int number = Math.abs(num);
            if(nums[number] < 0) return number;
            nums[number] = -nums[number];
        }
        return nums.length;
    }
}
