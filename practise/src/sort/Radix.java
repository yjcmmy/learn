package sort;

public class Radix {
    public static void radixSort(int[] array) {
        int d = 0;
        for (int i = 0; i < array.length; i++) {
            int len = ((String) (array[i] + "")).length();
            d = d >= len ? d : len;
        }

        for (int i = 1; i <= d; i++) {
            int a[][] = new int[10][array.length];
            int b[] = new int[10];
            for (int j = 0; j < array.length; j++) {
                int cur = array[j] / (int) Math.pow(10, i - 1) % 10;
                a[cur][b[cur]] = array[j];
                b[cur]++;
            }
            int k=0;
            for(int m=0;m<10;m++){
                for(int n=0;n<b[m];n++){
                     array[k]=a[m][n];
                     k++;
                }
            }
        }
    }

    public static void main(String args[]) {
        int a[] = {12, 5, 7, 8, 3, 1, 9, 78, 34, 2, 5};
        Radix.radixSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
