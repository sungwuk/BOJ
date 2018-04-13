import java.util.*;
public class _14501 {
	static int N;
	static int[]dp;
	static int []T; 
	static int []P ;
	static int sol(int k) {
		if(k==N+1)return 0;
		if(k>N+1)return -100000;
		if(dp[k]!=0)return dp[k];
		return dp[k]=Math.max(sol(k+1),sol(k+T[k])+P[k]);
	}
	public static void main(String[] args) {
		int day;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		T = new int[N+2];
		P = new int[N+2];
		dp=new int[N+2];
		for(int i=1;i<=N;i++) {
			T[i]=scan.nextInt();
			P[i]=scan.nextInt();
		}
		System.out.println(sol(1));
	}


}
