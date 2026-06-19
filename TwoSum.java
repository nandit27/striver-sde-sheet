class Solution {
    public int[] twoSum(int[] nums, int target) {
       Set<Integer> set = new HashSet<>();
       int[] ans = new int[2];
       for(int i=0;i<nums.length;i++){
        if(set.contains(target - nums[i])){
            ans[0] = i;
        }
        set.add(nums[i]);
       }
       for(int i=0;i<nums.length;i++){
        if(nums[i] == target - nums[ans[0]]){
            ans[1] = i;
            break; 
        }
       }
       return ans;
    }
}
