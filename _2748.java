import java.util.*;
public class _2748 {
static long dp[]=new long[91];
 static long fibo(int n){
    if (n <2) return dp[n];
    if(dp[n] != 0)
        return dp[n];
    dp[n] = fibo(n - 2) + fibo(n - 1);
    return dp[n];
}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		dp[0]=0;dp[1]=1;
		int n = scan.nextInt();
		System.out.println(fibo(n));
	}
}