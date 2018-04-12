import java.util.*;
public class _1463 {

	public static void main(String[] args) {
		int N;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		int [] dp = new int[1000001];
		dp[1]=0;
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+1;
			if(i%3==0) {
				dp[i]= (dp[i/3]+1>dp[i])? dp[i]:dp[i/3]+1;
			}
			if(i%2==0) {
				dp[i]= (dp[i/2]+1>dp[i])? dp[i]:dp[i/2]+1;
			}
		}
		System.out.println(dp[N]);
	}
}