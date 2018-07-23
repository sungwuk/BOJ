import java.util.*;
public class _11724 {
	static int n,m;
	static boolean[][] map;
	static boolean[] c;
	static void solve(int x) {
		c[x]=true;
		for(int i=1;i<=n;i++) {
			if(map[x][i]&&!c[i]) solve(i);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new boolean[n+1][n+1];
		c= new boolean[n+1];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b]=true;map[b][a]=true;
		}
		int count=0;
		for(int i=1;i<=n;i++) {
				if(!c[i]) {
					solve(i);
					count++;
				}
		}
		System.out.println(count);
	}
}