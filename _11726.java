import java.util.*;
public class _11726 {
	public static void main(String[] args) {
		int N;
		int [] dp = new int[1001];
		Scanner scan = new Scanner(System.in);
		N= scan.nextInt();
		dp[1]=1;dp[2]=2;
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%10007;
		}
		System.out.println(dp[N]);
	}
}