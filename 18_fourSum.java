public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int m = j+1;
                int n = nums.length-1;
                while(m<n){
                    int sum = nums[i]+ nums[j]+nums[m]+ nums[n];
                    if(sum == target){
                        List<Integer> current = new LinkedList<Integer>();
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[m]);
                        current.add(nums[n]);
                        result.add(current);
                        while(m<n-1 && nums[n] == nums[n-1]) n--;
                        while(m+1<n && nums[m] == nums[m+1]) m++; 
                        n--;
                        m++;
                    } else if(sum> target) n--;
                    else m++;
                }
            }
        }
        return result;
    }
}