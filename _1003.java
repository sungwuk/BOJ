import java.util.*;
public class _1003 {
	public static void main(String[] args) {
		int T,N;
		Scanner scan = new Scanner(System.in);
		T=scan.nextInt();
		int [][]dp = new int[41][41];
		dp[0][0]=1;dp[0][1]=0;
		dp[1][0]=0;dp[1][1]=1;
		for(int i=0;i<T;i++) {
			N= scan.nextInt();
			for(int j=2;j<=N;j++) {
				dp[j][0]=dp[j-1][0]+dp[j-2][0];
				dp[j][1]=dp[j-1][1]+dp[j-2][1];
			}
			System.out.println(dp[N][0]+" "+dp[N][1]);
		}
	}
}