package my.challenge.solution;
//https://www.hackerrank.com/challenges/crush/problem
public class Challenge2 {
    
    public static long arrayManipulation(int n, int queries[][]) {
        long maxVal = Long.MIN_VALUE;
        long a[] = new long[n];
        for(int i=0; i<queries.length; i++) {
            for(int j=queries[i][0]-1; j<queries[i][1]; j++) {
                a[j] += queries[i][2];
            }
        }
        for(int i=0; i<n; i++) {
            if(a[i] > maxVal)
                maxVal = a[i];
        }
        return maxVal;
    } 
    
    public static void main(String ...strings) {
        int q[][] = {{1, 2, 100},{2, 5, 100}, {3, 4, 100}};
        System.out.println(arrayManipulation2(5, q));
    }
    
    public static long arrayManipulation2(int n, int queries[][]) {
        long maxVal = Long.MIN_VALUE;
        long a[] = new long[n];
        for(int i=0; i<queries.length; i++) {
            a[queries[i][0]-1] +=queries[i][2];
            if(queries[i][1] < n)
                a[queries[i][1]] -=queries[i][2];
        }
        maxVal = a[0];
        for(int i=1; i<a.length; i++) {
            a[i]+=a[i-1];
            if(a[i]>maxVal)
                maxVal = a[i];
        }
        return maxVal;
    }
}
