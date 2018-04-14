import java.util.*;
public class _11052 {

	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int[]price = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			price[i]=scan.nextInt();
		}
		dp[1]=price[1];dp[0]=0;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				dp[i]=Math.max(dp[i-j]+price[j], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
