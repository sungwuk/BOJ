import java.util.*;
public class _1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt();
			if(n==0) {
				System.out.println(1+" "+0);
			}
			else if(n==1) System.out.println(0+" "+1);
			else {
				int dp1[] = new int[n+1];
				int dp2[] = new int[n+1];
				dp1[0]=1;dp1[1]=0;dp2[0]=0;dp2[1]=1;
				for(int k=2;k<=n;k++) {
					dp1[k] = dp1[k-1]+dp1[k-2];
					dp2[k] = dp2[k-1]+dp2[k-2];
				}
				System.out.println(dp1[n]+" "+dp2[n]);
			}
		}
	}

}
