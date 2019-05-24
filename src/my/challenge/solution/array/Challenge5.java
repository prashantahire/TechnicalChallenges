

package my.challenge.solution.array;


public class Challenge5 {
    public static void main(String[] args) {
        int[] a = { 0, 0, 4, 0, 0, 8, 0, 0, 9, 0, 10 };
        
        moveZeros(a);
         moveZerosToEnd(a);
         int[] b = { 1, 0, 4, 0, 0, 8, 0, 0, 9, 0, 10 };
         System.out.println();
         moveZerosMaintainOrder(b);
    }

    public static void moveZerosToEnd(int a[]) {

        int i = -1;
        int j = 0;
        while (j < a.length) {
            if (a[j] != 0) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            j++;
        }
        for (int e : a)
            System.out.print(" " + e);
    }

    public static void moveZeros(int a[]) {
        int j = a.length - 1;
        int i = 0;

        while (i < j) {
            while (a[i] != 0)
                i++;
            while (a[j] == 0)
                j--;
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        for (int e : a)
            System.out.print(" " + e);
    }
    
    public static void moveZerosMaintainOrder(int a[]) {
        int count = 0;
        for(int i=0; i<a.length; i++)
            if(a[i] != 0)
                a[count++] = a[i];
        for(int i=count; i<a.length; i++)
            a[i] = 0;
        
        for (int e : a)
            System.out.print(" " + e);
    }
}
