package sort;

public class Shell {
    public static void shellSort(int[] array){
        int length = array.length;
        for(int n=length/2;n>=1;n=n/2){
            for(int m=n;m<=length-1;m++){
                int temp=array[m];
                for(int i=m-n;i>=0;i=i-n){
                    if(array[i]>temp) {
                         array[i+n]=array[i];
                    } else {
                        array[i+n]=temp;
                        break;
                    }
                    if(i-n<0){
                        array[i]=temp;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        int a[] = {12, 5, 7, 8, 3, 1, 9, 78, 34, 2, 5};
        Shell.shellSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
