package my.challenge.solution;
/**
 * 
 * @author prashant
 *
 */
public class Challenge1 {
    /**
     * Given a integer array add one to its concatenated value.
     * [1,2,3,4] -> [1,2,3,5]
     * [9,9,9,9] -> [1,0,0,0,0]
     */
    
    public static int[] addOneToIntArr(int[] a) {
        
        int numToadd = 1;
         for(int i=a.length-1; i>=0; i--) {
             int tempSum = a[i]+numToadd;
             a[i] = tempSum%10;
             numToadd = tempSum/10;
         }
         if(numToadd !=0) {
             int b[] = new int[a.length+1];
             b[0] = numToadd;
             for(int i=1; i<b.length; i++) {
                 b[i] = a[i-1];
             }
             return b;
         }else
             return a;
    }
    
    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

        System.out.println();
    }
    
    public static void main(String[] args) {

        AddOneToArray helper = new AddOneToArray();

        helper.print(helper.addOneToIntArr(new int[]{9, 9, 9, 9}));

        helper.print(helper.addOneToIntArr(new int[]{9, 9, 9, 8}));
    }
}
