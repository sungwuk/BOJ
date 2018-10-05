import java.util.*;
public class _2167 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int dp[][] = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				dp[i][j]=sc.nextInt();
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+dp[i][j];
			}
		}
		int t = sc.nextInt();
		for(int z=0;z<t;z++) {
			int i = sc.nextInt(),j=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
			System.out.println(dp[x][y] - dp[x][j - 1] - dp[i - 1][y] + dp[i - 1][j - 1]);
		}
	}
}