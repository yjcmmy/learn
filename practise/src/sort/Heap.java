package sort;


public class Heap {
    public static void adjustHeap(int[] array, int cur, int right) {
        int child = 2 * cur + 1;
        if (child <= right) {
            if(child+1<=right&&array[child+1]>array[child]){
                child++;
            }
            if(array[child]>array[cur]){
                int temp=array[cur];
                array[cur]=array[child];
                array[child]= temp;
                adjustHeap(array,child,right);
            }
        }
    }

    public static void getHeap(int[] array){
        int len=array.length;
        for(int i=(len+1)/2-1;i>=0;i--){
            adjustHeap(array,i,len-1);
        }
    }

    public static void heapSort(int[] array){
        getHeap(array);
        for(int i=array.length-1;i>0;i--){
            int temp=array[i];
            array[i]=array[0];
            array[0]=temp;
            adjustHeap(array,0,i-1);
        }
    }


    public static void main(String args[]) {
        int a[] = {12, 5, 7, 8, 3, 1, 9, 78, 34, 2, 5};
        Heap.heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
