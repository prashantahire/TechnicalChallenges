

package my.challenge.solution.array;


public class LeftRotationArray {

    /**
     * Time : O(n) Space : O(d)
     * 
     * @param a
     * @param d
     */
    public static void rotateLeft(int a[], int d) {
        int temp[] = new int[d];
        for (int i = 0; i < d; i++)
            temp[i] = a[i];
        int k = 0;
        for (int j = d; j < a.length; j++) {
            a[k] = a[j];
            k++;
        }
        int l = 0;
        for (int i = k; i < a.length; i++) {
            a[i] = temp[l];
            l++;
        }


    }

    // https://www.geeksforgeeks.org/array-rotation/
    /**
     * Time complexity : O(n) Space complexity : O(1)
     */
    public static void leftRotateJuggling(int a[], int d) {

        int j, k, temp;
        for (int i = 0; i < gcd(a.length, d); i++) {
            temp = a[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= a.length)
                    k = k - a.length;
                if (k == i)
                    break;
                a[j] = a[k];
                j = k;
            }
            a[j] = temp;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Reversal algo
    // https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/

    public static void leftRotateReversalAlgo(int a[], int d) {
        reverseArray(a, 0, d-1);
        reverseArray(a, d, a.length-1);
        reverseArray(a, 0, a.length-1);
        
    }

    public static void reverseArray(int a[], int start, int end) {

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String... args) {
        int[] a = { 1, 2, 3, 4, 5 };
        rotateLeft(a, 4);
        printArr(a);
        System.out.println();
        
        int[] b = { 1, 2, 3, 4, 5, 6, 7 };
        leftRotateJuggling(b, 3);
        printArr(b);
        System.out.println();

        int[] c = { 1, 2, 3, 4, 5, 6, 7 };
        leftRotateReversalAlgo(c, 3);
        printArr(c);        
    }

    private static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}

