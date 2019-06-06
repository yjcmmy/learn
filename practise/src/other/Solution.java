package other;


public class Solution {
    public static int InversePairs(int [] array) {
        long sum=mergeSort(array,0,array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        return (int)sum%1000000007;
    }
    public static long merge(int[] array,int left,int mid,int right){
        long sum=0;
        int l=left;
        int r=mid+1;
        int[] result=new int[right-left+1];
        int i=0;
        while(l<=mid&&r<=right){
            if(array[l]<=array[r]){
                result[i]=array[l];
                sum+=i-l+left;
                l++;
            }else{
                result[i]=array[r++];
            }
            i++;
        }
        while(l<=mid){
            result[i]=array[l];
            sum+=i-l+left;
            l++;
            i++;
        }
        while(r<=right){
            result[i++]=array[r++];
        }
        for(int n=0;n<result.length;n++){
            array[left+n]=result[n];
        }

        if(sum>1000000007)//数值过大求余
        {
            sum%=1000000007;
        }
        return sum;
    }
    public static long mergeSort(int[] array,int left,int right){
        long sum=0;
        if(left<right){
            int mid=(right-left)/2+left;
            long lsum=mergeSort(array,left,mid);
            long rsum=mergeSort(array,mid+1,right);
            long msum=merge(array,left,mid,right);
            sum=sum+lsum+rsum+msum;
            if(sum>1000000007)//数值过大求余
            {
                sum%=1000000007;
            }
        }
        return sum;
    }

    public static void main(String args[]){
        int[] array= {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849
                ,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,
                583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int i = Solution.InversePairs(array);
        System.out.println();
        System.out.println(i);
    }
}