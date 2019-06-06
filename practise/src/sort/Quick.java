package sort;

public class Quick {
    public static void quickSort(int[] array, int left, int right) {
        if (right > left) {
            int mid = array[left];
            int low = left;
            int high = right;
            while (left < right) {
                while (array[right] >= mid && left < right) {
                    right--;
                }
                array[left] = array[right];
                if (array[left] <= mid & left < right) {
                    left++;
                }
                array[right] = array[left];
            }
            array[right] = mid;
            quickSort(array, low, right - 1);
            quickSort(array, right + 1, high);
        }
    }

    public static void main(String args[]) {
        int a[] = {12, 5, 7, 8, 3, 1, 9, 78, 34, 2, 5};
        Quick.quickSort(a, 0, a.length - 1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
