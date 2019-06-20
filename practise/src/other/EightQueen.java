package other;

import java.util.ArrayList;
import java.util.List;

public class EightQueen {
    public static void main(String args[]) {
        int map[][] = new int[8][8];
        List<Integer[]> resultList=new ArrayList<>();
        Integer[] cur=new Integer[8];
        EightQueen.nextQueen(0,map,cur,resultList);
        System.out.println(resultList.size());

    }


    public static void nextQueen(int i,int map[][],Integer[] cur,List<Integer[]> resultList) {

        for(int j=0;j<8;j++){
           if(map[i][j]==0){

               cur[i]=j;
               if(i==7){
                   resultList.add(cur);
                   return;
               }

               for(int m=0;m<8;m++){
                   map[i][m]++;
                   map[m][j]++;
               }
               for(int n=0;n<8-j;n++){
                   if(i-n>=0){
                       map[i-n][j+n]++;
                   }
                   if(i+n<8){
                       map[i+n][j+n]++;
                   }
               }
               for(int n=0;n<=j;n++){
                   if(i-n>=0){
                       map[i-n][j-n]++;
                   }
                   if(i+n<8){
                       map[i+n][j-n]++;
                   }
               }
               nextQueen(i+1,map,cur,resultList);
               cur[i]=0;
               for(int m=0;m<8;m++){
                   map[i][m]--;
                   map[m][j]--;
               }
               for(int n=0;n<8-j;n++){
                   if(i-n>=0){
                       map[i-n][j+n]--;
                   }
                   if(i+n<8){
                       map[i+n][j+n]--;
                   }
               }
               for(int n=0;n<=j;n++){
                   if(i-n>=0){
                       map[i-n][j-n]--;
                   }
                   if(i+n<8){
                       map[i+n][j-n]--;
                   }
               }
           }
        }
    }


}
