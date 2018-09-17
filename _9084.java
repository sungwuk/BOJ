import java.util.*;
public class _9084 {
	static void solve(int n,int m,int []input) {
		int dp[] = new int[m+1];
		dp[0]=1;
		for(int i=0;i<n;i++) {
			for(int k=input[i];k<=m;k++) {
				dp[k]=dp[k]+dp[k-input[i]];
			}
		}
		System.out.println(dp[m]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt(),m;
			int price[] = new int[n];
			for(int i=0;i<n;i++) {
				price[i]=sc.nextInt();
			}
			m = sc.nextInt();
			solve(n,m,price);
		}
	}
}