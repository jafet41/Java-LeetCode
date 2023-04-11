import java.util.*;
public class PlusOne {
    public static class Solution {
        public static int[] dominantIndex(int[] digits) {
            //----------------Initialize vars----------------
            int[] answer=new int[digits.length];
            boolean leftSurplus=false;
            //--Sum by digit until there is no left Surplus--
            //-----------------------------------------------
            int s=digits.length-1;
            int digitSum;
            do {
                digitSum=digits[s]+1;
                if (digitSum==10) {
                    answer[s]=0;
                    leftSurplus=true;
                } else {
                    answer[s]=digitSum;
                    leftSurplus=false;
                }
                s--;
            } while (leftSurplus && s>=0);
            //----Copying rest of the digits on the left-----
            while(s>=0){
                answer[s]=digits[s];
                s--;
            }
            //----------All digits are 9s case-----------
            if(leftSurplus){
                int[] res=new int[digits.length+1];
                res[0]=1;
                for (int z=1; z<digits.length ; z++) res[z]=answer[z-1];
                return res;
            } else {
                return answer;
            }
        }
    }

    public static void main(String[] args) {

        int[] input={1,2,3,9,9,9};
        int[] ans=Solution.dominantIndex(input);
        System.out.println(Arrays.toString(ans));

    }
}