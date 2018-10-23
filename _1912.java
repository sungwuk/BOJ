import java.util.*;
public class _1912 {
	static int n,arr[],dp[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		dp[0]=arr[0];
		for(int i=1;i<n;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		int dap=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(dap<dp[i])dap=dp[i];
		}
		System.out.println(dap);
	}
}
