public class PivotIndex {
    public static class Solution {
        public static int pivotIndex(int[] nums) {
            int leftSum=0;
            int rightSum=0;
            int len=nums.length;
            int pivotIndex=0;

            for (int k=1; k<len ; k++) {
                rightSum+=nums[k];
            }
            for (int i=0; i<len; i++) {
                if (leftSum==rightSum) return pivotIndex;
                pivotIndex+=1;
                if(pivotIndex>=len) break;
                leftSum+=nums[i];
                rightSum-=nums[i+1];
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] input={2,1,-1};

        int ans=Solution.pivotIndex(input);
        System.out.println(ans);

        
    }
}