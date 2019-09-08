package xiaoMi;

import java.util.*;



import java.util.Scanner;

public class Main {

    public static int specialDevide(int num1,int num2) {
        if (num1 % num2 == 0){
            return num1 / num2;
        }else{
            return num1 / num2 + 1;
        }
    }

    public static void print(String s,int num){
        System.out.println(s + "\n" +num);
        System.exit(0);
    }

    public static boolean canBlinkTwice(int timeLimit,int nowMagic,int distance){
        int t = specialDevide(20 - nowMagic , 4);
        int t2 = specialDevide(distance, 50);
        if(t + 2 <= timeLimit && t2 >= 2){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int magic = sc.nextInt();
        int distance = sc.nextInt();
        int timeLimit = sc.nextInt();
        int t = timeLimit;//备份源数据
        int dis = distance;//备份源数据
        //阶段1：连续闪烁
        int n = magic / 10;
        int d = n * 50;
        //情况1.1：阶段1中间，时间用尽，而且没有逃出
        if (timeLimit < n && d < distance){
            print("No", timeLimit * 50);
        }
        //情况1.2：阶段1中间，已经逃出了——>（时间用尽，不过已经逃出了）||（时间未用尽，不过已经逃出了）
        if ((t * 50 >= distance && timeLimit <= n) || (d >= distance && timeLimit >= n)){
            print("Yes", specialDevide(distance, 50));
        }
        //情况1.3：阶段1中间，时间未用尽
        magic -= n * 10;
        timeLimit -= n;
        distance -= d;
        //阶段2：连续休息+闪烁，最后跑步
        for (;;){
            if (distance <= 0) print("Yes",t - timeLimit);//时间未到，已经逃脱
            if (timeLimit == 0) print("No",dis - distance);//时间已到，没有逃脱
            int recoverTime = specialDevide(10 - magic, 4);
            //System.out.print("魔法：" + magic + "距离：" + distance + "时间：" + timeLimit);
            if (magic >= 6 && distance >= 26 && timeLimit >= 1){//休息1秒再闪烁
                //System.out.println("休息1秒再闪烁");
                timeLimit -= 2;
                distance -= 50;
                magic = magic + 4 - 10;
                continue;
            }
            if (magic >= 2 && distance >= 39 && timeLimit >= 2){//休息2秒再闪烁
                //System.out.println("休息2秒再闪烁");
                timeLimit -= 3;
                distance -= 50;
                magic = magic + 8 - 10;
                continue;
            }
            if (timeLimit >= 7 && distance >= 100){
                //System.out.println("闪烁闪烁");
                timeLimit -= 7;
                distance -= 100;
                continue;
            }
            //System.out.println("直接跑路");
            timeLimit -= 1;
            distance -= 13;
        }
    }
}
