import java.util.*;
public class DiagonalTraverse {
    public static class Solution {
        public static int[] findDiagonalOrder(int[][] mat) {
            int rows=mat.length;
            int cols=mat[0].length;

            int rowDir=-1;
            int colDir=1;
            int i=0;
            int j=0;
            
            int cont=0;
            int[] answer=new int[rows*cols];

            while (true) {
                answer[cont]=mat[i][j];
                cont++;

                i+=rowDir;
                j+=colDir;
                //Squared matrices case
                if( i<0 && j<cols ) {
                  rowDir*=-1;
                  colDir*=-1; 
                  i+=rowDir;
                } 
                if( j<0 && i<rows ) {
                    colDir*=-1;
                    rowDir*=-1;
                    j+=colDir;
                }
                if ( i<0 && j>=cols ) {
                    rowDir*=-1;
                    colDir*=-1; 
                    i+=(rowDir*2);                  
                    j+=colDir;
                }
                if ( i>=rows && j>=0 ){
                    rowDir*=-1;
                    colDir*=-1; 
                    i+=rowDir;                  
                    j+=(colDir*2);
                }
                if ( j>=cols && j>=0 ){
                    rowDir*=-1;
                    colDir*=-1; 
                    i+=(rowDir*2);                  
                    j+=colDir;
                }
                //Not Squared Matrices considerations
                if ( i>=rows && j<cols) {
                    rowDir*=-1;
                    colDir*=-1; 
                    i+=rowDir;                  
                    j+=(colDir*2);
                }
                if ( j>=cols && i<rows) {
                    rowDir*=-1;
                    colDir*=-1; 
                    i+=(rowDir*2);                  
                    j+=colDir;
                }

                if ( cont>=rows*cols) break;
            }
            return answer;    
        }
    }

    public static void main(String[] args) {

        int[][] input={  {1,2,3,4,5,7,8,9}, 
                         {9,8,7,6,5,4,3,2} 
                      };
        int[] ans=Solution.findDiagonalOrder(input);
        System.out.println( Arrays.toString(ans) );

    }
}