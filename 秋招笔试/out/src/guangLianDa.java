public class guangLianDa {
     public static int max(int[] input,int fee){
         int max=0;
         int min=input[0];
         int cur=0;
         for(int i=0;i<input.length-2;i++){
             min=Math.min(input[i],min);
             if(input[i+1]-input[i+2]>=0&&input[i+1]-min-fee>=input[i+1]-input[i+2]){
                   max+=input[i+1]-min-fee;
                   min=input[i+2];
                   i++;
                   cur=i+1;
             }

         }
         min=input[cur] ;
         int curMax=0;
         while(cur<input.length){
             min=Math.min(input[cur],min);
             curMax=Math.max(input[cur]-min-2,curMax);
             cur++;
         }
         if(curMax>0){
             max+=curMax;
         }
         return max;
     }
     public static void main(String[] args){
         int[] a={1,3,2,8,4,9};
         System.out.println(max(a,2));
     }
    
}
