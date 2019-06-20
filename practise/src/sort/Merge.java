package sort;

public class Merge {
    public static void mergeSort(int[] array, int left, int right) {
        if(right>left){
            int mid=left+(right-left)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int a[] = new int[mid - left + 1];
        int b[] = new int[right - mid];
        for (int i = 0; i < mid - left + 1; i++) {
            a[i] = array[left + i];
        }
        for (int i = 1; i <= right - mid; i++) {
            b[i-1] = array[mid + i];
        }
        int i = 0;
        int j = 0;
        while (i < mid - left + 1 && j < right - mid) {
//            if (a[i] <= b[j]) {
//                array[left+i+j]=a[i];
//                i++;
//            }  else{
//                array[left+i+j]=b[j];
//                j++;
//            }
            array[left+i+j]=a[i] <= b[j]?a[i++]:b[j++] ;
        }
        for(;i<mid - left + 1;i++){
            array[left+i+j]=a[i];
        }
    }

    public static void main(String args[]) {
        int a[] = {12, 5, 7, 8, 3, 1, 9, 78, 34, 2, 5};
        Merge.mergeSort(a, 0, a.length - 1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
