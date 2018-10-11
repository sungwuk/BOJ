import java.util.*;
public class _2169 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int map[][] = new int[n][m];
		int dp[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dp[0][0]=map[0][0];
		int t[][] = new int[n][m];
		for(int i=1;i<m;i++) {
			dp[0][i]=map[0][i]+dp[0][i]+dp[0][i-1];
		}
		for(int i=1;i<n;i++) {
			t[0][0]=dp[i-1][0]+map[i][0];
			for(int j=1;j<m;j++) {
				t[0][j]= Math.max(t[0][j-1], dp[i-1][j])+map[i][j];
			}
			t[1][m-1]=dp[i-1][m-1]+map[i][m-1];
			for(int j=m-2;j>=0;j--) {
				t[1][j]= Math.max(t[1][j+1], dp[i-1][j])+map[i][j];
			}
			for(int j=0;j<m;j++) {
				dp[i][j]=Math.max(t[0][j], t[1][j]);
			}
		}
		System.out.println(dp[n-1][m-1]);
	}

}