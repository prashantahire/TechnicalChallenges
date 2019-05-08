package my.challenge.solution.array;

/**
 * 
 * @author prashant
 *
 */
public class Challenge2 {

    /**
     * find k-nearest neighbor
     * data = new int[] {2, 3, 66, 66, 67, 90} // sorted
     * target = 70;
     * k = 3;
     * return {66, 66, 67}
     * k <= data.length
     */
    public static void main(String[] args) {
        int[] a = {2, 3, 30, 60, 67, 90};
        int target = 70;
        int k = 3;

        KClosestElementsFromTarget helper = new KClosestElementsFromTarget();

        int result[] = getKClosestOfkey(a, target, k);

        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }
    public static int[] getKClosestOfkey(int a[], int key, int k) {
        
        int closest[] = new int[k];
        int minIdx = findClosestIndex(a, key);
        closest[0] = a[minIdx];
         int i=minIdx-1;        
         int j = minIdx +1;        
        int m = 1;
        while(m < k) {
            if (i > 0 && j < a.length) {
                if (Math.abs(key - a[i]) < Math.abs(key - a[j])) {
                    closest[m] = a[i];
                    i--;
                }
                else {
                    closest[m] = a[j];
                    j++;
                }
            }
            if( i < 0) {
                closest[m] = a[j];
                j++;
                }
            if(j > a.length) {
                closest[m] = a[i];
                i--;
            }
            m++;
        }
        return closest;
    }
    public static int findClosestIndex(int a[], int key) {
        int low = 0;
        int high = a.length-1;
        int minDiff = Integer.MAX_VALUE;
        int minIdx =0;
        while(low < high) {
            int mid = (low+high)/2;
            if(a[mid] == key)
                return mid;
            if(key < a[mid]) {
                if(minDiff >Math.abs( a[mid]-key))
                {
                    minDiff = Math.abs(a[mid]-key);
                    minIdx = mid;
                }
                high = mid-1;
            }else {
                if(minDiff > Math.abs(a[mid]-key))
                {
                    minDiff = Math.abs(a[mid]-key);
                    minIdx = mid;
                }                
                low = mid+1;
            }
        }
        return minIdx;
    }
}
