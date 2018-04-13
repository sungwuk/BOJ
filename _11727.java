import java.util.*;
public class _11727 {
	public static void main(String[] args) {
		int n;
		Scanner scan =new Scanner(System.in);
		int []dp = new int[1001];
		n=scan.nextInt();
		dp[1]=1;dp[2]=3;
		for(int i=3;i<=n;i++) {
			dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
		}
		System.out.println(dp[n]);
	}
}