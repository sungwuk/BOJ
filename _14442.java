import java.util.*;
public class _14442 {
	static int[]dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Point{
		int x,y,chance,dep;
		Point(int x, int y, int d,int c){
			this.x=x;this.y=y;this.dep=d;this.chance=c;
		}
	}
	public static void main(String[] args) {
		int n,m,k;
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();k=sc.nextInt();
		boolean map[][]= new boolean[n+1][m+1];
		boolean dist[][][] = new boolean[n+1][m+1][11];
		for(int i=1;i<=n;i++) {
			String in=sc.next();
			for(int j=1;j<=m;j++) {
				if(in.charAt(j-1)=='0') map[i][j]=true;
			}
		}
		Queue<Point> q= new LinkedList<>();
		q.add(new Point(1,1,1,0));				// 0 ~ k번 부실수 있음.
		dist[1][1][0]=true;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int cx = tmp.x;
			int cy = tmp.y;
			int cd =tmp.dep;
			int cc = tmp.chance;
			if(cx==n&&cy==m) {
				System.out.println(cd);
				return;
			}
			for(int i=0;i<4;i++) {
				int nx =cx+dx[i];
				int ny = cy+dy[i];
				if(nx<1||ny<1||nx>n||ny>m)continue;
				if(dist[nx][ny][cc])continue;
				if(!map[nx][ny]) {
					if(cc<k) {
						dist[nx][ny][cc+1]=true;
						q.add(new Point(nx,ny,cd+1,cc+1));
					}
				}
				else {
					dist[nx][ny][cc]=true;
					q.add(new Point(nx,ny,cd+1,cc));
				}
			}
		}
		System.out.println(-1);
	}
}