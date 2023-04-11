import java.util.*;
public class SpiralMatrix {
    public static class Solution {
        public static List<Integer> spiralOrder(int[][] matrix) {
            int rows=matrix.length;
            int cols=matrix[0].length;
            int len=rows*cols;
            List<Integer> answer= new ArrayList<Integer>();

            //Go Right
            System.out.println("Right");
            int rowDir=0;
            int colDir=1;
            int i=0;
            int j=0;

            int cont=0;

            int lim=0;
            int limC=0;
            int virtualPerimeter=2*cols+2*rows-4;
            int contV=0;

            while (true) {
                answer.add( matrix[i][j] );

                cont++;
                contV++;
                
                if (cont>=len) break;

                if ( contV==virtualPerimeter ) {
                    lim++;
                    virtualPerimeter-=8;
                    contV=0;
                }
                i+=rowDir;
                j+=colDir;
                

                if (j>=cols-limC) {
                    //Go Down
                    rowDir=1;
                    colDir=0;
                    j--;
                    i++;
                }
                if (i>=rows-lim) {
                    //Go Left
                    rowDir=0;
                    colDir=-1;
                    i--;
                    j--;
                }
                if (j<0+limC ) {
                    //Go Up
                    rowDir=-1;
                    colDir=0;
                    j++;
                    i--;
                }
                if (i<0+lim) {
                    //Go Right
                    rowDir=0;
                    colDir=1;
                    j++;
                    i++;
                    if (lim!=0) limC=lim;
                }
            }
            return answer;        
        }
    }

    public static void main(String[] args) {

        int[][] input={     {0,0,0,0,0,0,0,0,0,0,0},
                            {5,6,6,6,6,6,6,6,6,6,3},
                            {5,9,4,4,4,4,4,4,4,7,3},
                            {5,9,1,3,3,3,3,3,5,7,3},
                            {5,9,1,5,5,5,5,4,5,7,3},
                            {5,9,2,2,2,2,2,2,5,7,3},
                            {5,8,8,8,8,8,8,8,8,7,3},
                            {4,4,4,4,4,4,4,4,4,4,3},
                      };
        List<Integer> ans=Solution.spiralOrder(input);
        System.out.println( Arrays.toString( ans.toArray() ) );
    }
}