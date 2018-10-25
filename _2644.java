import java.util.*;
public class _2644 {
	static int n,a,b,m, relat[][],count;
	static boolean flag=true,chk[];
	static void dfs(int s) {
		if(s==b) {
			System.out.println(count);
			flag = false;
			return;
		}
		for(int i = 1;i<=n;i++) {
			if(relat[s][i]==1&&!chk[i]) {
				chk[i]=true;
				count++;
				dfs(i);
				count--;
				chk[i]=false;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a=sc.nextInt();b=sc.nextInt();m=sc.nextInt();
		relat = new int[n+1][n+1];
		chk = new boolean[n+1];
		chk[a]=true;
		for(int i=0;i<m;i++) {
			int p=sc.nextInt(),q=sc.nextInt();
			relat[p][q]=1;
			relat[q][p]=1;
		}
		dfs(a);
		if(flag)System.out.println(-1);
//		System.out.println(count==0? -1:count);
	}
}