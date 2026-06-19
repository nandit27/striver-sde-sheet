class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    private static int mergeSort(int[] nums,int low,int high){
        if(low >= high) return 0;
        int mid = (low + high) / 2;
        int cnt = mergeSort(nums,low,mid);
        cnt+= mergeSort(nums,mid+1,high);
        cnt+= countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }
    private static int countPairs(int[] nums,int low,int mid, int high){
        int cnt = 0;
        int right = mid + 1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long) nums[i] > 2L * nums[right]){
                right++;
            }
            cnt+= (right - (mid + 1));
        }
        return cnt;
    }
    private static void merge(int[] nums, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        }
        while(left <= mid) temp.add(nums[left++]);
        while(right <= high) temp.add(nums[right++]);

        for(int i=low;i<=high;i++){
            nums[i] = temp.get(i - low);
        }
    }
}
/*
1. Divide and Conquer with Merge Sort: Use merge sort to recursively divide the array into smaller subarrays.

2. Count Pairs During Merge: Before merging two sorted halves, count the reverse pairs between them:

    For each element in the left half, find how many elements in the right half satisfy the condition nums[i] > 2 * nums[j]
    Since both halves are sorted, we can use two pointers to efficiently count pairs

3. Merge Process: After counting pairs, perform the standard merge operation to maintain the sorted order for subsequent recursive calls.

4. Combine Results: The total count is the sum of:

    Pairs from the left half (recursive call)
    Pairs from the right half (recursive call)
    Pairs between left and right halves (counted during merge)
*/
