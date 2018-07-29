import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        int[] prices=new int[5],months=new int[13];
        int[] dp=new int[13];
        t=sc.nextInt();
        for(int i=0;i<t;i++) {
            for(int j=1;j<=4;j++) {
                prices[j]=sc.nextInt();
            }
            for(int j=1;j<=12;j++) {
                months[j]=sc.nextInt();
            }
                dp[1]=Math.min(prices[2],prices[1]*months[1]);
            dp[2]=dp[1]+Math.min(months[2]*prices[1],prices[2]);
            dp[3]=Math.min(dp[2]+Math.min(prices[1]*months[3],prices[2]), prices[3]);
            for(int j=4;j<=12;j++) {
                dp[j]=Math.min(dp[j-3]+prices[3], dp[j-1]+Math.min(prices[2],prices[1]*months[j]));
            }
            if(dp[12]>prices[4])System.out.println("#"+(i+1)+" "+prices[4]);
            else System.out.println("#"+(i+1)+" "+dp[12]);
        }
    }
}