import java.util.*;
public class _1182 {
	static int n,s,dap=0,arr[];
	static boolean[] check;
	static int ch() {
		int a=0,count=0;;
		for(int i=0;i<n;i++) {
			if(check[i]) {
				a+=arr[i];
				count++;
			}
		}
		if(count==0) return Integer.MAX_VALUE;
		return a;
	}
	static void solve(int d) {
		if(ch()==s) {
			dap++;
		}
		for(int i=d;i<n;i++) {
			check[i]=true;
			solve(i+1);
			check[i]=false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		s=sc.nextInt();
		arr = new int[n];
		check = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		solve(0);
		System.out.println(dap);
	}

}
