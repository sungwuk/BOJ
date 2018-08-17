import java.util.*;
public class _11057 {
	public static void main(String[] args) {
		int n;
		int dap=0;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		int[][] dp = new int[1002][10];
		Arrays.fill(dp[1], 1);

		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=0;k<=j;k++) {
					int a= dp[i][j];
					int b= dp[i-1][k];
					dp[i][j]=(dp[i][j]+dp[i-1][k]);
				}
			}
		}
		for(int i=0;i<=9;i++) {
			dap+=(dp[n][i]);
		}
		System.out.println(dap%10007);
	}
}
