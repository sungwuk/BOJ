import java.util.*;
public class _11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dp[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			dp[i]=arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]&&dp[i]<dp[j]+arr[i]) {
					dp[i]=dp[j]+arr[i];
				}
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}