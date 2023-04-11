public class LargestNumberTwice {
    public static class Solution {
        public static int dominantIndex(int[] nums) {
            int indexLargest=0;
            int largest=nums[0];

            for (int i=1; i<nums.length ; i++) {
                if( largest < nums[i] ) {
                    largest=nums[i];
                    indexLargest=i;
                }
            }

            for (int x=0; x<nums.length ; x++) {
                if( x==indexLargest) continue;
                if( largest>=(2*nums[x]) ) continue;
                else indexLargest=-1;
                break;
            }
            return indexLargest;
        }
    }

    public static void main(String[] args) {

        int[] input={1,2,3,4};
        int ans=Solution.dominantIndex(input);
        System.out.println(ans);

    }
}