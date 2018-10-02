import java.util.*;
public class _2146 {
	static boolean map[][];
	static int chk[][],n,index=1;
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int dap = Integer.MAX_VALUE;
	static class Point{
		int x, y,dep;
		Point(int x,int y,int d){
			this.x=x;this.y=y;this.dep=d;
		}
	}
	static void bfs(int x,int y, int ind) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y,0));
		while(!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			q.poll();
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				if(!map[nx][ny])continue;
				if(chk[nx][ny]!=0) continue;
				chk[nx][ny]=ind;
				q.add(new Point(nx,ny,0));
			}
		}
	}
	static void solve(int x) {
		Queue<Point> q =new LinkedList<>();
		boolean tmp[][] =new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(chk[i][j]==x) {
					tmp[i][j]=true;
					q.add(new Point(i,j,0));
				}
			}
		}
		while(!q.isEmpty()) {
			Queue<Point>tmp_q = new LinkedList<>();
			tmp_q.add(q.poll());
			while(!tmp_q.isEmpty()) {
				int cx = tmp_q.peek().x;
				int cy = tmp_q.peek().y;
				int cd = tmp_q.peek().dep;
				tmp[cx][cy]=true; tmp_q.poll();
				for(int i=0;i<4;i++) {
					int nx = cx+dx[i];
					int ny = cy+dy[i];
					if(nx<0||ny<0||nx>=n||ny>=n) continue;
					if(chk[nx][ny]!=0&&chk[nx][ny]!=x) {
						dap= Math.min(dap, cd);
					}
					if(!tmp[nx][ny]&&chk[nx][ny]==0) {
						tmp[nx][ny]=true;
						tmp_q.add(new Point(nx,ny,cd+1));
					}
				}
			}
		    tmp =new boolean[n][n];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		chk = new int[n][n];map = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int a = sc.nextInt();
				if(a==1) map[i][j]=true;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]&&chk[i][j]==0) {
					chk[i][j]=index;
					bfs(i,j,index);index++;
				}
			}
		}
		for(int i=1;i<index;i++) solve(i);
		System.out.println(dap);
	}
}