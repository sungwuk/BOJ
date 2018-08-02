import java.util.*;
public class _14889{
	static boolean[] check;
	static int person[][],n,dap=Integer.MAX_VALUE;
	static void calc(){
		int a=0,b=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(check[i]&&check[j]) a+=person[i][j];
				else if(!check[i]&&!check[j]) b+=person[i][j];
			}
		}
		dap = Math.min(dap, Math.abs(a-b));
	}
	static void solve(int count, int dep) {
		if(count==n/2) {
			calc();
		}
		else {
			for(int i=dep+1;i<=n;i++) {
				check[i]= true;
				solve(count+1,i);
				check[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		n= sc.nextInt();
		check = new boolean[n+1];
		person = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				person[i][j] = sc.nextInt();
			}
		}
			solve(0,0);
			System.out.println(dap);
	}

}