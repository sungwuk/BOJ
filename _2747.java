import java.util.*;
public class _2747 {
static int dp[]=new int[46];
	static int fibo(int n) {
		if(dp[n]!=0) {
			return dp[n];
		}
		else {
			if(n>=2) {
				dp[n]= fibo(n-1)+fibo(n-2);
			}
			return dp[n];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		dp[0]=0;dp[1]=1;
		System.out.println(fibo(n));
	}
}