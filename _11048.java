import java.util.*;
public class _11048 {
	static int n,m,map[][],dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map= new int[n+1][m+1]; dp = new int [n+1][m+1];
		for(int i=1;i<=n;i++)for(int j=1;j<=m;j++) dp[i][j]=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dp[1][1]=map[1][1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				int a= i-1,b=j-1;
				if(a<1&&b<1) continue;
				else if(a<1&&b>=1) dp[i][j]= Math.max(dp[i][j-1], dp[i][j]);
				else if(a>=1&&b<1) dp[i][j]= Math.max(dp[i-1][j],dp[i][j]);
				else dp[i][j]= Math.max(dp[i][j-1], Math.max(dp[i-1][j-1], dp[i-1][j]));
				
				dp[i][j]+=map[i][j];
			}
		}
		System.out.println(dp[n][m]);
	}
}