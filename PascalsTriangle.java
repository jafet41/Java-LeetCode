import java.util.*;
public class PascalsTriangle {
    public static class Solution {
        public static List<List<Integer>> generate(int numRows) {

            List<List<Integer>> answer=new ArrayList<>();
            List<Integer> lvl1=new ArrayList<>();
            lvl1.add(1);
            answer.add(lvl1);
            if(numRows==1) return answer;
            List<Integer> lvl2=new ArrayList<>();
            lvl2.add(1);
            lvl2.add(1);
            answer.add(lvl2);
            if(numRows==2) return answer;

            for (int i=3; i<=numRows; i++) {
                List<Integer> newRow=new ArrayList<>();
                for (int j=0; j<numRows; j++) {
                    if(j==0){
                        newRow.add(1);
                        continue;
                    }
                    if (j==i-1) {
                        newRow.add(1);
                        break;
                    }
                    int tmpL=answer.get(i-2).get(j-1);
                    int tmpR=answer.get(i-2).get(j);
                    System.out.println(tmpL+tmpR);
                    newRow.add( (tmpL+tmpR) );
                }
                answer.add(newRow);
            }
            return answer;
        }
    }

    public static void main(String[] args) {

        int input=10;
        List<List<Integer>> ans=Solution.generate(input);
        for (int x=0;x<input ;x++ ) {
            System.out.println( ans.get(x).toString()  );
        }

    }
}