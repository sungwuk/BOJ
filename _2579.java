import java.util.*;
public class _2579 {
	public static void main(String[] args) {
		int num;
		Scanner scan = new Scanner(System.in);
		num=scan.nextInt();
		int []dp = new int[num+1];
		int[]step = new int[num+1];
		for(int i=1;i<=num;i++) {
			step[i]=scan.nextInt();
		}
		if(num>=1) {
			dp[1]=step[1];
			if(num>=2) {
				dp[2]=step[2]+dp[1];
				if(num>=3) {
					dp[3]=step[3]+ ((dp[1]>step[2])?dp[1]:step[2]);
				}
			}
		}
		for(int i=4;i<=num;i++) {
			dp[i]=step[i]+(dp[i-2]>(step[i-1]+dp[i-3])? dp[i-2]:step[i-1]+dp[i-3]);
		}
		System.out.println(dp[num]);
	}
}
