class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxi = 0;
        int left = 0;
        for(int right = 0;right < s.length(); right++){
            char ch = s.charAt(right);
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }
}
