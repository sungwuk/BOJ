import java.util.*;
public class _2606 {
	static boolean[][] map;
	static boolean[] use;
	static int dap=0,com,m;
	static void solve(int i) {
		use[i]=true;
		dap++;
		for(int j=i;j<=com;j++) {
			if(map[i][j]&&!use[j]) solve(j);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		com=sc.nextInt();m=sc.nextInt();
		map = new boolean[101][101];
		use = new boolean[101];
		for(int i=0;i<m;i++) {
			int a=sc.nextInt(),b=sc.nextInt();
			map[a][b]=true;map[b][a]=true;
		}
		use[1]=true;
		for(int i=2;i<=com;i++) {
			if(map[1][i]&&!use[i]) {
				solve(i);
			}
		}
		System.out.println(dap);
	}
}