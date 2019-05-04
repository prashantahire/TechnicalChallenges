package my.challenge.solution.array;
/**
 * 
 * @author prashant
 *
 */
public class Challenge1 {
    /**
     * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true)
     * then make all the cells of ith row and jth column as 1.
     * 
     * Time : O(n^2)
     * Auxiliary Space O(n)
     * 
     * If auxiliary space need O(1) then conside row 0 and col 0 of Matrix a ar row[] and col[] and solve.
     */
    public static void modifyMatrix(int  a[][]) {
        int row[] = new int[a.length];
        int col[] = new int[a[0].length];
        
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[0].length; j++) {
                if(a[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[0].length; j++) {
                if(row[i] == 1 || col[j] ==1)
                    a[i][j] = 1;
            }
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
    
    public static void main(String ...args) {
        int a[][] = {{1,0,0,1},{0,0,1,0},{0,0,0,0}};
        printMatrix(a);
        modifyMatrix(a);
        System.out.println("Modified Matrix : ");
        printMatrix(a);
    }
}
