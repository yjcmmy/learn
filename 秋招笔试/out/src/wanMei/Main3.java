package wanMei;

public class Main3 {
    //n是数据个数，k是最大操作次数，input是输入第二行的数组
    public static void result(int[] input,int n,int k){
        //a是除以3余1的数的个数，b是除以3余2的数的个数
        int a=0;
        int b=0;
        int result=0;
        for(int i=0;i<n;i++){
             if(input[i]%3==1){
                 a++;
             }
             if(input[i]%3==2){
                 b++;
             }
             if(input[i]%3==0){
                result++;
             }
        }

        int count1=0;
        int count2=0;
        
        if (a >= b) {
             count1=b;
             count2=(a-b)/3;
        }  else{
             count1= a;
             count2=(b-a)/3;
        }
        if(k<=count1){
            result+=k;
        }else{
            result+=count1+Math.min((k-count1)/2,count2);
        }

        System.out.println(result);
    }

    public static void main(String[] args){
        int[] a={3,1,2,3,1};
        result(a,5,1);
    }
}
