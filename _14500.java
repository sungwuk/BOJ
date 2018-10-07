import java.util.*;
public class _14500 {
	static int map[][],sum=0,n,m,dap = Integer.MIN_VALUE;
	static LinkedList<Point> list = new LinkedList<>();
	static boolean chk[][]; 
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	static boolean check(int x,int y) {
		if(x<0||y<0||x>=n||y>=m) return false;
		return true;
	}
	static void dfs(int x,int y,int c) {
		chk[x][y]=true;
		if(c==4) {
			for(Point a: list) sum+=map[a.x][a.y];
			dap = Math.max(dap, sum);
			sum=0;chk[x][y]=false;
			list.pollLast();
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=m) continue;
			if(chk[nx][ny]) continue;
			list.add(new Point(nx,ny));
			dfs(nx,ny,c+1);
		}
		chk[x][y]=false; list.pollLast();
	}
	static void solve(int x,int y) {
		if(check(x,y+1)&&check(x+1,y)) {
			if(check(x,y-1)) {
				sum=map[x][y]+map[x][y+1]+map[x][y-1]+map[x+1][y];
				dap=Math.max(dap, sum);sum=0;
			}
			if(check(x-1,y)) {
				sum=map[x][y]+map[x+1][y]+map[x][y+1]+map[x-1][y];
				dap=Math.max(dap, sum);sum=0;
			}
		}
		if(check(x-1,y)&&check(x,y-1)) {
			if(check(x,y+1)) {
				sum=map[x][y]+map[x-1][y]+map[x][y+1]+map[x][y-1];
				dap=Math.max(dap, sum);sum=0;
			}
			if(check(x+1,y)) {
				sum=map[x][y]+map[x+1][y]+map[x][y-1]+map[x-1][y];
				dap=Math.max(dap, sum);sum=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new int[n][m];
		chk = new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				list.add(new Point(i,j));
				dfs(i,j,1);sum=0;
				list.clear();
				solve(i,j);						//ㅗ모양은 따로해줘야한다
			}
		}
		System.out.println(dap);
	}
}