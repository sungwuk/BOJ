import java.util.*;
public class _1937 {
	static int n,count,dap=Integer.MIN_VALUE ,map[][],dp[][];
	static boolean[][] chk;
	static LinkedList<Point> list;
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	static int solve(int x,int y) {
		if(dp[x][y]!=1) return dp[x][y];
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n) continue;
			if(map[x][y]<map[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], solve(nx,ny)+1);
			}
		}
		return dp[x][y];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		dp= new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
				dp[i][j]=1;
			}
		}
		int dap=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dap = Math.max(dap,solve(i,j));
			}
		}
		System.out.println(dap);
	}
}