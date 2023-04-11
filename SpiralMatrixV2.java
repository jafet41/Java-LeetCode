import java.util.*;
public class SpiralMatrixV2 {
    public static class Solution {
        public static List<Integer> spiralOrder(int[][] matrix) {
            int rows=matrix.length;
            int cols=matrix[0].length;
            int len=rows*cols;
            List<Integer> answer= new ArrayList<Integer>();

            //Go Right at Start
            int rowDir=0;
            int colDir=1;
            int i=0;
            int j=-1;

            int cont=0;
            int contV=0;
            int cycles=0;
            int virtualPerimeter=2*cols+2*rows-4;

            boolean isVerticalStrip=false;
            if ( (rows>=2&&cols==1) || (rows>=4&&cols==3) ) isVerticalStrip=true;

            while (true) {
                i+=rowDir;
                j+=colDir;
                answer.add( matrix[i][j] );

                cont++;
                contV++;
                
                if (cont>=len) break;

                if ( contV==virtualPerimeter ) {
                    cycles++;
                    virtualPerimeter-=8;
                    contV=0;
                    //Go Right
                    rowDir=0;
                    colDir=1;
                    continue;
                }
                
                //Go Right
                if (i==cycles && j==cycles && !isVerticalStrip) {
                    rowDir=0;
                    colDir=1;
                    continue;
                }
                //Go Down
                if (j==cols-1-cycles && i==cycles) {
                    rowDir=1;
                    colDir=0;
                    continue;
                }
                //Go Left
                if (i==rows-1-cycles && j==cols-1-cycles) {
                    rowDir=0;
                    colDir=-1;
                    continue;
                }

                //Go Up
                if (j==cycles && i==rows-1-cycles) {
                    rowDir=-1;
                    colDir=0;
                    continue;
                }
            }
            return answer;        
        }
    }

    public static void main(String[] args) {

        int[][] input={    {1, 1, 1, 1},
                           {4, 5, 8, 2},
                           {3, 3, 3, 2},
                           
                       };
        List<Integer> ans=Solution.spiralOrder(input);
        System.out.println( Arrays.toString( ans.toArray() ) );
    }
}