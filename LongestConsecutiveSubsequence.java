class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int maxi = Integer.MIN_VALUE;
        for(int i:set){
            if(set.contains(i-1)) continue;
            int curr = i;
            int cnt = 0;
            while(set.contains(curr++)) cnt++;
            maxi = Math.max(maxi,cnt);
        }
        return maxi;
    }
}
