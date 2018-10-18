package samsung;
import java.util.*;
public class _2115 {
	static int n,m,c,map[][],tmp[],hap[][],dap=Integer.MIN_VALUE;
	static int sum(int[] arr) {
		Arrays.sort(tmp);
		int result = Integer.MIN_VALUE;
		for(int i=m-1;i>=0;i--) {
			int tmp = c;
			int num=0;
			for(int j=i;j>=0;j--) {
				if(tmp-arr[j]>=0) {
					num+=arr[j]*arr[j];
					tmp-=arr[j];
				}
			}
			result= Math.max(num,result);
		}
		return result;
	}
	static void solve() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-m+1;j++) {
				for(int k=0;k<m;k++) {
					tmp[k] = map[i][j+k];
				}
				hap[i][j]=sum(tmp);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-m+1;j++) {
				int tmp = hap[i][j];
				for(int p =0;p<n;p++) {
					for(int q =0;q<n-m+1;q++) {
						if((i==p)&&(j+m>q)) continue;
						tmp+=hap[p][q];
						dap = Math.max(dap,tmp);
						tmp-=hap[p][q];
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p=1;p<=t;p++) {
			n=sc.nextInt();m=sc.nextInt();c=sc.nextInt();
			map= new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			dap=Integer.MIN_VALUE;
			hap = new int[n][n];
			tmp = new int[m];
			solve();
			System.out.println("#"+p+" "+dap);
			
		}
	}
}
